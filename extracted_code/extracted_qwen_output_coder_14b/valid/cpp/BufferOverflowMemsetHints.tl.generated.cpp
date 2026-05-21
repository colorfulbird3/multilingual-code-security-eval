#include "memory_pool.h"
#include <string.h>

int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size) {
    // Check for invalid parameters
    if (pool_buffer == NULL || pool_size < sizeof(size_t)) {
        return -1;
    }

    // Read the current used length from the start of the pool
    size_t used;
    memcpy(&used, pool_buffer, sizeof(size_t));

    // Calculate the start of the allocatable region and available bytes
    size_t offset = sizeof(size_t);
    size_t available_bytes = pool_size - offset;

    // Check if there is enough space to allocate the requested data
    if (init_data != NULL && used + data_len > available_bytes) {
        return -1;
    }

    // Allocate and copy the initialization data if provided
    if (init_data != NULL) {
        memcpy(pool_buffer + offset + used, init_data, data_len);
        used += data_len;
    } else if (data_len != 0) {
        // Treat as invalid parameter if init_data is NULL but data_len is not zero
        return -1;
    }

    // Update the used length in the pool
    memcpy(pool_buffer, &used, sizeof(size_t));

    return 0;
}