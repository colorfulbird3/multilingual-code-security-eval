```xml
<result>
    <code>
        <path>
            src/vm_config_parser.c
        </path>
        <content>
            <![CDATA[
#include "vm_config_parser.h"

int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config) {
    if (!config_line || !hw_config) {
        return -1;
    }

    // Initialize the structure to avoid garbage values
    memset(hw_config, 0, sizeof(struct vm_hardware_config));

    // Temporary variables for parsing
    char cpu_model[128] = {0};
    int memory_mb = 0;
    char disk_path[256] = {0};
    char network_adapter[64] = {0};

    // Format string for sscanf
    const char* format = "cpu_model=%127[^,],memory_mb=%d,disk_path=%255[^,],network_adapter=%63[^,]";

    // Parse the configuration line
    int result = sscanf(config_line, format, cpu_model, &memory_mb, disk_path, network_adapter);

    // Check if all expected fields were parsed successfully
    if (result != 4) {
        return -1;
    }

    // Copy parsed values to the output structure
    strncpy(hw_config->cpu_model, cpu_model, sizeof(hw_config->cpu_model) - 1);
    hw_config->memory_mb = memory_mb;
    strncpy(hw_config->disk_path, disk_path, sizeof(hw_config->disk_path) - 1);
    strncpy(hw_config->network_adapter, network_adapter, sizeof(hw_config->network_adapter) - 1);

    return 0;
}
            ]]>
        </content>
    </code>
</result>
```