#include "monitoring_system.h"

int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output, size_t buffer_size) {

    if (metric_name == NULL || metric_output == NULL || buffer_size <= 0) {
        return -1;
    }

    if (label_count > 0 && (label_keys == NULL || label_values == NULL)) {
        return -1;
    }

    int written = 0;

    // Use snprintf to format the metric name into the output buffer
    int ret = snprintf(metric_output + written, buffer_size - written, "%s", metric_name);
    if (ret < 0) {
        return -1; // Error in snprintf
    }
    written += ret;

    if (label_count > 0) {
        // Append opening brace for labels
        ret = snprintf(metric_output + written, buffer_size - written, "{");
        if (ret < 0) {
            return -1; // Error in snprintf
        }
        written += ret;

        for (int i = 0; i < label_count; i++) {
            if (label_keys[i] == NULL || label_values[i] == NULL) {
                return -1;
            }

            // Append label key and value in the format: key="value"
            ret = snprintf(metric_output + written, buffer_size - written, "%s=\"%s\"", label_keys[i], label_values[i]);
            if (ret < 0) {
                return -1; // Error in snprintf
            }
            written += ret;

            // Append comma if it's not the last label
            if (i < label_count - 1) {
                ret = snprintf(metric_output + written, buffer_size - written, ",");
                if (ret < 0) {
                    return -1; // Error in snprintf
                }
                written += ret;
            }
        }

        // Append closing brace
        ret = snprintf(metric_output + written, buffer_size - written, "}");
        if (ret < 0) {
            return -1; // Error in snprintf
        }
        written += ret;
    }

    return written;
}