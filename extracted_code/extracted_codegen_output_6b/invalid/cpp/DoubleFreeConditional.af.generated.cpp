int update_firmware(const unsigned char *firmware_data, size_t firmware_size, const char *version) {
    if (firmware_data == NULL || firmware_size == 0 || version == NULL) {
        return -1;
    }
    if (firmware_size != 4096) {
        return -1;
    }
    if (strcmp(version, "v1.2.3") != 0) {
        return -1;
    }
    if (has_enough_storage(firmware_size) != 0) {
        return -1;
    }
    if (verify_integrity(firmware_data, firmware_size) != 0) {
        return -1;
    }
    if (write_firmware_to_storage(firmware_data, firmware_size) != 0) {
        return -1;
    }
    return 0;
}