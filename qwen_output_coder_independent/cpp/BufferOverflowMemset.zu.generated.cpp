The provided XML snippet contains a C code implementation for a memory pool function named `allocate_pool_memory`. This function is designed to manage a fixed-size buffer (`pool_buffer`) as a memory pool. Here's a breakdown of the function:

### Function Signature
```c
int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size)
```
- **Parameters:**
  - `const char* init_data`: A pointer to the initial data to be stored in the pool.
  - `size_t data_len`: The length of the initial data.
  - `char* pool_buffer`: A pointer to the fixed-size buffer that acts as the memory pool.
  - `size_t pool_size`: The total size of the buffer.

- **Return Value:**
  - `int`: Returns `0` on success, `-1` on failure.

### Function Logic

1. **Validation Check:**
   ```c
   if (pool_buffer == NULL || pool_size < sizeof(size_t)) {
       return -1;
   }
   ```
   - Ensures that `pool_buffer` is not `NULL` and that `pool_size` is at least large enough to hold the size of the used memory marker.

2. **Read Used Memory Marker:**
   ```c
   size_t used;
   memcpy(&used, pool_buffer, sizeof(size_t));
   ```
   - Reads the current used memory marker from the beginning of the buffer.

3. **Calculate Available Bytes:**
   ```c
   size_t offset = sizeof(size_t);
   size_t available_bytes = pool_size - offset;
   ```
   - Calculates the available bytes in the pool after accounting for the size of the used memory marker.

4. **Handle Initialization Data:**
   ```c
   if (init_data != NULL) {
       if (used + data_len > available_bytes) {
           return -1;
       }
       memcpy(pool_buffer + offset + used, init_data, data_len);
       used += data_len;
       memcpy(pool_buffer, &used, sizeof(size_t));
       return 0;
   }
   ```
   - If `init_data` is not `NULL`, it checks if there is enough space in the pool to store the data.
   - Copies the data into the pool and updates the used memory marker.

5. **Handle Data Length:**
   ```c
   if (data_len != 0) {
       return -1;
  