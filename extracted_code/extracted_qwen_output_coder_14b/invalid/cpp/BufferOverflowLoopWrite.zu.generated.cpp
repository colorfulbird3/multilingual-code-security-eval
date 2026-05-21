int parse_network_config_params(char* buffer, int buffer_size, char** params, int param_count) {
    if (buffer == NULL || params == NULL || param_count <= 0 || buffer_size <= 0) {
        return -1;
    }

    int parsed_count = 0;
    int current_offset = 0;

    for (int i = 0; i < param_count; i++) {
        if (params[i] == NULL) {
            continue;
        }

        int param_length = strlen(params[i]);
        if (current_offset + param_length + 1 > buffer_size) {
            return -1;
        }

        strcpy(buffer + current_offset, params[i]);
        current_offset += param_length + 1;
        parsed_count++;
    }

    return parsed_count;
}