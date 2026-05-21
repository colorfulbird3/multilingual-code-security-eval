int process_protole_message(const char* msg_body, int body_len, char* param_buffer, int buffer_size) {
    if (msg_body == NULL || param_buffer == NULL || buffer_size <= 0 || body_len <= 0) {
        return -1;
    }
    
    int msg_len = strlen(msg_body);
    if (msg_len > body_len) {
        msg_len = body_len;
    }
    
    int copy_len;
    if (msg_len < buffer_size) {
        copy_len = msg_len;
    } else {
        copy_len = buffer_size - 1;
    }
    
    memcpy(param_buffer, msg_body, copy_len);
    param_buffer[copy_len] = '\0';
    
    return 0;
}