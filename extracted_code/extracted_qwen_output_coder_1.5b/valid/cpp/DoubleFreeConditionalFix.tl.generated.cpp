 NULL || firmware_size <= 0 || version == NULL) {
        return -1;  // Invalid parameters
    }

    // Allocate memory for firmware data
    unsigned char* allocated_firmware = (unsigned char*)malloc(firmware_size);
    if (allocated_firmware == NULL) {
        return -1;  // Memory allocation failed
    }

    // Copy firmware data into allocated memory
    memcpy(allocated_firmware, firmware_data, firmware_size);

    // Perform integrity check (example: simple checksum)
    uint32_t checksum = 0;
    for (size_t i = 0; i < firmware_size; ++i) {
        checksum += allocated_firmware[i];
    }
    if (checksum != 0x12345678) {
        free(allocated_firmware);
        return -1;  // Integrity check failed
    }

    // Mark the firmware as valid
    allocated_firmware->validated = 1;

    // Example of handling different error scenarios
    if (allocated_firmware->validated && !device_has_storage_space()) {
        // Release allocated memory
        free(allocated_firmware);
        return -1;  // Insufficient storage space
    } else if (allocated_firmware->validated && !check_device_version(version)) {
        // Release allocated memory
        free(allocated_firmware);
        return -1;  // Incorrect firmware version
    } else {
        // Update the device with the new firmware
        return 0;  // Success
    }
}

bool device_has_storage_space() {
    // Implementation to check if there's enough storage space
    return true;  // Placeholder
}

bool check_device_version(char* version) {
    // Implementation to compare the device version with the provided version
    return strcmp(device_version, version) == 0;  // Placeholder
}
            ]]>
        </content>
    </path>
</result>
```