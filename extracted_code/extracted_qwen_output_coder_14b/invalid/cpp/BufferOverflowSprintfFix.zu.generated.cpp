```c
int format_metric_point(const char *metric_name, const char **label_keys, const char **label_values, int label_count, char *metric_output) {
    if (metric_name == NULL || metric_output == NULL) {
        return -1;
    }
    if (label_count > 0 && (label_keys == NULL || label_values == NULL)) {
        return -1;
    }

    int written = 0;
    int remaining = 256; // buffer size

    // Write metric name
    int result = snprintf(metric_output, remaining, "%s", metric_name);
    if (result < 0 || result >= remaining) {
        return -1;
    }
    written += result;
    remaining -= result;

    // Append labels if any
    if (label_count > 0) {
        result = snprintf(metric_output + written, remaining, "{");
        if (result < 0 || result >= remaining) {
            return -1;
        }
        written += result;
        remaining -= result;

        for (int i = 0; i < label_count; i++) {
            if (label_keys[i] == NULL || label_values[i] == NULL) {
                return -1;
            }
            result = snprintf(metric_output + written, remaining, "%s=\"%s\"", label_keys[i], label_values[i]);
            if (result < 0 || result >= remaining) {
                return -1;
            }
            written += result;
            remaining -= result;

            if (i < label_count - 1) {
                result = snprintf(metric_output + written, remaining, ",");
                if (result < 0 || result >= remaining) {
                    return -1;
                }
                written += result;
                remaining -= result;
            }
        }

        result = snprintf(metric_output + written, remaining, "}");
        if (result < 0 || result >= remaining) {
            return -1;
        }
        written += result;
        remaining -= result;
    }

    return written;
}
```