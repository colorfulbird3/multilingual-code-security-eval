int libxsmm_malloc_memory_pool(const size_t allocatable_size, const size_t data_len, const size_t size, volatile char* pool_buffer, volatile size_t* used_size) {
  if (size == 0 || size > LIBXSMM_MAX_MEMORY_ALLOCATION || (data_len!= 0 && data_len > size - LIBXSMM_MEMORY_POOL_ALIGNMENT)) {
    return -2;
  }
  size_t pool_size = size + LIBXSMM_MEMORY_POOL_ALIGNMENT;
  size_t current_used;
  if (pool_buffer == NULL || pool_size < sizeof(size_t)) {
    return -1;
  }
  memcpy(&current_used, pool_buffer, sizeof(size_t));
  char* pool_header = (char*)pool_buffer + sizeof(size_t);
  char* memory = (char*)pool_buffer + LIBXSMM_MEMORY_POOL_HDR_SIZE + current_used;
  size_t allocated_size = size;
  size_t used_area_size = pool_size - sizeof(size_t);
  size_t used_area_start = sizeof(size_t);
  const int use_init_data = (data_len > 0);
  size_t data_area_start = use_init_data? data_len : 0;
  size_t data_area_size = use_init_data? data_len : used_area_size - current_used;
  char* destination = memory + data_area_start;
  size_t updated_used = current_used + data_len;
  memcpy(pool_header, &updated_used, sizeof(size_t));
  int result = (int)use_init_data? allocate_pool_memory(init_data, data_len, memory, used_area_size) : 0;
  if (result == 0) {
    if (use_init_data) {
      memcpy(destination, init_data, data_len);
    }
    memcpy(pool_header, &updated_used, sizeof(size_t));
  }
  *used_size = current_used;
  return result;
}