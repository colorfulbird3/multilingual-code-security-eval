label_keys, char** label_values, int label_count, char* metric_output) {
    if (metric_name == NULL || label_count > 0 && (label_keys == NULL || label_values == NULL)) {
        return -1;
    }

    // Calculate the maximum required buffer size for the formatted string
    size_t total_length = strlen(metric_name);
    for (int i = 0; i < label_count; ++i) {
        total_length += strlen(label_keys[i]) + strlen(label_values[i]);
    }
    total_length += 1; // For the curly braces and closing brace

    if (total_length >= sizeof(metric_output)) {
        return -1;
    }

    // Format the metric string using snprintf
    snprintf(metric_output, sizeof(metric_output), "%s{%s=\"%s\",%s=\"%s\"}", metric_name, label_keys[0], label_values[0], label_keys[1], label_values[1]);

    return 0;
}