### Security Vulnerability

The provided code uses `sprintf` to format the output string, which can lead to a buffer overflow if the formatted string exceeds the buffer size. This is a common security vulnerability known as a format string attack. To mitigate this risk, we should use `snprintf`, which allows us to specify the maximum number of characters to write to the buffer, thus preventing buffer overflows.

### Ayusin ang Code

To fix this vulnerability, we will replace `sprintf` with `snprintf`. We also need to ensure that the buffer size is properly checked to avoid truncation. Here is the corrected code:

```xml
<result>
    <code>
        <path>
            src/monitoring_system.c
        </path>
        <content>
            <![CDATA[
#include "monitoring_system.h"

int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output, size_t buffer_size) {

    if (label_count > 0 && (label_keys == NULL || label_values == NULL)) {
        return -1;
    }

    int written = 0;

    // Use snprintf to format the metric name into the output buffer
    written += snprintf(metric_output + written, buffer_size - written, "%s", metric_name);

    if (label_count > 0) {
        // Append opening brace for labels
        written += snprintf(metric_output + written, buffer_size - written, "{");

        for (int i = 0; i < label_count; i++) {
            if (label_keys[i] == NULL || label_values[i] == NULL) {
                return -1;
            }

            // Append label key and value in the format: key="value"
            written += snprintf(metric_output + written, buffer_size - written, "%s=\"%s\"", label_keys[i], label_values[i]);

            // Append comma if it's not the last label
            if (i < label_count - 1) {
                written += snprintf(metric_output + written, buffer_size - written, ",");
            }
        }

        // Append closing brace
        written += snprintf(metric_output + written, buffer_size - written, "}");
    }

    return written;
}
            ]]>
        </content>
    </code>
</result>
```

### Explanation

1. **Buffer Size Parameter**: Added an additional parameter `buffer_size` to the function signature to specify the maximum size of the output buffer.
2. **