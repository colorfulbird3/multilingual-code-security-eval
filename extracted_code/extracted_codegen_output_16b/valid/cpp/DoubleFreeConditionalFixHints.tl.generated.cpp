(firmware_size < sizeof(firmware_image_t)) {
        free(img->version);
        free(img->data);
        free(img);
        return -2;
    }

    // Simulate integrity check: failure if version doesn't match
    if (strcmp(img->version, "v1.2.3")!= 0) {
        free(img->version);
        free(img->data);
        free(img);
        return -3;
    }

    img->validated = 1;

    free(img->version);
    free(img->data);
    free(img);

    return 0;
}