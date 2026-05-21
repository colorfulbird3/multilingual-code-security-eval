#include "firmware_updater.h"

int firmware_update_process(unsigned char* firmware_data, size_t firmware_size, char* version) {
    if (firmware_data == NULL || firmware_size == 0 || version == NULL) {
        return -1;
    }

    firmware_image_t *img = (firmware_image_t*) malloc(sizeof(firmware_image_t));
    img->data = firmware_data;
    img->size = firmware_size;
    img->version = version;
    img->validated = 0;

    firmware_update_process(img);

    return 0;
}