 written += sprintf(metric_output + written, "{");

        // Loop through label keys and values, appending them to the output buffer
        for (int i = 0; i < label_count; i++) {
            if (i > 0) {
                written += sprintf(metric_output + written, ",");
            }
            written += sprintf(metric_output + written, "%s=%s", label_keys[i], label_values[i]);
        }

        // Append closing brace for labels
        written += sprintf(metric_output + written, "}");
    }

    return written;
}
            ]]>
        </content>
    </code>
</result>
```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Monitoring System Code Review</title>
</head>
<body>
    <h1>Monitoring System Code Review</h1>
    <div class="result">
        <h2>Code Analysis</h2>
        <p>The provided code snippet is missing the necessary function definition for <code>format_metric_point</code>.</p>
        <p>To complete the code review, please add the following function:</p>
        <pre><code>
int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output);
</code></pre>
        <p>This function should handle the formatting of metric data points as described in the problem statement.</p>
    </div>
</body>
</html>
```

```json
{
    "status": "error",
    "message": "The provided code snippet is missing the necessary function definition for format_metric_point."
}
```

```java
import java.util.Arrays;

public class MonitoringSystem {
    public static int formatMetricPoint(String metricName, String[] labelKeys, String[] labelValues, int labelCount, StringBuilder metricOutput) {
        if (labelCount > 0 && (labelKeys == null || labelValues == null)) {
            return -1;
        }

        metricOutput.append(metricName);

        if (labelCount > 0) {
            metricOutput.append("{");
            for (int i = 0; i < labelCount; i++) {
                if (i > 0) {
                    metricOutput.append(",");
                }
                metricOutput.append(labelKeys[i]).append("=");
                metricOutput.append(labelValues[i]);
            }
            metricOutput.append("}");
        }

        return metricOutput.length();
    }

    public static void main(String[] args) {
        String metricName = "http_requests_total";
        String[] labelKeys = {"method", "status"};
        String[] labelValues = {"GET", "200"};

        StringBuilder metricOutput = new StringBuilder();
        int result = formatMetricPoint(metricName, labelKeys, labelValues, labelKeys.length, metricOutput);

        if (result >= 0) {
            System.out.println("Formatted Metric Point: " + metricOutput.toString());
        } else {
            System.out.println("Failed to format metric point.");
        }
    }
}
```

```python
def format_metric_point(metric_name, label_keys, label_values, label_count):
    if label_count > 0 and (label_keys is None or label_values is None):
        return -1

    formatted_string = metric_name

    if label_count > 0:
        formatted_string += "{"
        for i in range(label_count):
            if i > 0:
                formatted_string += ","
            formatted_string += f"{label_keys[i]}={label_values[i]}"
        formatted_string += "}"

    return len(formatted_string)

# Example usage
metric_name = "http_requests_total"
label_keys = ["method", "status"]
label_values = ["GET", "200"]

formatted_string = format_metric_point(metric_name, label_keys, label_values, len(label_keys))
print("Formatted Metric Point:", formatted_string)
```

```cpp
#include <iostream>
#include <vector>
#include <sstream>

std::string format_metric_point(const std::string& metric_name, const std::vector<std::string>& label_keys, const std::vector<std::string>& label_values, int label_count) {
    if (label_count > 0 && (label_keys.empty() || label_values.empty())) {
        return "";
    }

    std::stringstream ss;
    ss << metric_name;

    if (!label_keys.empty()) {
        ss << "{";
        for (size_t i = 0; i < label_count; ++i) {
            if (i > 0) {
                ss << ",";
            }
            ss << label_keys[i] << "=" << label_values[i];
        }
        ss << "}";
    }

    return ss.str();
}

int main() {
    std::string metric_name = "http_requests_total";
    std::vector<std::string> label_keys