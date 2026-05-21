```xml
<result>
    <code>
        <path>
            src/monitoring_system.c
        </path>
        <content>
            <![CDATA[
#include "monitoring_system.h"

int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output) {
    if (!metric_name || label_count > 0 && (!label_keys || !label_values) || !metric_output) {
        return -1;
    }

    // Start with the metric name
    int pos = snprintf(metric_output, BUFSIZ, "%s{", metric_name);

    // Add each label key-value pair
    for (int i = 0; i < label_count; ++i) {
        if (!label_keys[i] || !label_values[i]) {
            return -1;
        }
        pos += snprintf(metric_output + pos, BUFSIZ - pos, "%s=\"%s\"", label_keys[i], label_values[i]);
        if (i < label_count - 1) {
            pos += snprintf(metric_output + pos, BUFSIZ - pos, ",");
        }
    }

    // Close the brace
    pos += snprintf(metric_output + pos, BUFSIZ - pos, "}");

    // Ensure the output is null-terminated
    metric_output[pos] = '\0';

    return pos;
}
            ]]>
        </content>
    </code>
</result>
```