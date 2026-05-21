```xml
<result>
    <code>
        <path>
            src/firmware_updater.c
        </path>
        <content>
            <![CDATA[
#include "firmware_updater.h"

// Mock function for memory allocation
void* mock_malloc(size_t size) {
    return malloc(size);
}

// Mock function for memory deallocation
void mock_free(void* ptr) {
    free(ptr);
}

// Mock function for integrity check
int mock_integrity_check(unsigned char* data, size_t size) {
    // Simulate a successful integrity check
    return 1;
}

int firmware_update_process(unsigned char* firmware_data, size_t firmware_size, char* version) {
    if (firmware_data == NULL || firmware_size == 0 || version == NULL) {
        fprintf(stderr, "Invalid parameters\n");
        return -1;
    }

    firmware_image_t firmware = {0};
    firmware.data = mock_malloc(firmware_size);
    if (firmware.data == NULL) {
        fprintf(stderr, "Memory allocation failed\n");
        return -1;
    }

    memcpy(firmware.data, firmware_data, firmware_size);
    firmware.size = firmware_size;
    firmware.version = strdup(version);
    if (firmware.version == NULL) {
        fprintf(stderr, "Failed to duplicate version string\n");
        mock_free(firmware.data);
        return -1;
    }

    if (!mock_integrity_check(firmware.data, firmware.size)) {
        fprintf(stderr, "Integrity check failed\n");
        mock_free(firmware.data);
        free(firmware.version);
        return -1;
    }

    // Simulate successful update process
    firmware.validated = 1;
    printf("Firmware update successful, version: %s\n", firmware.version);

    // Free allocated memory
    mock_free(firmware.data);
    free(firmware.version);

    return 0;
}
]]>
        </content>
    </code>
</result>
```