The provided code snippet is a function `format_metric_point` from a monitoring system implementation in C. This function formats a metric point into a string based on the given metric name, label keys, label values, and the number of labels.

Here's a breakdown of the function:

1. **Input Validation**:
   - The function first checks if the `metric_name` or `metric_output` is `NULL`. If either is `NULL`, it returns `-1` indicating an error.
   - It also checks if `label_count` is greater than 0 but either `label_keys` or `label_values` is `NULL`. If so, it returns `-1`.

2. **Buffer Initialization**:
   - A buffer size of 256 bytes is assumed for `metric_output`. This can be adjusted based on actual requirements.

3. **Formatting the Metric Name**:
   - The function uses `snprintf` to safely write the `metric_name` into the `metric_output` buffer. It checks if the operation was successful and updates the `written` and `remaining` variables accordingly.

4. **Appending Labels**:
   - If there are any labels (`label_count > 0`), it starts by appending an opening brace `{`.
   - It then iterates over each label, appending each label key-value pair in the format `key="value"`. If a label key or value is `NULL`, it returns `-1`.
   - A comma `,` is appended after each label except the last one.
   - Finally, it appends a closing brace `}`.

5. **Return Value**:
   - The function returns the total number of characters written to `metric_output`.

This function is useful for formatting metrics in a structured format, which can be particularly helpful for systems that need to log or transmit metric data in a standardized way.