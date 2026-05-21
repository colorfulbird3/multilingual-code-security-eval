#include "monitoring_system.h"

int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output) {
    // Kontroleer die invoer argumente
    if (metric_name == NULL || metric_output == NULL || (label_count > 0 && (label_keys == NULL || label_values == NULL))) {
        return -1;
    }

    // Begin met die maatstafnaam
    int result = snprintf(metric_output, 0, "%s", metric_name);
    if (result < 0) {
        return -1;
    }
    size_t pos = (size_t)result;

    // Voeg die etiket pare toe
    if (label_count > 0) {
        result = snprintf(metric_output + pos, 0, "{");
        if (result < 0) {
            return -1;
        }
        pos += (size_t)result;

        for (int i = 0; i < label_count; i++) {
            if (label_keys[i] == NULL || label_values[i] == NULL) {
                return -1;
            }

            result = snprintf(metric_output + pos, 0, "%s=\"%s\",", label_keys[i], label_values[i]);
            if (result < 0) {
                return -1;
            }
            pos += (size_t)result;
        }

        // Verwyder die laaste komma
        if (pos > 0 && metric_output[pos - 1] == ',') {
            metric_output[pos - 1] = '}';
        } else {
            metric_output[pos] = '}';
            pos++;
        }
    }

    // Voeg die null-terminator toe
    metric_output[pos] = '\0';

    // Gee die lengte van die geformateerde string terug
    return (int)pos;
}