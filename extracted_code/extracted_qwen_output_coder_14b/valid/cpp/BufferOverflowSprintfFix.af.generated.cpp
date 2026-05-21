#include "monitoring_system.h"

int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output, size_t buffer_size) {

    if (label_count > 0 && (label_keys == NULL || label_values == NULL)) {
        return -1;
    }

    int written = 0;

    // Calculate the maximum possible length of the formatted string
    size_t max_possible_length = strlen(metric_name) + 1; // +1 for the opening brace
    for (int i = 0; i < label_count; i++) {
        if (label_keys[i] == NULL || label_values[i] == NULL) {
            return -1;
        }
        max_possible_length += strlen(label_keys[i]) + strlen(label_values[i]) + 3; // +3 for the "=" and "," and quotes
    }
    if (label_count > 0) {
        max_possible_length += 1; // +1 for the closing brace
    }

    // Check if the buffer is large enough
    if (buffer_size < max_possible_length) {
        return -1;
    }

    // Use snprintf to format the metric name into the output buffer
    written = snprintf(metric_output, buffer_size, "%s", metric_name);

    if (written < 0) {
        return -1; // Error occurred during formatting
    }

    if (label_count > 0) {
        // Append opening brace for labels
        written += snprintf(metric_output + written, buffer_size - written, "{");

        for (int i = 0; i < label_count; i++) {
            if (label_keys[i] == NULL || label_values[i] == NULL) {
                return -1;
            }

            // Append label key and value in the format: key="value"
            written += snprintf(metric_output + written, buffer_size - written, "%s=\"%s\"", label_keys[i], label_values[i]);

            // Append comma if it's not the last label
            if (i < label_count - 1) {
                written += snprintf(metric_output + written, buffer_size - written, ",");
            }
        }

        // Append closing brace
        written += snprintf(metric_output + written, buffer_size - written, "}");
    }

    return written;
}