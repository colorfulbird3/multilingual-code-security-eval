#include "monitoring_system.h"

int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output) {

    if (metric_name == NULL || metric_output == NULL) {
        return -1;
    }

    if (label_count > 0 && (label_keys == NULL || label_values == NULL)) {
        return -1;
    }

    int written = 0;
    int buffer_size = strlen(metric_name) + 1; // Start with the length of the metric name

    // Calculate the total buffer size needed
    for (int i = 0; i < label_count; i++) {
        buffer_size += strlen(label_keys[i]) + strlen(label_values[i]) + 4; // +4 for