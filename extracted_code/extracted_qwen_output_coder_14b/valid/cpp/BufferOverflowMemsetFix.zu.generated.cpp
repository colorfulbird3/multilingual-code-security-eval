int allocate_pool_memory(void *pool_buffer, size_t pool_size, const void *init_data, size_t data_len) {
    if (pool_buffer == NULL || pool_size < sizeof(size_t)) {
        return -1;
    }

    size_t *used = (size_t *)pool_buffer;
    size_t current_used = *used;
    size_t offset = sizeof(size_t);
    size_t available = pool_size - offset;

    if (init_data != NULL) {
        if (current_used + data_len > available) {
            return -1;
        }
        unsigned char *dest = (unsigned char *)pool_buffer + offset + current_used;
        memcpy(dest, init_data, data_len);
        *used = current_used + data_len;
        return 0;
    } else {
        if (data_len != 0) {
            return -1;
        }
        return 0;
    }
}