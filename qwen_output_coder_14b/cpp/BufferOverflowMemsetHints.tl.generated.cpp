Here's the complete code for `src/memory_pool.c` based on the provided description, method signature, header code, and context:

```xml
<result>
    <code>
        <path>
            src/memory_pool.c
        </path>
        <content>
            <![CDATA[
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
]]>
        </content>
    </code>
</result>
```

### Explanation:

1. **Parameter Validation**:
   - The function first checks if `pool_buffer` is `NULL` or if `pool_size` is less than `sizeof(size_t)`. If either condition is true, the function returns `-1` indicating failure.

2. **Reading Used Length**:
   - The function reads the current used length from the start of the pool using `memcpy`.

3. **Calculating Allocatable Region**:
   - The start of the allocatable region is calculated as `sizeof(size_t)` bytes from the beginning of the pool.
   - The available bytes in the allocatable region are calculated by subtracting the offset from `pool_size`.

4. **Space Check**:
   - If `init_data` is not `NULL`, the function checks if the total used length plus `data_len` exceeds the available bytes. If it does, the function returns `-1`.

5. **Allocating and Copying Data**:
   - If `init_data` is not `NULL`, the function copies `init_data` into the allocatable region starting from the current used length.
   - If `init_data` is `NULL` but `data_len` is not zero, the function treats this as an invalid parameter and returns `-1`.
   - If both `init_data` and `data_len` are zero, no allocation is needed, and the function returns `0`.

6. **Updating Used Length**:
   - The function updates the used length in the pool by writing it back to the start of the pool.

This code ensures that the memory pool is managed safely, preventing buffer overflows and ensuring that all operations are performed correctly.