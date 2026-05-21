int extract_param(const char *msg_body, size_t body_len, char *param_buffer, size_t buffer_size) {
    if (msg_body == NULL || param_buffer == NULL || buffer_size == 0) {
        return -1;
    }

    const char *start = msg_body;
    const char *end = msg_body + body_len;

    // Skip leading whitespace
    while (start < end && (*start == ' ' || *start == '\t' || *start == '\n' || *start == '\r')) {
        start++;
    }

    if (start >= end) {
        return -1;
    }

    // Find the delimiter (assuming ':' as the delimiter)
    const char *delim = start;
    while (delim < end && *delim != ':') {
        delim++;
    }

    if (delim >= end) {
        return -1;
    }

    // Skip the delimiter
    delim++;

    // Skip whitespace after delimiter
    while (delim < end && (*delim == ' ' || *delim == '\t')) {
        delim++;
    }

    // Find the end of the parameter value (assuming newline or end of body)
    const char *value_end = delim;
    while (value_end < end && *value_end != '\n' && *value_end != '\r') {
        value_end++;
    }

    size_t param_len = value_end - delim;
    if (param_len >= buffer_size) {
        return -1;
    }

    // Copy the parameter value
    memcpy(param_buffer, delim, param_len);
    param_buffer[param_len] = '\0';

    return 0;
}