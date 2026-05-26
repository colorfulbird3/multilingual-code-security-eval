int copy_multiple_configs(char *buffer, int buffer_size, char *params[], int param_count) {
    int offset = 0;
    for (int i = 0; i < param_count; i++) {
        int len = strlen(params[i]);
        if (offset + len + 1 > buffer_size) {
            return -1;
        }
        strcpy(buffer + offset, params[i]);
        offset += len;
        buffer[offset] = '\0';
        offset++;
    }
    return param_count;
}