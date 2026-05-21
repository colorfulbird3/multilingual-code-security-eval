#include "monitoring_system.h"

int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output) {
    if (metric_name == NULL || label_count <= 0 || label_keys == NULL || label_values == NULL || metric_output == NULL) {
        return -1;
    }

    int total_length = strlen(metric_name) + 1; // Start with the metric name and the opening brace
    for (int i = 0; i < label_count; i++) {
        total_length += strlen(label_keys[i]) + strlen(label_values[i]) + 3; // Key, equals sign, value, comma
    }
    total_length += 1; // Closing brace

    if (total_length > MAX_BUFFER_SIZE) {
        return -1; // Buffer too small
    }

    int offset = 0;
    offset += snprintf(metric_output + offset, total_length - offset, "%s{", metric_name);

    for (int i = 0; i < label_count; i++) {
        if (i > 0) {
            offset += snprintf(metric_output + offset, total_length - offset, ",");
        }
        offset += snprintf(metric_output + offset, total_length - offset, "%s=\"%s\"", label_keys[i], label_values[i]);
    }

    offset += snprintf(metric_output + offset, total_length - offset, "}");

    return offset;
}