// * @brief Allocate pool memory.
// * @param init_data Pointer to the buffer to be used for allocating data of the pool.
// * @param data_len Length of data to be allocated in the pool.
// * @param pool_buffer Pointer to the buffer containing the pool.
// * @param pool_size Size of the pool.
// * @return 0 if successful, -1 if insufficient space was left in the pool.
// */
// int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size) {
//     if (!pool_buffer) {
//         return -1;
//     }
//     size_t used_len;
//     if (init_data && data_len > 0) {
//         if (data_len > pool_size) {
//             return -1;
//         }
//         memcpy(pool_buffer, init_data, data_len);
//         used_len = data_len;
//     } else {
//         used_len = 0;
//     }
//     size_t available_len = pool_size - sizeof(used_len);
//     if (used_len > available_len) {
//         return -1;
//     }
//     char* used = pool_buffer + sizeof(used_len);
//     size_t data_len_aligned = (data_len + sizeof(size_t) - 1) & ~(sizeof(size_t) - 1);
//     size_t used_len_aligned = used_len + data_len_aligned;
//     if (used_len_aligned > available_len) {
//         return -1;
//     }
//     size_t offset = sizeof(used_len);
//     pool_buffer[offset] = used_len_aligned;
//     memcpy(used, init_data, data_len);
//     pool_buffer[offset + used_len] = used_len_aligned;
//     return 0;
// }
// ```
// ## header_code
// ```c
// #include <stdlib.h>
// #include <stdio.h>
// #include <errno.h>
// #include <string.h>
// #include <stddef.h>
// #include <stdint.h>
// #include <limits.h>
// #include <assert.h>
// #include <stdarg.h>
// #include <malloc.h>
// #include <memory.h>
// #include <ctype.h>
// #include <stdlib.h>
// #include <stdio.h>
// #include <stdint.h>
// #include <inttypes.h>
// #include "memory_pool.h"
//
// void* g_malloc(size_t size) {
//     void *ptr = malloc(size);
//     if (!ptr) {
//         fprintf(stderr, "Memory allocation failed, %lu bytes\n", (unsigned long) size);
//         exit(EXIT_FAILURE);
//     }
//     return ptr;
// }
//
// void* g_realloc(void *ptr, size_t size) {
//     void *ptr2 = realloc(ptr, size);
//     if (!ptr2) {
//         fprintf(stderr, "Memory reallocation failed, %lu bytes\n", (unsigned long) size);
//         exit(EXIT_FAILURE);
//     }
//     return ptr2;
// }
//
// void g_free(void *ptr) {
//     free(ptr);
// }
//
// void* g_malloc0(size_t size) {
//     // not supported for now
//     // return g_malloc(size);
//     return g_malloc(size);
// }
//
// void* g_realloc0(void *ptr, size_t size) {
//     // not supported for now
//     // return g_realloc(ptr, size);
//     return g_realloc(ptr, size);
// }
//
// void* g_calloc(size_t count, size_t size) {
//     // not