#include "monitoring_system.h"

int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output) {
    if (metric_name == NULL || metric_output == NULL) {
        return -1;
    }
    
    if (label_count > 0 && (label_keys == NULL || label_values == NULL)) {
        return -1;
    }

    int total_length = snprintf(metric_output, 0, "%s{", metric_name);
    if (total_length < 0) {
        return -1;
    }

    for (int i = 0; i < label_count; i++) {
        if (label_keys[i] == NULL || label_values[i] == NULL) {
            return -1;
        }

        int length = snprintf(NULL, 0, "%s=\"%s\",", label_keys[i], label_values[i]);
        if (length < 0) {
            return -1;
        }

        total_length += length;
    }

    // Remove the trailing comma
    if (label_count > 0) {
        total_length -= 1;
    }

    total_length += snprintf(NULL, 0, "}");
    if (total_length < 0) {
        return -1;
    }

    // Allocate memory for the final string including null terminator
    char* formatted_string = (char*)malloc(total_length + 1);
    if (formatted_string == NULL) {
        return -1;
    }

    // Format the string into the allocated memory
    int result = snprintf(formatted_string, total_length + 1, "%s{", metric_name);
    if (result < 0) {
        free(formatted_string);
        return -1;
    }

    for (int i = 0; i < label_count; i++) {
        result += snprintf(formatted_string + result, total_length + 1 - result, "%s=\"%s\",", label_keys[i], label_values[i]);
        if (result < 0) {
            free(formatted_string);
            return -1;
        }
    }

    // Remove the trailing comma
    if (label_count > 0) {
        formatted_string[result - 1] = '}';
    } else {
        formatted_string[result] = '}';
    }

    // Copy the formatted string to the output buffer
    strncpy(metric_output, formatted_string, total_length + 1);
    metric_output[total_length] = '\0';

    // Free the allocated memory
    free(formatted_string);

    return total_length;
}