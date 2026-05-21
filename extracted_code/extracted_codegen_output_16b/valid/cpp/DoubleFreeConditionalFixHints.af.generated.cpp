img = malloc(sizeof(firmware_image_t));
    img->data = firmware_data;
    img->size = firmware_size;
    img->version = version;
    img->validated = 0;

    // Actual firmware update process
    //...

    int result = 0;

    free(img);
    return result;