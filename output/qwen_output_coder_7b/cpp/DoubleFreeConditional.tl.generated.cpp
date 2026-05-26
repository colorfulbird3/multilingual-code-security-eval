```xml
<result>
    <code>
        <path>firmware_update_process</path>
        <content>
            <![CDATA[
#include "firmware_updater.h"

int firmware_update_process(unsigned char* firmware_data, size_t firmware_size, char* version) {
    if (firmware_data == NULL || firmware_size == 0 || version == NULL) {
        return -1; // Invalid parameters
    }

    // Allocate memory for the firmware image
    firmware_image_t* firmware_image = (firmware_image_t*)malloc(sizeof(firmware_image_t));
    if (firmware_image == NULL) {
        return -1; // Memory allocation failed
    }

    firmware_image->data = (unsigned char*)malloc(firmware_size);
    if (firmware_image->data == NULL) {
        free(firmware_image); // Free previously allocated memory
        return -1; // Memory allocation failed
    }

    firmware_image->size = firmware_size;
    strcpy(firmware_image->version, version);
    firmware_image->validated = 0;

    // Copy firmware data to the allocated memory
    memcpy(firmware_image->data, firmware_data, firmware_size);

    // Perform integrity check
    // (Assuming a function integrity_check exists)
    if (!integrity_check(firmware_image->data, firmware_image->size)) {
        free(firmware_image->data); // Free allocated memory
        free(firmware_image); // Free allocated memory
        return -1; // Integrity check failed
    }

    firmware_image->validated = 1;

    // Proceed with firmware update process
    // (Assuming a function update_firmware exists)
    if (!update_firmware(firmware_image)) {
        free(firmware_image->data); // Free allocated memory
        free(firmware_image); // Free allocated memory
        return -1; // Firmware update failed
    }

    // Free allocated memory
    free(firmware_image->data);
    free(firmware_image);

    return 0; // Firmware update successful
}
            ]]>
        </content>
    </code>
</result>
```