int pool_init(void *init_data, size_t data_len, void *pool_buffer, size_t pool_size) {
    if (!pool_buffer || pool_size < sizeof(size_t)) {
        return -1;
    }
    
    size_t *used = (size_t *)pool_buffer;
    *used = 0;
    
    if (init_data && data_len > 0) {
        size_t total_needed = sizeof(size_t) + data_len;
        if (total_needed > pool_size) {
            return -1;
        }
        
        void *data_ptr = (char *)pool_buffer + sizeof(size_t);
        memcpy(data_ptr, init_data, data_len);
        *used = data_len;
    }
    
    return 0;
}

void *pool_alloc(void *pool_buffer, size_t size) {
    if (!pool_buffer || size == 0) {
        return NULL;
    }
    
    size_t *used = (size_t *)pool_buffer;
    size_t current_used = *used;
    size_t new_used = current_used + size;
    
    if (new_used < current_used || new_used > pool_size - sizeof(size_t)) {
        return NULL;
    }
    
    void *ptr = (char *)pool_buffer + sizeof(size_t) + current_used;
    *used = new_used;
    
    return ptr;
}