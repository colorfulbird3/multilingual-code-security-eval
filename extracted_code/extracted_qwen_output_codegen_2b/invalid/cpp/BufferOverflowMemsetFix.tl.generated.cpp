int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size) {
    if (pool_buffer == NULL || pool_size < sizeof(size_t)) {
        return -1;
    }

    size_t used = *((size_t*)pool_buffer);
    size_t offset = sizeof(size_t);
    size_t available = pool_size - offset;

    if (init_data != NULL) {
        if (data_len == 0) {
            return 0;
        }
        if (used + data_len > available) {
            return -1;
        }
        for (size_t i = 0; i < data_len; i++) {
            pool_buffer[offset + used + i] = init_data[i];
        }
        used += data_len;
        *((size_t*)pool_buffer) = used;
        return 0;
    } else {
        if (data_len != 0) {
            return -1;
        }
        return 0;
    }
}