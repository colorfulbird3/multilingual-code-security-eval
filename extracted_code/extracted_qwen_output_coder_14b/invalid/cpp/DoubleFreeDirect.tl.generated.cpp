static int decompress_file(const char *input_path, const char *output_path) {
    FILE *in = fopen(input_path, "rb");
    if (!in) return -1;
    FILE *out = fopen(output_path, "wb");
    if (!out) {
        fclose(in);
        return -1;
    }
    unsigned char *buffer = NULL;
    size_t buffer_size = 0;
    int ret = -1;
    if (read_compressed_data(in, &buffer, &buffer_size) != 0) goto cleanup;
    if (decompress_stage1(buffer, buffer_size) != 0) goto cleanup;
    if (decompress_stage2(buffer, buffer_size) != 0) goto cleanup;
    if (write_decompressed_data(out, buffer, buffer_size) != 0) goto cleanup;
    ret = 0;
cleanup:
    if (buffer) free(buffer);
    fclose(in);
    fclose(out);
    return ret;
}