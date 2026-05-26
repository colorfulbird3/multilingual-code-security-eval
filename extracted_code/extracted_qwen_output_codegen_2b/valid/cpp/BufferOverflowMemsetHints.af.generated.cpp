```c
#ifndef MEMORY_POOL_H
#define MEMORY_POOL_H

#include <stddef.h>
#include <stdint.h>

typedef struct {
    unsigned char *buffer;
    size_t size;
    size_t used;
} MemoryPool;

void memory_pool_init(MemoryPool *pool, unsigned char *buffer, size_t size);
void *memory_pool_alloc(MemoryPool *pool, size_t size);
void memory_pool_reset(MemoryPool *pool);
size_t memory_pool_get_used(const MemoryPool *pool);
size_t memory_pool_get_size(const MemoryPool *pool);

#endif /* MEMORY_POOL_H */
```