The provided XML snippet contains a code snippet for a function named `allocate_pool_memory` from the file `src/memory_pool.c`. This function is designed to manage memory allocation within a memory pool. Here's a breakdown of what the function does:

### Function Signature
```c
int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size)
```

### Parameters
- `const char* init_data`: A pointer to the initial data to be copied into the memory pool.
- `size_t data_len`: The length of the initial data.
- `char* pool_buffer`: A pointer to the buffer that acts as the memory pool.
- `size_t pool_size`: The total size of the memory pool.

### Return Value
- Returns `0` on success.
- Returns `-1` on failure.

### Function Logic

1. **Check for Valid Input**:
   - The function first checks if `pool_buffer` is `NULL` or if `pool_size` is less than the size of a `size_t`. If either condition is true, it returns `-1`.

2. **Read the Used Size**:
   - It reads the current size of the used memory from the beginning of the `pool_buffer` into a variable `used`.

3. **Calculate Available Bytes**:
   - It calculates the available bytes in the pool by subtracting the size of `used` from `pool_size`.

4. **Handle Non-NULL `init_data`**:
   - If `init_data` is not `NULL`, it checks if adding `data_len` to `used` would exceed the available bytes. If it does, it returns `-1`.
   - If there is enough space, it copies `init_data` into the pool starting from the offset where the used memory ends.
   - It then updates the `used` size and writes it back to the beginning of the `pool_buffer`.

5. **Handle NULL `init_data`**:
   - If `init_data` is `NULL`, it checks if `data_len` is not zero. If it is not zero, it returns `-1` because a non-zero length with a `NULL` data pointer is invalid.
   - If `data_len` is zero, it simply returns `0`, indicating no error.

### Summary
This function manages a simple memory pool by keeping track of how much of the pool has been used. It allows you to allocate a block of memory within the pool and initialize it with data, or check for errors if the conditions are not met.