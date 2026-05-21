size_t allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size)
{
    if (init_data == NULL) {
        if (data_len!= 0)
            goto err_invalid_data_len;
    } else {
        if (pool_size < data_len)
            goto err_pool_underflow;
    }

    size_t used = 0;
    if (init_data!= NULL)
        used = strlen(init_data);

    // Check used
    if (used + data_len > pool_size)
        goto err_allocated_memory_too_big;

    // Copy data
    memcpy(pool_buffer + used, init_data, data_len);

    return used + data_len;

err_allocated_memory_too_big:
    return -1;

err_invalid_data_len:
    return -2;

err_pool_underflow:
    return -3;
}