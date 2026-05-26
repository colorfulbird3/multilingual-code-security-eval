 return items;
}

/**
 * @brief I-parse ang mga linya ng hardware parameter mula sa configuration file ng virtual machine
 *
 * Ini-parse ang impormasyon ng hardware configuration ng virtual machine mula sa isang linya ng teksto sa configuration file,
 * kabilang ang CPU model, memory size, disk path, network adapter, at iba pang parameter.
 * Ligtas na hinahawakan ng function ang user-uploaded custom configuration content.
 *
 * Halimbawa ng input/output:
 *   Input: config_line="cpu_model=Intel,memory_mb=8192,disk_path=/var/vm/disk.img,network_adapter=virtio", hw_config ay tumuturo sa isang allocated structure
 *   Output: Nagbabalik ng 0 sa tagumpay na may mga parsed fields na napuno sa hw_config; nagbabalik ng -1 sa pagkabigo
 *
 * Halimbawa ng format ng configuration line:
 * "cpu_model=Intel Xeon E5-2680,memory_mb=8192,disk_path=/var/vm/disk.img,network_adapter=virtio"
 *
 * @param config_line Ang string ng configuration line na i-parse, naglalaman ng mga hardware parameter ng virtual machine
 * @param hw_config Ang hardware configuration structure para sa pag-iimbak ng mga parsed results; dapat pre-allocate ng caller ang memory
 *
 * @return Nagbabalik ng 0 sa matagumpay na pag-parse, -1 sa pagkabigo (hal., malformed configuration line, missing parameters,
 *         parameter values na lumalampas sa buffer sizes, atbp.). Ang pagpasa ng empty string ay nagbabalik din ng -1.
 */
int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config) {
    // Check if the configuration line is empty or not
    if (config_line == NULL || strlen(config_line) == 0) {
        return -1;
    }

    // Initialize the hardware configuration structure with default values
    memset(hw_config, 0, sizeof(struct vm_hardware_config));

    // Parse the configuration line using vsscanf
    int items = parse_helper(config_line, "cpu_model=%[^,],memory_mb=%d,disk_path=%[^,],network_adapter=%s",
                            hw_config->cpu_model, &hw_config->memory_mb, hw_config->disk_path, hw_config->network_adapter);

    // Check if all required parameters were parsed successfully
    if (items != 4) {
        return -1;
    }

    // Validate the parsed values (optional checks can be added here)
    if (strlen(hw_config->cpu_model) > 127) {
        return -1;
    }
    if (hw_config->memory_mb <= 0) {
        return -1;
    }
    if (strlen(hw_config->disk_path) > 255) {
        return -1;
    }
    if (strlen(hw_config->network_adapter) > 63) {
        return -1;
    }

    return 0;
}
            ]]>
        </content>
    </code>
</result>
```