```c
#include <string.h>
#include <stddef.h>

int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size) {
    if (pool_buffer == NULL || pool_size < sizeof(size_t)) {
        return -1;
    }

    size_t used_length;
    memcpy(&used_length, pool_buffer, sizeof(size_t));

    size_t usable_space = pool_size - sizeof(size_t);

    if (init_data != NULL) {
        if (data_len > usable_space) {
            return -1;
        }
        memcpy(pool_buffer + sizeof(size_t), init_data, data_len);
        used_length = data_len;
        memcpy(pool_buffer, &used_length, sizeof(size_t));
    } else {
        if (data_len != 0) {
            return -1;
        }
    }

    return 0;
}
```