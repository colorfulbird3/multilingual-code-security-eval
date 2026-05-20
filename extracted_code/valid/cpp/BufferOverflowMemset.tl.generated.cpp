#include "memory_pool.h"

int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size) {
    if (pool_buffer == NULL || pool_size < sizeof(size_t)) {
        return -1;
    }

    size_t* used_length_ptr = (size_t*)pool_buffer;
    size_t used = *used_length_ptr;

    size_t allocatable_size = pool_size - sizeof(size_t);
    size_t available_space = allocatable_size - used;

    if (init_data != NULL) {
        if (used + data_len > available_space) {
            return -1;
        }
        memcpy(pool_buffer + sizeof(size_t) + used, init_data, data_len);
        *used_length_ptr += data_len;
    } else if (data_len != 0) {
        return -1;
    }

    return 0;
}