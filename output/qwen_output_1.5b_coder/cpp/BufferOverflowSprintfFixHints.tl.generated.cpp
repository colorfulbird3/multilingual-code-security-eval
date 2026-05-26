 label_values, int label_count, char* metric_output) {
    if (metric_name == NULL || label_count > 0 && (label_keys == NULL || label_values == NULL)) {
        return -1;
    }

    char format_string[100];
    snprintf(format_string, sizeof(format_string), "%s{%s=\"%s\"", metric_name, label_keys[0], label_values[0]);
    for (int i = 1; i < label_count; i++) {
        snprintf(format_string + strlen(format_string), sizeof(format_string) - strlen(format_string), ",%s=\"%s\"", label_keys[i], label_values[i]);
    }
    snprintf(metric_output, sizeof(metric_output), "%s}", format_string);
    return strlen(metric_output);
}
            ]]>
        </content>
    </code>
</result>
```


