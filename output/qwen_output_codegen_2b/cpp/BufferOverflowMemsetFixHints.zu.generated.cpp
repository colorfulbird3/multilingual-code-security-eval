 hold management header
// if (pool_buffer == NULL || pool_size < sizeof(size_t)) {
// return -1;
// }
// size_t current_used;
// // Read current offset (number of used bytes) from the start of the memory pool
// memcpy(&current_used, pool_buffer, sizeof(size_t));
// // Data region starts immediately after the management header
// size_t data_area_start = sizeof(size_t);
// size_t data_area_size = pool_size - data_area_start;
// if (init_data!= NULL) {
// // Validate that there is enough space for the requested allocation
// if (current_used > data_area_size || data_len > data_area_size - current_used) {
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
// Note that the memory pool header is not written back to the allocated block
// in the case where the buffer is not writeable. In this case, the user will
// have to use the memory pool manager for tracking and freeing the memory.
//
// @param allocatable_size The number of bytes in the range [0, @c size]
// that are allocatable
// @param data_len The number of bytes in the range [0, @c data_len] that
// are required to be allocated
// @param size The size of the memory block to be allocated
// @return 0 if the allocation was successful; -1 if allocation is not
// possible.
LIBXSMM_API_INLINE int libxsmm_malloc_memory_pool(const size_t allocatable_size, const size_t data_len, const size_t size, volatile char* pool_buffer, volatile size_t* used_size) {
  if (size == 0 || size > LIBXSMM_MAX_MEMORY_ALLOCATION || (data_len!= 0 && data_len > size - LIBXSMM_MEMORY_POOL_ALIGNMENT)) {
    return -2;
  }
  size_t pool_size = size + LIBXSMM_MEMORY_POOL_ALIGNMENT;
  size_t current_used;
  // Basic parameter validation: ensure buffer is valid and large enough to hold memory pool header
  if (pool_buffer == NULL || pool_size < sizeof(size_t)) {
    return -1;
  }
  memcpy(&current_used, pool_buffer, sizeof(size_t));
  // Allocate the memory pool header
  char* pool_header = (char*)pool_buffer + sizeof(size_t);
  // Allocate the memory
  char* memory = (char*)pool_buffer + LIBXSMM_MEMORY_POOL_HDR_SIZE + current_used;
  // Set the header fields to the requested values
  size_t allocated_size = size;
  size_t used_area_size = pool_size - sizeof(size_t);
  size_t used_area_start = sizeof(size_t);
  const int use_init_data = (data_len > 0);
  size_t data_area_start = use_init_data? data_len : 0;
  size_t data_area_size = use_init_data? data_len : used_area_size - current_used;
  // Determine the address of the memory block to be written back to the
  // header
  char* destination = memory + data_area_start;
  // Calculate the total used length after allocation and write back to pool header
  size_t updated_used = current_used + data_len;
  memcpy(pool_header, &updated_used, sizeof(size_t));
  // Allocate and initialize the memory block
  int result = (int)use_init_data? allocate_pool_memory(init_data, data_len, memory, used_area_size) : 0;
  if (result == 0) {
    if (use_init_data) {
      // Copy initialization data into the allocated block in the memory pool.
      memcpy(destination, init_data, data_len);
    }
    // Update the used length in the header
    memcpy(pool_header, &updated_used, sizeof(size_t));
  }
  *used_size = current_used;
  return result;
}
