int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size)
{
    int ret = -1;
    if (pool_buffer) {
        size_t available = pool_size - sizeof(size_t);
        if (init_data) {
            size_t used = 0;
            size_t orig_used = 0;
            if (data_len > available) {
                // fail
            }
            else {
                ret = 0;
                if (data_len == 0) {
                    ret = 1;
                }
                else {
                    used = data_len;
                    orig_used = data_len;
                    pool_buffer[sizeof(size_t)] = 0;
                    pool_buffer[sizeof(size_t) + used] = 0;
                    memcpy(&pool_buffer[sizeof(size_t) + used + 1