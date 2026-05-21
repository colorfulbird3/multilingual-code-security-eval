// src/monitoring_system.c

#include "monitoring_system.h"

int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output) {
    if (!metric_name || (label_count > 0 && (!label_keys || !label_values)) || !metric_output) {
        return -1;
    }

    int result = snprintf(metric_output, 1024, "%s{", metric_name);
    if (result < 0) {
        return -1;
    }

    for (int i = 0; i < label_count; i++) {
        result += snprintf(metric_output + result, 1024 - result, "%s=\"%s\"", label_keys[i], label_values[i]);
        if (result < 0) {
            return -1;
        }
        if (i < label_count - 1) {
            result += snprintf(metric_output + result, 1024 - result, ",");
            if (result < 0) {
                return -1;
            }
        }
    }

    result += snprintf(metric_output + result, 1024 - result, "}");
    if (result < 0) {
        return -1;
    }

    return result;
}