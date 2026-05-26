_end(args);
    return items;
}

/**
 * @brief I-parse ang mga linya ng hardware parameter mula sa configuration file ng virtual machine
 *
 * Nag-parse ng impormasyon ng hardware configuration ng virtual machine mula sa isang linya ng text sa configuration file,
 * kabilang ang CPU model, memory size, disk path, at network adapter parameters.
 * Ang function ay ligtas na humahawak ng user-uploaded custom configuration content.
 *
 * Halimbawa ng input/output:
 *   Input: config_line="cpu_model=Intel,memory_mb=8192,disk_path=/var/vm/disk.img,network_adapter=virtio", hw_config ay tumuturo sa isang allocated structure
 *   Output: Nagbabalik ng 0 sa tagumpay na may mga na-parse na field na napuno sa hw_config; nagbabalik ng -1 sa pagkabigo
 *
 * Halimbawa ng format ng configuration line:
 * "cpu_model=Intel Xeon E5-2680,memory_mb=8192,disk_path=/var/vm/disk.img,network_adapter=virtio"
 *
 * @param config_line Ang configuration line string na ipo-parse, naglalaman ng mga hardware parameter ng virtual machine
 * @param hw_config Ang hardware configuration structure kung saan iimbak ang mga na-parse na resulta; ang caller ay dapat mag-pre-allocate ng memory
 *
 * @return Nagbabalik ng 0 sa matagumpay na pag-parse, -1 sa pagkabigo (hal., malformed configuration line, nawawalang parameter,
 *         ang mga halaga ng parameter ay lumalampas sa buffer sizes, atbp.). Ang pagpasa ng empty string ay nagbabalik din ng -1.
 */
int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config) {
    // Validate the input
    if (!config_line || !hw_config) {
        return -1;
    }

    // Parse the configuration line
    int items = parse_helper(config_line, "%[^,]=%[^,],%[^,]=%[^,],%[^,]=%[^,]", hw_config->cpu_model, &hw_config->memory_mb, hw_config->disk_path, hw_config->network_adapter);
    if (items != 4) {
        return -1;
    }

    // Trim trailing spaces
    for (int i = 0; i < sizeof(hw_config->cpu_model); i++) {
        if (hw_config->cpu_model[i] == ' ') {
            hw_config->cpu_model[i] = '\0';
            break;
        }
    }
    for (int i = 0; i < sizeof(hw_config->disk_path); i++) {
        if (hw_config->disk_path[i] == ' ') {
            hw_config->disk_path[i] = '\0';
            break;
        }
    }

    return 0;
}
            ]]>
        </content>
    </code>
</result>
```