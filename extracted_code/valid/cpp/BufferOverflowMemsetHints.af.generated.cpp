#include "memory_pool.h"

int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size) {
    if (pool_buffer == NULL || pool_size < sizeof(size_t)) {
        return -1; // Ongeldige parameters
    }

    size_t* used_ptr = (size_t*)pool_buffer;
    size_t used = *used_ptr;

    size_t available_space = pool_size - sizeof(size_t);
    size_t required_space = data_len;

    if (init_data != NULL && used + required_space > available_space) {
        return -1; // Onvoldoende spasie in geheuepoel
    }

    if (init_data != NULL) {
        memmove(pool_buffer + sizeof(size_t) + used, init_data, data_len);
        *used_ptr += data_len;
    }

    return 0; // Sukses
}