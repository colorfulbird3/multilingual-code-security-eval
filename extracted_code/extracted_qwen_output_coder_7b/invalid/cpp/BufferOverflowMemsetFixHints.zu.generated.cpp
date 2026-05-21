```c
int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size) {
    // Step 1: Validate basic parameters
    if (pool_buffer == NULL || pool_size < sizeof(size_t)) {
        return -1;
    }

    // Step 2: Read current used length from header
    size_t* used_len_ptr = (size_t*)pool_buffer;
    size_t used_len = *used_len_ptr;

    // Step 3: Calculate start of allocatable region
    size_t alloc_start = sizeof(size_t);

    // Step 4: Check if enough space
    if (used_len + data_len > pool_size - alloc_start) {
        return -1;
    }

    // Step 5: Calculate destination address
    char* dest = pool_buffer + alloc_start + used_len;

    // Step 6: Copy initialization data
    if (init_data != NULL && data_len > 0) {
        memcpy(dest, init_data, data_len);
    }

    // Step 7: Update used length
    *used_len_ptr = used_len + data_len;

    // Step 8: Return success
    return 0;
}
```