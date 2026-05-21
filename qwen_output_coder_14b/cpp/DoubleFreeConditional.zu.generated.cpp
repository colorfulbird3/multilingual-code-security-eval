```xml
<result>
    <code>
        <path>
            src/firmware_updater.c
        </path>
        <content>
            <![CDATA[
#include "firmware_updater.h"

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
        free(firmware_image); // Free previously allocated memory
        return -1; // Memory allocation failure
    }

    memcpy(firmware_image->data, firmware_data, firmware_size);
    firmware_image->size = firmware_size;
    firmware_image->version = strdup(version);
    if (firmware_image->version == NULL) {
        free(firmware_image->data);
        free(firmware_image);
        return -1; // Memory allocation failure
    }

    // Simulate integrity verification
    firmware_image->validated = 1; // Assume validation is successful

    if (!firmware_image->validated) {
        free(firmware_image->version);
        free(firmware_image->data);
        free(firmware_image);
        return -1; // Firmware integrity verification failure
    }

    // Simulate device storage check
    // For simplicity, assume there is enough storage space

    // Update firmware (simulated)
    // ...

    free(firmware_image->version);
    free(firmware_image->data);
    free(firmware_image);

    return 0; // Firmware update succeeded
}
            ]]>
        </content>
    </code>
</result>
```