#include "monitoring_system.h"

int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output) {
    if (metric_name == NULL || label_count > 0 && (label_keys == NULL || label_values == NULL) || metric_output == NULL) {
        return -1;
    }

    // Start with the metric name
    size_t len = strlen(metric_name);
    if (len >= strlen(metric_output)) {
        return -1;
    }
    strcpy(metric_output, metric_name);

    // Append the opening brace
    if (len + 1 >= strlen(metric_output)) {
        return -1;
    }
    metric_output[len++] = '{';

    // Append each label key-value pair
    for (int i = 0; i < label_count; i++) {
        if (label_keys[i] == NULL || label_values[i] == NULL) {
            return -1;
        }

        size_t key_len = strlen(label_keys[i]);
        size_t value_len = strlen(label_values[i]);

        if (len + key_len + value_len + 6 >= strlen(metric_output)) {
            return -1;
        }

        len += snprintf(metric_output + len, strlen(metric_output) - len, "%s=\"%s\",", label_keys[i], label_values[i]);
    }

    // Remove the trailing comma and append the closing brace
    if (len > 0 && metric_output[len - 1] == ',') {
        metric_output[--len] = '}';
    } else {
        metric_output[len++] = '}';
    }

    // Null-terminate the string
    metric_output[len] = '\0';

    return len;
}