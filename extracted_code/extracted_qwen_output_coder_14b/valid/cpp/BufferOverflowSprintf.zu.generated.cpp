#include "monitoring_system.h"

int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output) {
    if (metric_name == NULL || metric_output == NULL) {
        return -1;
    }

    if (label_count > 0 && (label_keys == NULL || label_values == NULL)) {
        return -1;
    }

    // Start building the metric string
    int len = snprintf(metric_output, 1024, "%s{", metric_name);
    if (len < 0) {
        return -1;
    }

    for (int i = 0; i < label_count; ++i) {
        if (label_keys[i] == NULL || label_values[i] == NULL) {
            return -1;
        }

        len += snprintf(metric_output + len, 1024 - len, "%s=\"%s\"", label_keys[i], label_values[i]);
        if (len < 0) {
            return -1;
        }

        if (i < label_count - 1) {
            len += snprintf(metric_output + len, 1024 - len, ",");
            if (len < 0) {
                return -1;
            }
        }
    }

    len += snprintf(metric_output + len, 1024 - len, "}");
    if (len < 0) {
        return -1;
    }

    return len;
}