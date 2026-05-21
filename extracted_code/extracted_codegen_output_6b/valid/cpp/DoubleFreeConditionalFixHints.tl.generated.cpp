```c
if (firmware_size < sizeof(uint32_t)*2) {
        free(img->data);
        free(img->version);
        return -1;
    }

    // Check firmware header
    uint32_t header_magic;
    memcpy(&header_magic, img->data, sizeof(uint32_t));
    if (header_magic!= 0x46445457) {
        free(img->data);
        free(img->version);
        return -1;
    }

    uint32_t header_version;
    memcpy(&header_version, img->data + sizeof(uint32_t), sizeof(uint32_t));
    if (header_version!= 0x01000002) {
        free(img->data);
        free(img->version);
        return -1;
    }

    // Process firmware image
    return 0;
```