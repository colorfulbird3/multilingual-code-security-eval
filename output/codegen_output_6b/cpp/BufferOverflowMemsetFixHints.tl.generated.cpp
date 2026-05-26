 bytes googlo sa pool buffer.

## Paglalahin ang C Standard
C99

## Filename
memory_pool.c

## Header Code
```c
#ifndef MEMORY_POOL_H
#define MEMORY_POOL_H

#include <stddef.h>

/*
 * ========== Memory Pool Structure and Allocation Strategy ==========
 *
 * [Overview]
 * This module provides a simple linear-buffer-based memory pool. The caller provides a contiguous memory block (pool_buffer),
 * and the implementation internally maintains the "used length" within the pool, allocating sequentially from the beginning without support for deallocation or recycling.
 *
 * [Pool Layout]
 *
 * The entire memory block pointed to by pool_buffer is laid out as follows (left to right: low to high addresses):
 *
 *   +------------------+------------------------------------------+
 *   | Used Length (N bytes) | Allocatable Region (user data appended sequentially) |
 *   +------------------+------------------------------------------+
 *   ^                  ^
 *   pool_buffer        pool_buffer + N   (N = number of bytes used to store "used length")
 *
 *   - "Used Length": Occupies a fixed number of bytes at the start of the pool (recommended: sizeof(size_t)), storing the current number of bytes used for user data,
 *     i.e., the offset from the start of the allocatable region to the next available byte. Initially 0.
 *   - Allocatable Region: Starts at pool_buffer + sizeof(used length), with length = pool_size - sizeof(used length).
 *     Each allocation appends to the current end of used space; allocating'size' bytes increases the used length by'size'.
 *
 * [Allocation Algorithm: allocate_pool_memory]
 * 1. Fail if pool_buffer is NULL or pool_size is insufficient to hold the "used length header".
 * 2. Read the current used length 'used' from the start of the pool (note: same unit as pool_size, in bytes).
 * 3. Allocatable region starts at offset = sizeof(used); available bytes = pool_size - offset.
 * 4. If init_data is not NULL: