```c
#include <string.h>
#include <stddef.h>

int mem_pool_alloc(void *pool_buffer, size_t pool_size, void *init_data, size_t data_len) {
    if (pool_buffer == NULL || pool_size < sizeof(size_t)) {
        return -1;
    }

    size_t current_used;
    memcpy(&current_used, pool_buffer, sizeof(size_t));

    size_t data_start = sizeof(size_t);
    size_t new_used = current_used + data_len;

    if (new_used > pool_size) {
        return -1;
    }

    if (init_data != NULL && data_len > 0) {
        void *dest = (unsigned char *)pool_buffer + data_start + current_used;
        memcpy(dest, init_data, data_len);
    }

    memcpy(pool_buffer, &new_used, sizeof(size_t));

    return 0;
}
```