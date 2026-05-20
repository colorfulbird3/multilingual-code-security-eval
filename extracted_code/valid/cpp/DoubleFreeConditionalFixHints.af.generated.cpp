#include "firmware_updater.h"

int firmware_update_process(unsigned char* firmware_data, size_t firmware_size, char* version) {
    if (firmware_data == NULL || firmware_size == 0 || version == NULL) {
        return -1;
    }

    firmware_image_t *img = (firmware_image_t*)malloc(sizeof(firmware_image_t));
    if (img == NULL) {
        return -1;
    }

    img->data = (unsigned char*)malloc(firmware_size);
    if (img->data == NULL) {
        free(img);
        return -1;
    }

    memcpy(img->data, firmware_data, firmware_size);
    img->size = firmware_size;
    img->version = strdup(version);
    img->validated = 0;

    // Simuleer integriteitskontrole: mislukking as grootte te klein is vir kopskrif
    if (firmware_size < 64) {
        if (img->