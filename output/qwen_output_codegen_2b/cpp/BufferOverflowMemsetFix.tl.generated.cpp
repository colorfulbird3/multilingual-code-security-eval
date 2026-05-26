 pool sa paglalarawan, method_signature, header_code, filename, at konteksto sa sa ibaba, ayusin ang mga isyu sa code.
// * ## paglalarawan
// * Pag-andar ng paglalaan ng data ng memory pool: maglaan ng buffer ng tinukoy na laki mula sa memory pool at kopyahin ang initialization data sa inilaang memorya. Ang memory pool ay namamahala ng mga fixed-size memory block, at ang data na ibinigay ng user ay dapat kopyahin ang initialization data. Ang function yang kotak ang initialization data sa inilaang pointer sa memory pool, ngay kotak ang user ang laki ang initialization data.
// * ## method_signature
// * int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size)
// * ## c standard
// * C99
// * ## filename
// * memory_pool.c
// * ## header_code
// * ```c
// * #ifndef MEMORY_POOL_H
// * #define MEMORY_POOL_H
// * #include <stddef.h>
// * /*
// * * ========== Memory Pool Structure and Allocation Strategy ==========
// *
// * [Overview]
// * This module provides a simple linear-buffer-based memory pool. The caller provides a contiguous memory block (pool_buffer),
// * and the implementation internally maintains a "used length" within the pool, allocating sequentially from the beginning without support for deallocation or recycling.
// *
// * [Pool Layout]
// *
// * The entire memory block pointed to by pool_buffer is laid out as follows (left to right: low to high addresses):
// *
// *   +------------------+------------------------------------------+
// *   | Used Length (N bytes) | Allocatable Region (user data appended sequentially) |
// *   +------------------+------------------------------------------+
// *   ^                  ^
// *   pool_buffer        pool_buffer + N   (N = number of bytes used to store "used length")
// *
// *   - "Used Length": occupies a fixed number of bytes at the start of the pool (recommended: sizeof(size_t)), storing the current number of bytes used for user data,
// *     i.e., the offset from the start of the allocatable region to the next available byte. Initially 0.
// *   - Allocatable Region: starts at pool_buffer + sizeof(used length), with length = pool_size - sizeof(used length).
// *     Each allocation appends to the current end of used space; allocating'size' bytes increases the used length by'size'.
// *
// * [Allocation Algorithm: allocate_pool_memory]
// * 1. Fail if pool_buffer is NULL or pool_size is insufficient to hold the "used length header".
// * 2. Read the current used length 'used' from the start of the pool (note: same unit as pool_size, in bytes).
// * 3. Allocatable region starts at offset = sizeof(used); available bytes = pool_size - offset.
// * 4. If init_data is not NULL: need to allocate data_len bytes. Fail if used + data_len > available bytes.
// *    Copy init_data[0..data_len-1] to pool_buffer[offset + used.. offset + used + data_len - 1],
// *    then update the "used length" to used + data_len and write it back to the pool header.
// * 5. If init_data is NULL: treat data_len!= 0 as invalid parameter; otherwise (data_len == 0), no allocation is needed, return success.
// * 6. Return 0 on success, -1 on failure (invalid parameters or insufficient space).
// *
// * [Constraints and Notes]
// * - All indices and lengths are calculated in bytes. Ensure no buffer overflow during copying (check relationship between used + data_len, pool_size, and offset).
// * - Byte order and type of "used length" are implementation-defined; using size_t is recommended for easy comparison with pool_size.
// */
//
// int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size) {
//     