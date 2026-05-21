int firmware_update_process(unsigned char* firmware_data, size_t firmware_size, char* version) {
    if (firmware_data == NULL || version == NULL || firmware_size == 0) {
        return -1;
    }

    firmware_image_t* firmware_image = (firmware_image_t*)malloc(sizeof(firmware_image_t));
    if (firmware_image == NULL) {
        return -1;
    }

    firmware_image->data = (unsigned char*)malloc(firmware_size);
    if (firmware_image->data == NULL) {
        free(firmware_image);
        return -1;
    }

    memcpy(firmware_image->data, firmware_data, firmware_size);
    firmware_image->size = firmware_size;
    firmware_image->version = version;

    if (firmware_size < 64) {
        free(firmware_image->data);
        free(firmware_image);
        return -1;
    }

    if (firmware_size > 1048576) {
        firmware_image->data = NULL;
        goto error_cleanup;
    }

    if (firmware_image->data[0] != 0x7F) {
        goto error_cleanup;
    }

    firmware_image->validated = 1;

    // Actual firmware update process would go here

    free(firmware_image->data);
    free(firmware_image);
    return 0;

error_cleanup:
    if (firmware_image != NULL) {
        if (firmware_image->data != NULL) {
            free(firmware_image->data);
        }
        free(firmware_image);
    }
    return -1;
}