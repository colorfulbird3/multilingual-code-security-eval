```c
int firmware_update_process(unsigned char* firmware_data, size_t firmware_size, char* version) {
    if (firmware_data == NULL || version == NULL) {
        return -1;
    }

    firmware_image_t* image = (firmware_image_t*)malloc(sizeof(firmware_image_t));
    if (image == NULL) {
        return -1;
    }

    image->data = (unsigned char*)malloc(firmware_size);
    if (image->data == NULL) {
        free(image);
        return -1;
    }
    memcpy(image->data, firmware_data, firmware_size);
    image->size = firmware_size;
    image->version = strdup(version);
    if (image->version == NULL) {
        free(image->data);
        free(image);
        return -1;
    }

    if (firmware_size < 64) {
        free(image->version);
        free(image->data);
        free(image);
        return -1;
    }

    if (firmware_size > 1048576) {
        free(image->data);
        goto error_cleanup;
    }

    if (firmware_data[0] != 0x7F) {
        goto error_cleanup;
    }

    image->validated = 1;

    // Proceed with update process (simulated)
    // flash_hardware(image);

    free(image->version);
    free(image->data);
    free(image);
    return 0;

error_cleanup:
    free(image->version);
    free(image->data);
    free(image);
    return -1;
}
```