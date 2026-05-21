```xml
<result>
    <code>
        <path>
            src/memory_pool.c
        </path>
        <content>
            <![CDATA[
#include <string.h>
#include <stddef.h>

/**
 * Allocate memory from the memory pool and initialize with data
 *
 * This function reads the "used length" field from the memory pool header,
 * calculates the start of the allocatable region, and copies user data to that location.
 * It then updates the "used length" in the header.
 */
int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size) {
    // Basic parameter validation: ensure buffer is valid and large enough to hold management header
    if (pool_buffer == NULL || pool_size < sizeof(size_t)) {
        return -1;
    }

    size_t current_used;
    // Read current offset (number of used bytes) from the start of the memory pool
    memcpy(&current_used, pool_buffer, sizeof(size_t));

    // Data region starts immediately after the management header
    size_t data_area_start = sizeof(size_t);
    size_t data_area_size = pool_size - data_area_start;

    if (init_data!= NULL) {
        // Validate that there is enough space for the requested allocation
        if (current_used > data_area_size || data_len > data_area_size - current_used) {
            return -1;
        }

        // Calculate destination address where data should be written
        char* destination = pool_buffer + data_area_start + current_used;

        /*
         * Copy initialization data into the allocated block in the memory pool.
         * This operation directly uses the provided data_len for memory copy.
         */
        memcpy(destination, init_data, data_len);

        // Calculate total used length after allocation and write back to pool header
        size_t updated_used = current_used + data_len;
        memcpy(pool_buffer, &updated_used, sizeof(size_t));
    } else {
        // If init_data is NULL, only data_len == 0 is considered a valid request
        if (data_len!= 0) {
            return -1;
        }
    }

    return 0;
}
            ]]>
        </content>
    </code>
</result>
```

*/
