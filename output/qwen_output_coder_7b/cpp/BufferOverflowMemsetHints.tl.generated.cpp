```xml
<result>
    <code>
        <path>src/memory_pool.c</path>
        <content>
            <![CDATA[
#include "memory_pool.h"

int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size) {
    if (pool_buffer == NULL || pool_size < sizeof(size_t)) {
        return -1;
    }

    size_t* used_length_ptr = (size_t*)pool_buffer;
    size_t used_length = *used_length_ptr;

    size_t allocatable_size = pool_size - sizeof(size_t);
    size_t offset = sizeof(size_t) + used_length;

    if (init_data != NULL) {
        if (used_length + data_len > allocatable_size) {
            return -1;
        }
        memcpy(pool_buffer + offset, init_data, data_len);
        *used_length_ptr += data_len;
    } else if (data_len != 0) {
        return -1;
    }

    return 0;
}
            ]]>
        </content>
    </code>
</result>
```