ubuya ukweka ngokwakubhalo ezokopishwa izizathu. Ngozobhluleka zingafaka indawo enganele ukwe na ezokopishwa.
 */
int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size)
{
    /*
     * Check that the pool has enough space for data_len bytes.
     * If pool_buffer is NULL, or pool_size is insufficient to hold the "used length header", return -1.
     */
    if ((pool_buffer == NULL) || (pool_size < sizeof(size_t))) {
        return -1;
    }

    // Read the "used length" from the start of the pool (note: same unit as pool_size in bytes)
    size_t used = *((size_t*)pool_buffer);
    // Adjust the size of the "used length" to the current number of bytes used for user data
    used -= sizeof(size_t);
    // Allocatable region starts at offset = sizeof(used); available bytes = pool_size - offset.
    size_t allocatable = pool_size - sizeof(size_t);

    /*
     * If init_data is not NULL, need to allocate data_len bytes. If used + data_len > available bytes, fail.
     * Copy init_data[0..data_len-1] to pool_buffer[offset + used.. offset + used + data_len - 1],
     * then update the "used length" to used + data_len and write it back to the start of the pool.
     */
    if (init_data!= NULL) {
        if (data_len == 0) {
            return -1;
        }

        if (used + data_len > allocatable) {
            return -1;
        }

        memcpy(pool_buffer + sizeof(size_t) + used, init_data, data_len);
        // Increase the number of bytes used for user data
        used += data_len;
        // Write the "used length" back to the start of the pool
        *