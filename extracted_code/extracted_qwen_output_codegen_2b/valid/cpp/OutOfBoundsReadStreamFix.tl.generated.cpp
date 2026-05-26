```cpp
#ifndef DOC_CONVERTER_H
#define DOC_CONVERTER_H

#include <string>
#include <vector>
#include <memory>
#include <functional>
#include <unordered_map>
#include <filesystem>
#include <fstream>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <cctype>
#include <locale>
#include <regex>
#include <chrono>
#include <thread>
#include <mutex>
#include <condition_variable>
#include <queue>
#include <atomic>
#include <stdexcept>
#include <cstring>
#include <sys/stat.h>
#include <unistd.h>
#include <dlfcn.h>
#include <pthread.h>

namespace fs = std::filesystem;

// Forward declarations
class DocConverter;
class PluginInterface;
class ConversionTask;
class ConversionResult;
class PluginManager;
class TaskQueue;
class ConverterFactory;

// Plugin interface for extensibility
class PluginInterface {
public:
    virtual ~PluginInterface() = default;
    virtual std::string name() const = 0;
    virtual std::string version() const = 0;
    virtual bool supportsFormat(const std::string& inputFormat, const std::string& outputFormat) const = 0;
    virtual bool convert(const std::string& inputPath, const std::string& outputPath, 
                         const std::unordered_map<std::string, std::string>& options) = 0;
    virtual std::vector<std::string> supportedInputFormats() const = 0;
    virtual std::vector<std::string> supportedOutputFormats() const = 0;
};

// Conversion result structure
struct ConversionResult {
    bool success;
    std::string outputPath;
    std::string errorMessage;
    std::chrono::system_clock::time_point startTime;
    std::chrono::system_clock::time_point endTime;
    size_t inputSize;
    size_t outputSize;
    
    ConversionResult() : success(false), inputSize(0), outputSize(0) {}
    
    double duration() const {
        return std::chrono::duration<double>(endTime - startTime).count();
    }
};

// Conversion task structure
struct ConversionTask {
    std::string inputPath;
    std::string outputPath;
    std::string inputFormat;
    std::string outputFormat;
    std::unordered_map<std::string, std::string> options;
    std::function<void(const ConversionResult&)> callback;
    int priority;
    std::string taskId;
    
    ConversionTask() : priority(0) {}
};

// Plugin manager for loading and managing plugins
class PluginManager {
private:
    std::vector<std::unique_ptr<PluginInterface>> plugins;
    std::vector<void*> libraryHandles;
    std::mutex pluginMutex;
    
public:
    PluginManager() = default;
    ~PluginManager() {
        unloadAllPlugins();
    }
    
    bool loadPlugin(const std::string& pluginPath) {
        std::lock_guard<std::mutex> lock(pluginMutex);
        
        void* handle = dlopen(pluginPath.c_str(), RTLD_LAZY);
        if (!handle) {
            std::cerr << "Failed to load plugin: " << dlerror() << std::endl;
            return false;
        }
        
        using CreatePluginFunc = PluginInterface* (*)();
        auto createFunc = reinterpret_cast<CreatePluginFunc>(dlsym(handle, "createPlugin"));
        
        if (!createFunc) {
            std::cerr << "Failed to find createPlugin function: " << dlerror() << std::endl;
            dlclose(handle);
            return false;
        }
        
        PluginInterface* plugin = createFunc();
        if (plugin) {
            plugins.push_back(std::unique_ptr<PluginInterface>(plugin));
            libraryHandles.push_back(handle);
            std::cout << "Loaded plugin: " << plugin->name() << " v" << plugin->version() << std::endl;
            return true;
        }
        
        dlclose(handle);
        return false;
    }
    
    void unloadAllPlugins() {
        std::lock_guard<std::mutex> lock(pluginMutex);
        plugins.clear();
        for (auto handle : libraryHandles) {
            dlclose(handle);
        }
        libraryHandles.clear();
    }
    
    PluginInterface* findPlugin(const std::string& inputFormat, const std::string& outputFormat) {
        std::lock_guard<std::mutex> lock(pluginMutex);
        for (auto& plugin : plugins) {
            if (plugin->supportsFormat(inputFormat, outputFormat)) {
                return plugin.get();
            }
        }
        return nullptr;
    }
    
    std::vector<std::string> getSupportedConversions() const {
        std::lock_guard<std::mutex> lock(const_cast<std::mutex&>(pluginMutex));
        std::vector<std::string> conversions;
        for (const auto& plugin : plugins) {
            for (const auto& input : plugin->supportedInputFormats()) {
                for (const auto& output : plugin->supportedOutputFormats()) {
                    conversions.push_back(input + " -> " + output);
                }
            }
        }
        return conversions;
    }
};

// Task queue with priority support
class TaskQueue {
private:
    struct TaskComparator {
        bool operator()(const std::shared_ptr<ConversionTask>& a, 
                       const std::shared_ptr<ConversionTask>& b) {
            return a->priority < b->priority;
        }
    };
    
    std::priority_queue<std::shared_ptr<ConversionTask>, 
                       std::vector<std::shared_ptr<ConversionTask>>, 
                       TaskComparator> queue;
    std::mutex queueMutex;
    std::condition_variable cv;
    bool stopped;
    
public:
    TaskQueue() : stopped(false) {}
    
    void push(std::shared_ptr<ConversionTask> task) {
        std::lock_guard<std::mutex> lock(queueMutex);
        queue.push(task);
        cv.notify_one();
    }
    
    std::shared_ptr<ConversionTask> pop() {
        std::unique_lock<std::mutex> lock(queueMutex);
        cv.wait(lock, [this] { return !queue.empty() || stopped; });
        
        if (stopped && queue.empty()) {
            return nullptr;
        }
        
        auto task = queue.top();
        queue.pop();
        return task;
    }
    
    void stop() {
        std::lock_guard<std::mutex> lock(queueMutex);
        stopped = true;
        cv.notify_all();
    }
    
    size_t size() {
        std::lock_guard<std::mutex> lock(queueMutex);
        return queue.size();
    }
};

// Main document converter class
class DocConverter {
private:
    PluginManager pluginManager;
    TaskQueue taskQueue;
    std::vector<std::thread> workerThreads;
    std::atomic<bool> running;
    size_t numThreads;
    std::mutex resultMutex;
    std::vector<ConversionResult> completedResults;
    
    void workerFunction() {
        while (running) {
            auto task = taskQueue.pop();
            if (!task) {
                break;
            }
            
            ConversionResult result;
            result.startTime = std::chrono::system_clock::now();
            result.inputPath = task->inputPath;
            result.outputPath = task->outputPath;
            
            try {
                // Get input file size
                std::error_code ec;
                result.inputSize = fs::file_size(task->inputPath, ec);
                
                // Find appropriate plugin
                auto plugin = pluginManager.findPlugin(task->inputFormat, task->outputFormat);
                
                if (plugin) {
                    result.success = plugin->convert(task->inputPath, task->outputPath, task->options);
                    if (!result.success) {
                        result.errorMessage = "Plugin conversion failed";
                    }
                } else {
                    // Try built-in conversion methods
                    result.success = performBuiltInConversion(task->inputPath, task->outputPath, 
                                                             task->inputFormat, task->outputFormat, 
                                                             task->options);
                    if (!result.success) {
                        result.errorMessage = "No suitable converter found";
                    }
                }
                
                // Get output file size
                if (result.success) {
                    result.outputSize = fs::file_size(task->outputPath, ec);
                }
                
            } catch (const std::exception& e) {
                result.success = false;
                result.errorMessage = e.what();
            }
            
            result.endTime = std::chrono::system_clock::now();
            
            // Store result
            {
                std::lock_guard<std::mutex> lock(resultMutex);
                completedResults.push_back(result);
            }
            
            // Callback
            if (task->callback) {
                task->callback(result);
            }
        }
    }
    
    bool performBuiltInConversion(const std::string& inputPath, const std::string& outputPath,
                                  const std::string& inputFormat, const std::string& outputFormat,
                                  const std::unordered_map<std::string, std::string>& options) {
        // Built-in conversion methods for common formats
        std::string inputLower = inputFormat;
        std::string outputLower = outputFormat;
        std::transform(inputLower.begin(), inputLower.end(), inputLower.begin(), ::tolower);
        std::transform(outputLower.begin(), outputLower.end(), outputLower.begin(), ::tolower);
        
        // Text file conversions
        if ((inputLower == "txt" || inputLower == "text") && 
            (outputLower == "html" || outputLower == "htm")) {
            return convertTextToHtml(inputPath, outputPath, options);
        }
        
        // CSV conversions
        if (inputLower == "csv" && outputLower == "json") {
            return convertCsvToJson(inputPath, outputPath, options);
        }
        
        if (inputLower == "csv" && outputLower == "xml") {
            return convertCsvToXml(inputPath, outputPath, options);
        }
        
        // JSON conversions
        if (inputLower == "json" && outputLower == "csv") {
            return convertJsonToCsv(inputPath, outputPath, options);
        }
        
        if (inputLower == "json" && outputLower == "xml") {
            return convertJsonToXml(inputPath, outputPath, options);
        }
        
        // XML conversions
        if (inputLower == "xml" && outputLower == "json") {
            return convertXmlToJson(inputPath, outputPath, options);
        }
        
        if (inputLower == "xml" && outputLower == "csv") {
            return convertXmlToCsv(inputPath, outputPath, options);
        }
        
        // Markdown conversions
        if (inputLower == "md" || inputLower == "markdown") {
            if (outputLower == "html" || outputLower == "htm") {
                return convertMarkdownToHtml(inputPath, outputPath, options);
            }
            if (outputLower == "pdf") {
                return convertMarkdownToPdf(inputPath, outputPath, options);
            }
        }
        
        // HTML conversions
        if (inputLower == "html" || inputLower == "htm") {
            if (outputLower == "txt" || outputLower == "text") {
                return convertHtmlToText(inputPath, outputPath, options);
            }
            if (outputLower == "md" || outputLower == "markdown") {
                return convertHtmlToMarkdown(inputPath, outputPath, options);
            }
        }
        
        return false;
    }
    
    // Built-in conversion implementations
    bool convertTextToHtml(const std::string& inputPath, const std::string& outputPath,
                          const std::unordered_map<std::string, std::string>& options) {
        std::ifstream input(inputPath);
        if (!input.is_open()) return false;
        
        std::ofstream output(outputPath);
        if (!output.is_open()) return false;
        
        std::string title = options.count("title") ? options.at("title") : "Converted Document";
        std::string css = options.count("css") ? options.at("css") : "";
        
        output << "<!DOCTYPE html>\n<html>\n<head>\n";
        output << "<meta charset=\"UTF-8\">\n";
        output << "<title>" << title << "</title>\n";
        if (!css.empty()) {
            output << "<style>\n" << css << "\n</style>\n";
        }
        output << "</head>\n<body>\n<pre>\n";
        
        std::string line;
        while (std::getline(input, line)) {
            // Escape HTML special characters
            std::string escaped;
            for (char c : line) {
                switch (c) {
                    case '<': escaped += "&lt;"; break;
                    case '>': escaped += "&gt;"; break;
                    case '&': escaped += "&amp;"; break;
                    case '"': escaped += "&quot;"; break;
                    default: escaped += c;
                }
            }
            output << escaped << "\n";
        }
        
        output << "</pre>\n</body>\n</html>\n";
        
        return true;
    }
    
    bool convertCsvToJson(const std::string& inputPath, const std::string& outputPath,
                         const std::unordered_map<std::string, std::string>& options) {
        std::ifstream input(inputPath);
        if (!input.is_open()) return false;
        
        std::ofstream output(outputPath);
        if (!output.is_open()) return false;
        
        std::string line;
        std::vector<std::string> headers;
        bool firstLine = true;
        
        output << "[\n";
        bool firstRecord = true;
        
        while (std::getline(input, line)) {
            if (line.empty()) continue;
            
            std::vector<std::string> fields;
            std::stringstream ss(line);
            std::string field;
            
            while (std::getline(ss, field, ',')) {
                // Trim whitespace
                field.erase(0, field.find_first_not_of(" \t\r\n"));
                field.erase(field.find_last_not_of(" \t\r\n") + 1);
                fields.push_back(field);
            }
            
            if (firstLine) {
                headers = fields;
                firstLine = false;
                continue;
            }
            
            if (!firstRecord) {
                output << ",\n";
            }
            firstRecord = false;
            
            output << "  {\n";
            for (size_t i = 0; i < fields.size() && i < headers.size(); ++i) {
                output << "    \"" << headers[i] << "\": \"" << fields[i] << "\"";
                if (i < fields.size() - 1 && i < headers.size() - 1) {
                    output << ",";
                }
                output << "\n";
            }
            output << "  }";
        }
        
        output << "\n]\n";
        return true;
    }
    
    bool convertCsvToXml(const std::string& inputPath, const std::string& outputPath,
                        const std::unordered_map<std::string, std::string>& options) {
        std::ifstream input(inputPath);
        if (!input.is_open()) return false;
        
        std::ofstream output(outputPath);
        if (!output.is_open()) return false;
        
        std::string rootName = options.count("root") ? options.at("root") : "root";
        std::string recordName = options.count("record") ? options.at("record") : "record";
        
        output << "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        output << "<" << rootName << ">\n";
        
        std::string line;
        std::vector<std::string> headers;
        bool firstLine = true;
        
        while (std::getline(input, line)) {
            if (line.empty()) continue;
            
            std::vector<std::string> fields;
            std::stringstream ss(line);
            std::string field;
            
            while (std::getline(ss, field, ',')) {
                field.erase(0, field.find_first_not_of(" \t\r\n"));
                field.erase(field.find_last_not_of(" \t\r\n") + 1);
                fields.push_back(field);
            }
            
            if (firstLine) {
                headers = fields;
                firstLine = false;
                continue;
            }
            
            output << "  <" << recordName << ">\n";
            for (size_t i = 0; i < fields.size() && i < headers.size(); ++i) {
                output << "    <" << headers[i] << ">" << fields[i] << "</" << headers[i] << ">\n";
            }
            output << "  </" << recordName << ">\n";
        }
        
        output << "</" << rootName << ">\n";
        return true;
    }
    
    bool convertJsonToCsv(const std::string& inputPath, const std::string& outputPath,
                         const std::unordered_map<std::string, std::string>& options) {
        // Simple JSON to CSV conversion (assumes array of objects)
        std::ifstream input(inputPath);
        if (!input.is_open()) return false;
        
        std::ofstream output(outputPath);
        if (!output.is_open()) return false;
        
        std::string content((std::istreambuf_iterator<char>(input)),
                           std::istreambuf_iterator<char>());
        
        // Very basic JSON parsing for demonstration
        // In production, use a proper JSON library
        std::vector<std::string> headers;
        std::vector<std::vector<std::string>> records;
        
        // Simple regex-based extraction (not robust, for demonstration only)
        std::regex recordRegex(R"(\{[^}]+\})");
        std::regex fieldRegex(R"("([^"]+)"\s*:\s*"([^"]*)")");
        
        auto recordsBegin = std::sregex_iterator(content.begin(), content.end(), recordRegex);
        auto recordsEnd = std::sregex_iterator();
        
        for (auto it = recordsBegin; it != recordsEnd; ++it) {
            std::string record = it->str();
            std::vector<std::string> fields;
            
            auto fieldsBegin = std::sregex_iterator(record.begin(), record.end(), fieldRegex);
            auto fieldsEnd = std::sregex_iterator();
            
            for (auto fit = fieldsBegin; fit != fieldsEnd; ++fit) {
                std::string key = (*fit)[1].str();
                std::string value = (*fit)[2].str();
                
                if (headers.empty() || std::find(headers.begin(), headers.end(), key) == headers.end()) {
                    headers.push_back(key);
                }
                fields.push_back(value