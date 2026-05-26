 init_data, size_t data_len, char* pool_buffer, size_t pool_size) {
// // Basic parameter validation: ensure buffer is valid and large enough to hold management header
// if (pool_buffer == NULL || pool_size < sizeof(size_t)) {
// return -1;
// }
// size_t current_used;
// // Read current offset (number of used bytes) from the start of the memory pool
// memcpy(&current_used, pool_buffer, sizeof(size_t));
// // Data region starts immediately after the management header
// size_t data_area_start = sizeof(size_t);
// size_t available_bytes = pool_size - data_area_start;
// if (init_data!= NULL) {
// // Check if there is enough space for the requested allocation
// if (current_used + data_len > available_bytes) {
// return -1;
// }
// // Calculate destination address where data should be written
// char* destination = pool_buffer + data_area_start + current_used;
// /*
// * Copy initialization data into the allocated block in the memory pool.
// * This operation directly uses the provided data_len for memory copy.
// */
// memcpy(destination, init_data, data_len);
// // Calculate total used length after allocation and write back to pool header
// size_t updated_used = current_used + data_len;
// memcpy(pool_buffer, &updated_used, sizeof(size_t));
// } else {
// // If init_data is NULL, only data_len == 0 is considered a valid request
// if (data_len!= 0) {
// return -1;
// }
// }
// return 0;
// }
// ]]>
// </content>
// </code>
// </result>
// ```
//
// The `init_data` parameter can contain the memory region to be allocated.
//
// Additionally, the `data_len` parameter can be used to limit the size of the allocated memory region. If this
// parameter is omitted, this function tries to allocate the memory necessary to store all the data in the provided
// parameter.
//
// When the memory allocation fails, the function returns a negative error code.
//
// In addition, when the provided `init_data` parameter is `NULL` the function returns an error code when the
// allocated memory is not consistent with the parameter `data_len`.
//
// When the provided `data_len` is invalid, the function returns an error code.
//
// The result of this function is a `memory_pool_header_t` instance. All the data members of this instance are
// valid.
 *
 * @author daniel
 */
@FunctionalInterface
public interface MemoryPoolAllocator {

    /**
     * Allocates memory from the memory pool.
     *
     * @param init_data    The data to be initialized with.
     * @param data_len     The length of the data to be initialized with.
     * @param pool_buffer  The memory pool header.
     * @param pool_size    The size of the memory pool header.
     * @return A positive integer that indicates the number of bytes allocated.
     * @throws MemoryAllocationException if the memory allocation fails.
     */
    int allocate(char[] init_data, int data_len, byte[] pool_buffer, int pool_size) throws MemoryAllocationException;
}
