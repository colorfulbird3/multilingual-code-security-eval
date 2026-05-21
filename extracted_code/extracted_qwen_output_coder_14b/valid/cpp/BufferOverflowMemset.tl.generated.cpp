#include "memory_pool.h"
#include <string.h> // For memcpy

int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size) {
    if (pool_buffer == NULL || pool_size < sizeof(size_t)) {
        return -1; // Invalid parameters
    }

    // Read the current used length from the pool header
    size_t used;
    memcpy(&used, pool_buffer, sizeof(size_t));

    // Calculate the start of the allocatable region and available bytes
    size_t offset = sizeof(size_t);
    size_t available_bytes = pool_size - offset;

    // Check if there is enough space for the new allocation
    if (init_data != NULL && used + data_len > available_bytes) {
        return -1; // Insufficient space
    }

    // Allocate memory and copy initialization data
    if (init_data != NULL) {
        memcpy(pool_buffer + offset + used, init_data, data_len);
        used += data_len;
    }

    // Update the "used length" in the pool header
    memcpy(pool_buffer, &used, sizeof(size_t));

    return 0; // Success
}