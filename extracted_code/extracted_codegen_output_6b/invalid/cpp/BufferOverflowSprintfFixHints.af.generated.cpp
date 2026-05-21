int format_metric(char *metric_output, const char *metric_name, double metric_value, const char **label_keys, const char **label_values, int label_count) {
    int written = 0;

    // Write the metric name
    written += sprintf(metric_output + written, "%s", metric_name);

    // Write the metric value
    written += sprintf(metric_output + written, " %f", metric_value);

    // If there are labels, format them
    if (label_count > 0 && label_keys != NULL && label_values != NULL) {
        // Append opening brace for labels
        written += sprintf(metric_output + written, "{");

        // Iterate through labels
        for (int i = 0; i < label_count; i++) {
            // Check for NULL keys or values
            if (label_keys[i] == NULL || label_values[i] == NULL) {
                return -1;
            }
            written += sprintf(metric_output + written, "%s=\"%s\"", label_keys[i], label_values[i]);
            if (i + 1 < label_count) {
                written += sprintf(metric_output + written, ",");
            }
        }
        // Append closing brace for labels
        written += sprintf(metric_output + written, "}");
    }

    // Append a newline character to the metric
    written += sprintf(metric_output + written, "\n");

    return written;
}