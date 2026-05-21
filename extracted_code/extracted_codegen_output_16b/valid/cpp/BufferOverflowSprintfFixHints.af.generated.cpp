#include "monitoring_system.h"

int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output) {

    if (label_count > 0 && (label_keys == NULL || label_values == NULL)) {
        return -1;
    }

    int written = 0;

    // Use sprintf to format the metric name into the output buffer
    written += sprintf(metric_output + written, "%s", metric_name);

    if (label_count > 0) {
        // Append opening brace for labels
        written += sprintf(metric_output + written, "{");

        for (int i = 0; i < label_count; i++) {
            if (label_keys[i] == NULL || label_values[i] == NULL) {
                continue;
            }

            // Append key for labels
            written += sprintf(metric_output + written, "%s=\"", label_keys[i]);

            // Append value for labels
            written += sprintf(metric_output + written, "%s", label_values[i]);

            // Append comma for labels
            written += sprintf(metric_output + written, ",");
        }

        // Append closing brace for labels
        written += sprintf(metric_output + written, "}");
    }

    return written;
}