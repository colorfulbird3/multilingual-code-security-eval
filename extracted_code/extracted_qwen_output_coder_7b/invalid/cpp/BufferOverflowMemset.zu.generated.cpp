if (init_data != NULL) {
       if (used + data_len > available_bytes) {
           return -1;
       }
       memcpy(pool_buffer + offset + used, init_data, data_len);
       used += data_len;
       memcpy(pool_buffer, &used, sizeof(size_t));
       return 0;
   }