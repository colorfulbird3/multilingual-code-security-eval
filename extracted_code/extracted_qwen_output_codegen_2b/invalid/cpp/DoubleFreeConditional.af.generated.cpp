int update_firmware(const unsigned char *firmware_data, size_t firmware_size, const char *version) {
    if (firmware_data == NULL || firmware_size == 0 || version == NULL) {
        return -1;
    }

    unsigned char *buffer = (unsigned char *)malloc(firmware_size);
    if (buffer == NULL) {
        return -1;
    }

    memcpy(buffer, firmware_data, firmware_size);

    if (!verify_firmware_integrity(buffer, firmware_size)) {
        free(buffer);
        return -1;
    }

    if (!check_storage_space(firmware_size)) {
        free(buffer);
        return -1;
    }

    int result = perform_firmware_update(buffer, firmware_size, version);
    free(buffer);
    return result;
}