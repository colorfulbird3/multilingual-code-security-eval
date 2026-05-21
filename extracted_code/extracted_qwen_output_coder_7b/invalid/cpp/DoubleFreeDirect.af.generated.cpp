struct compression_context {
    unsigned char *temp_buffer;
    size_t buffer_size;
    int compression_type;
};