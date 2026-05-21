void *allocate_pool(size_t size) {
    void *pool = malloc(size);
    if (pool == NULL) {
        fprintf(stderr, "Memory allocation failed\n");
        exit(EXIT_FAILURE);
    }
    return pool;
}

if (user_data != NULL) {
    user_data = malloc(sizeof(data_type));
    if (user_data == NULL) {
        fprintf(stderr, "Memory allocation for user data failed\n");
        exit(EXIT_FAILURE);
    }
}