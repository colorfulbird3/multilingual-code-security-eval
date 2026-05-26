_bytes = pool_size - offset;
// // 4. Uma i-init_data ingeyona i-NULL: yaba data_len amabhayithi.
// if (init_data!= NULL) {
// // Hluleka uma used + data_len > available_bytes.
// if (used + data_len > available_bytes) {
// return -1;
// }
// // Kopisha i-init_data[0..data_len-1] iye ku-pool_buffer[offset + used.. offset + used + data_len - 1].
// memcpy(pool_buffer + offset + used, init_data, data_len);
// // Bese ubuyekeza "ubude obusetshenzisiwe" bube used + data_len bese ubhala emuva ku-pool header.
// used += data_len;
// memcpy(pool_buffer, &used, sizeof(size_t));
// return 0;
// }
// // 5. Uma i-init_data iyi-NULL: phatha i-data_len!= 0 njengepharamitha engavumelekile; ngenye indlela (data_len == 0), akukho ukwabiwa okudingekayo, buyisa impumelelo.
// if (data_len!= 0) {
// return -1;
// }
// return 0;
// }
// ]]>
// </content>
// </code>
// </result>
// ```
// 
// @author EOF
// @date 2015-Oct-01
// @since 1.0.0
// @version 1.0.0
// @copyright 2015-Oct-01 EOF
// @license MIT
// @link https://github.com/eofe/dynamic_memory_pool
// @license MIT
// @see http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// #include "memory_pool.h"
// 
// #include <stdint.h>
// #include <stdlib.h>
// #include <string.h>
// #include <assert.h>
// 
// // pool_chunk_size default: 8K
// size_t pool_chunk_size = 0x800;
// 
// // pool_chunk_size of pool_size
// size_t pool_chunk_size_from_pool_size = 0;
// 
// // pool_chunk_size of pool_size * 1024
// size_t pool_chunk_size_from_pool_size_1024 = 0;
// 
// // used_chunk_size default: 64K
// size_t used_chunk_size = 0x10000;
// 
// size_t mem_pool_chunk_size_from_used_chunk_size(size_t used_chunk_size)
// {
// return used_chunk_size;
// }
// 
// size_t mem_pool_chunk_size_from_pool_chunk_size(size_t pool_chunk_size)
// {
// return pool_chunk_size;
// }
// 
// size_t mem_pool_chunk_size_from_pool_chunk_size_1024(size_t pool_chunk_size_1024)
// {
// return pool_chunk_size_1024;
// }
// 
// void *allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size) {
// // Allocate Memory
// void *used = malloc(pool_chunk_size);
// // Initialize Memory
// memset(used, 0, pool_chunk_size);
// // Initialize Pool
// memset(pool_buffer, 0, pool_size);
// // Fill Memory
// if (init_data!= NULL) {
// // Copy Init Data
// memcpy(used, init_data, data_len);
// }
// // Fill Pool
// memset(pool_buffer, 0, pool_size);
// // Return
// return used;
// }
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
