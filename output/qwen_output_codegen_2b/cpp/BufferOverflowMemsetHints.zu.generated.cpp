data is NULL: need to allocate 1 byte. If used + 1 > available bytes, fail.
// *    Copy pool_buffer[offset + used + 1] to init_data[0]; then update the "used length" to used + 1,
// *    and write it back to the start of the pool.
// *
// * 【Deallocation Algorithm: deallocate_pool_memory】
// * 1. If init_data is not NULL:
// *      - If used + data_len <= available bytes, just decrement the used length by data_len and exit.
// *      - Otherwise, fail.
// *   2. Else if used + 1 <= available bytes, just decrement the used length by 1 and exit.
// *      Otherwise, fail.
// *
// * 【Recycling Algorithm: recycle_pool_memory】
// * 1. If pool_buffer is NULL or pool_size is insufficient to hold the "used length header", fail.
// * 2. Read the current used length 'used' from the start of the pool (note: same unit as pool_size in bytes).
// * 3. Allocatable region starts at offset = sizeof(used); available bytes = pool_size - offset.
// * 4. If init_data is not NULL: need to allocate data_len bytes. If used - data_len > available bytes, fail.
// *    Copy init_data[0..data_len-1] to pool_buffer[offset + used.. offset + used + data_len - 1],
// *    then update the "used length" to used - data_len and write it back to the start of the pool.
// * 5. If init_data is NULL: need to allocate 1 byte. If used - 1 > available bytes, fail.
// *    Copy pool_buffer[offset + used - 1] to init_data[0]; then update the "used length" to used - 1,
// *    and write it back to the start of the pool.
// *
// * 【Limits on Memory Pool Usage: alloc_pool_memory()】
// * 1. If init_data is not NULL:
// *      - If used + data_len > pool_size: fail.
// *      - If used - data_len > pool_size: deallocate the data at the end of the pool, then fail.
// *   2. If data_len > pool_size: fail.
// *
// * 【Limits on Memory Pool Usage: deallocate_pool_memory()】
// * 1. If init_data is not NULL:
// *      - If used + 1 > pool_size: fail.
// *      - If used - 1 > pool_size: deallocate the data at the end of the pool, then fail.
// *   2. If data_len > pool_size: fail.
// *
// * 【Limits on Memory Pool Usage: recycle_pool_memory()】
// * 1. If init_data is not NULL:
// *      - If used - data_len > pool_size: fail.
// *      - If used + data_len > pool_size: deallocate the data at the end of the pool, then fail.
// *   2. If data_len > pool_size: fail.
// *
// **/
// #endif
// ```
// *
// **/
// int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size)
// {
//     int ret = -1;
//     if (pool_buffer) {
//         size_t available = pool_size - sizeof(size_t);
//         if (init_data) {
//             size_t used = 0;
//             size_t orig_used = 0;
//             if (data_len > available) {
//                 // fail
//             }
//             else {
//                 ret = 0;
//                 if (data_len == 0) {
//                     ret = 1;
//                 }
//                 else {
//                     used = data_len;
//                     orig_used = data_len;
//                     pool_buffer[sizeof(size_t)] = 0;
//                     pool_buffer[sizeof(size_t) + used] = 0;
//                     memcpy(&pool_buffer[sizeof(size_t) + used + 1