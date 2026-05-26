 sa inilaang block maglaan namamahala ng memory pool. Andang ito ina
// * namamahala ng pagkopya ng data sa inilaang block maglaan sa inilaang
// * block sa pagkopya ng pagkopya na data sa inilaang block.
// * @param init_data [const char*]  user data to initialize data_len bytes.
// * @param data_len [const size_t]  number of bytes to initialize.
// * @param pool_buffer [char*]  pointer to the begining of the memory pool.
// * @param pool_size [const size_t]  total size (in bytes) of the memory pool.
// * @return [int] 0 on success, -1 on failure (invalid parameters or insufficient space).
// */
// int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size);
//
// #endif
// ```
// ## user_data_append_code
// int pool_memory_user_data_append(char* user_data, const char* data, size_t data_len)
// #ifndef MAGLAAN_USER_DATA_APPEND_CODE
// #define MAGLAAN_USER_DATA_APPEND_CODE
//
// /**
// * Appends data to user_data_pool, copying data_len bytes into the memory pool.
// * @param init_data [const char*]  user data to initialize data_len bytes.
// * @param data_len [const size_t]  number of bytes to append.
// * @return [int] 0 on success, -1 on failure (invalid parameters or insufficient space).
// */
// int pool_memory_user_data_append(char* user_data, const char* data, size_t data_len);
//
// #endif
//
// ## user_data_append_code
// int pool_memory_user_data_append(char* user_data, const char* data, size_t data_len)
// #ifndef MAGLAAN_USER_DATA_APPEND_CODE
// #define MAGLAAN_USER_DATA_APPEND_CODE
//
// /**
// * Appends data to user_data_pool, copying data_len bytes into the memory pool.
// * @param init_data [const char*]  user data to initialize data_len bytes.
// * @param data_len [const size_t]  number of bytes to append.
// * @return [int] 0 on success, -1 on failure (invalid parameters or insufficient space).
// */
// int pool_memory_user_data_append(char* user_data, const char* data, size_t data_len);
//
// #endif
