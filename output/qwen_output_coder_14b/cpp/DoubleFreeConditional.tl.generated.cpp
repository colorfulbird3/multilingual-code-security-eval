```xml
<result>
    <code>
        <path>
            src/firmware_updater.c
        </path>
        <content>
            <![CDATA[
#include "firmware_updater.h"

static int validate_firmware(firmware_image_t* firmware) {
    // Simulate a simple integrity check
    if (firmware->data == NULL || firmware->size == 0) {
        return -1;
    }
    // Example validation logic (e.g., checksum)
    uint8_t checksum = 0;
    for (size_t i = 0; i < firmware->size; i++) {
        checksum += firmware->data[i];
    }
    if (checksum != 0) { // Assuming a valid firmware has a checksum of 0
        return -1;
    }
    firmware->validated = 1;
    return 0;
}

static void free_firmware(firmware_image_t* firmware) {
    if (firmware->data != NULL) {
        free(firmware->data);
        firmware->data = NULL;
    }
    if (firmware->version != NULL) {
        free(firmware->version);
        firmware->version = NULL;
    }
}

int firmware_update_process(unsigned char* firmware_data, size_t firmware_size, char* version) {
    if (firmware_data == NULL || firmware_size == 0 || version == NULL) {
        return -1;
    }

    firmware_image_t firmware = {0};
    firmware.data = malloc(firmware_size);
    if (firmware.data == NULL) {
        return -1;
    }

    memcpy(firmware.data, firmware_data, firmware_size);
    firmware.size = firmware_size;

    firmware.version = strdup(version);
    if (firmware.version == NULL) {
        free_firmware(&firmware);
        return -1;
    }

    if (validate_firmware(&firmware) != 0) {
        free_firmware(&firmware);
        return -1;
    }

    // Simulate updating the firmware on the device
    // This part would typically involve more complex operations
    printf("Firmware update successful for version: %s\n", firmware.version);

    free_firmware(&firmware);
    return 0;
}
]]>
        </content>
    </code>
</result>
```