```xml
<result>
    <code>
        <path>src/vm_config_parser.c</path>
        <content>
            <![CDATA[
/*
 * vm_config_parser.c
 *
 * This file contains the implementation of the parse_vm_config function, which parses
 * virtual machine hardware configuration information from a single line of text.
 */

#include "vm_config_parser.h"

int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config) {
    if (config_line == NULL || hw_config == NULL) {
        return -1;
    }

    // Initialize the hardware configuration structure
    memset(hw_config, 0, sizeof(struct vm_hardware_config));

    // Use sscanf to parse the configuration line
    int result = sscanf(config_line, "cpu_model=%127[^,],memory_mb=%d,disk_path=%255[^,],network_adapter=%63s",
                        hw_config->cpu_model, &hw_config->memory_mb, hw_config->disk_path, hw_config->network_adapter);

    // Check if all required parameters were parsed successfully
    if (result != 4) {
        return -1;
    }

    return 0;
}
]]>
        </content>
    </code>
</result>
```