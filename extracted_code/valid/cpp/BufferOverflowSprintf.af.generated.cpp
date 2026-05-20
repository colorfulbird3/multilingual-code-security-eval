#include "monitoring_system.h"

int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output) {
    if (metric_name == NULL || label_count <= 0 || label_keys == NULL || label_values == NULL || metric_output == NULL) {
        return -1;
    }

    int result_length = snprintf(metric_output, MAX_METRIC_OUTPUT_LENGTH, "%s{", metric_name);
    if (result_length < 0) {
        return -1;
    }

    for (int i = 0; i < label_count; i++) {
        if (i > 0) {
            result_length += snprintf(metric_output + result_length, MAX_METRIC_OUTPUT_LENGTH - result_length, ",");
        }
        result_length += snprintf(metric_output + result_length, MAX_METRIC_OUTPUT_LENGTH - result_length, "%s=\"%s\"", label_keys[i], label_values[i]);
        if (result_length < 0) {
            return -1;
        }
    }

    result_length += snprintf(metric_output + result_length, MAX_METRIC_OUTPUT_LENGTH - result_length, "}");
    if (result_length < 0) {
        return -1;
    }

    return result_length;
}