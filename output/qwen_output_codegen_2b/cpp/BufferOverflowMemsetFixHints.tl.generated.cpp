 at simulan ito sa inilaang memorya.
// * @param init_data : char* pointer to initialization data, or NULL
// * @param data_len : size_t
// * @param pool_buffer : char* pointer to buffer
// * @param pool_size : size_t
// * @return : 0 if success, -1 if failure (invalid parameters or insufficient space)
// */
// int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size)
// {
//     int ret = 0;
//     if(pool_buffer == NULL || pool_size < sizeof(size_t))
//     {
//         ret = -1;
//     }
//     else
//     {
//         size_t used = 0;
//         if(init_data!= NULL)
//         {
//             int c = 0;
//             for(; c<data_len && used<pool_size; c++)
//             {
//                 pool_buffer[used++] = init_data[c];
//             }
//             if(c < data_len)
//             {
//                 ret = -1;
//             }
//             else
//             {
//                 pool_buffer[used++] = '\0';
//                 size_t used_len = used;
//                 pool_buffer[used++] = '\0';
//                 used += used_len;
//                 pool_buffer[used++] = '\0';
//             }
//         }
//         else
//         {
//             int c = 0;
//             for(; c<data_len && used<pool_size; c++)
//             {
//                 pool_buffer[used++] = '\0';
//             }
//             if(c < data_len)
//             {
//                 ret = -1;
//             }
//         }
//     }
//     return ret;
// }
// #endif
