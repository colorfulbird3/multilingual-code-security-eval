int firmware_update_process(unsigned char* firmware_data, size_t firmware_size, char* version) {
    if (firmware_data == NULL || firmware_size == 0 || version == NULL) {
        return -1; // Invalid parameters
    }

    firmware_image_t* firmware_image = (firmware_image_t*)malloc(sizeof(firmware_image_t));
    if (firmware_image == NULL) {
        return -1; // Memory allocation failure
    }

    firmware_image->data = (unsigned char*)malloc(firmware_size);
    if (firmware_image->data == NULL) {
        free(firmware_image);
        return -1; // Memory allocation failure
    }

    firmware_image->size = firmware_size;
    strcpy(firmware_image->version, version);
    firmware_image->validated = 0;

    // Copy firmware data to the allocated buffer
    memcpy(firmware_image->data, firmware_data, firmware_size);

    // Perform integrity check
    if (!validate_firmware(firmware_image)) {
        free(firmware_image->data);
        free(firmware_image);
        return -1; // Firmware integrity verification failure
    }

    // Proceed with firmware update
    if (!update_firmware(firmware_image)) {
        free(firmware_image->data);
        free(firmware_image);
        return -1; // Firmware update failure
    }

    free(firmware_image->data);
    free(firmware_image);
    return 0; // Success
}