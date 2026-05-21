## return value
- success: 0
- failure: -1

## input/output
- input: init_data, data_len, pool_buffer, pool_size
- output: memory allocated in pool_buffer, or NULL if allocating failed

## exceptions
- No exceptions thrown nor caught

## implementation details
- use C99
- all allocations are in the same memory page, so page-alignment is guaranteed
- pool_buffer is a pointer to the start of the allocated region
- no support for deallocating allocations (no way to tell the pool about this, so no easy way to support deallocation)
- no support for reallocating allocations (no way to tell the pool of the new size, so no easy way to support reallocation)
- no support for recycling allocations (no easy way to tell the pool of the new size, so no easy way to support recycling)

## notes
- the pool buffer must be big enough to accommodate the "used length" header, in addition to the alloacted region for user data
- the minimum-required size of a pool_buffer is the size of alloacted region + sizeof(used length)
- size of used length header + alloacted region should be large enough to accommodate the largest possible user data size (in the case of allocating the entire pool buffer)

**/
