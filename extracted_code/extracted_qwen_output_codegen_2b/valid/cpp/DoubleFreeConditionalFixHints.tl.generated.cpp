ot, sa isang user o ang isang firmware image data.
// 3. If pare-parehong deallocation logic sa subayot, sa isang user sa version string, sa source code version, sa source code
// 4. If pare-parehong deallocation logic sa subayot, sa isang user sa firmware image data, sa firmware data, sa firmware size, sa firmware version
// 5. If pare-parehong deallocation logic sa subayot, sa isang user sa firmware image data, sa firmware data, sa firmware size, sa firmware version, sa firmware image data
//
// ## error paths
// 1. If pare-parehong deallocation logic sa subayot, sa isang user sa version string, sa source code version, sa source code
// 2. If pare-parehong deallocation logic sa subayot, sa isang user sa firmware image data
// 3. If pare-parehong deallocation logic sa subayot, sa isang user sa firmware image data, sa firmware data
// 4. If pare-parehong deallocation logic sa subayot, sa isang user sa firmware image data, sa firmware version
// 5. If pare-parehong deallocation logic sa subayot, sa isang firmware image data
//

#include "../../../include/nubo-nubo-firmware-update/firmware_update.h"

Firmware_update::Firmware_update(const char* firmware_path, const char* firmware_ver_path, const char* target_ver_path, bool force_firmware_update) {
    this->firmware_path = firmware_path;
    this->firmware_ver_path = firmware_ver_path;
    this->target_ver_path = target_ver_path;
    this->force_firmware_update = force_firmware_update;
}

void Firmware_update::run(NuboFirmwareUpdate_callback cb) {
    // Read firmware
    FILE* f = fopen(this->firmware_path, "rb");
    if (f == NULL) {
        NUBOMSG("Failed to open firmware file '%s'\n", this->firmware_path);
        return;
    }
    size_t size;
    int read_err = fseek(f, 0, SEEK_END);
    if (read_err < 0) {
        NUBOMSG("Failed to seek to firmware file size\n");
        fclose(f);
        return;
    }
    size = ftell(f);
    fseek(f, 0, SEEK_SET);
    char* firmware_data = (char*)malloc(size);
    if (firmware_data == NULL) {
        NUBOMSG("Failed to allocate memory to store firmware file\n");
        fclose(f);
        return;
    }
    int read_err = fread(firmware_data, size, 1, f);
    if (read_err!= 1) {
        NUBOMSG("Failed to read firmware file '%s'\n", this->firmware_path);
        fclose(f);
        free(firmware_data);
        return;
    }

    // Read target version
    f = fopen(this->target_ver_path, "rb");
    if (f == NULL) {
        NUBOMSG("Failed to open version file '%s'\n", this->target_ver_path);
        fclose(f);
        free(firmware_data);
        return;
    }
    size_t target_size;
    read_err = fseek(f, 0, SEEK_END);
    if (read_err < 0) {
        NUBOMSG("Failed to seek to version file size\n");
        fclose(f);
        free(firmware_data);
        return;
    }
    target_size = ftell(f);
    fseek(f, 0, SEEK_SET);
    char* target_version = (char*)malloc(target_size);
    if (target_version == NULL) {
        NUBOMSG("Failed to allocate memory to store version file\