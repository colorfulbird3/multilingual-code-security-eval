 || buffer_size < param_count * sizeof(char*)) {
        return -1;
    }

    int total_length = 0;
    for (int i = 0; i < param_count; ++i) {
        total_length += strlen(params[i]) + 1; // Add 1 for null terminator
    }

    if (total_length > buffer_size) {
        return -1;
    }

    int current_index = 0;
    for (int i = 0; i < param_count; ++i) {
        strncpy(buffer + current_index, params[i], strlen(params[i]));
        buffer[current_index + strlen(params[i])] = '\0'; // Null terminate the parameter string
        current_index += strlen(params[i]) + 1;
    }

    return param_count;
}
            ]]>
        </content>
    </code>
</result>
```