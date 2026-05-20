#include "monitoring_system.h"

int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output) {

    if (metric_name == NULL || label_count > 0 && (label_keys == NULL || label_values == NULL) || metric_output == NULL) {
        return -1;
    }

    int written = 0;
    int total_length = 0;

    // Calculate the total length needed for the formatted string
    total_length += strlen(metric_name);
    if (label_count > 0) {
        total_length += 1; // Opening brace
        for (int i = 0; i < label_count; i++) {
            total_length += strlen(label_keys[i]) + 2 + strlen(label_values[i]); // key="value" + comma
        }
        total_length += 1; // Closing brace
    }

    // Ensure the buffer is large enough
    if (total_length >= sizeof(metric_output)) {
        return -1;
    }

    // Use snprintf to format the metric name into the output buffer
    written += snprintf(metric_output + written, sizeof(metric_output) - written, "%s", metric_name);

    if (label_count > 0) {
        // Append opening brace for labels
        written += snprintf(metric_output +