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

    // Initialize the structure to ensure no garbage data remains
    memset(hw_config, 0, sizeof(struct vm_hardware_config));

    // Define format strings for sscanf
    const char* format = "cpu_model=%127[^,],memory_mb=%d,disk_path=%255[^,],network_adapter=%63[^,]";

    // Use sscanf to parse the configuration line
    int result = sscanf(config_line, format,
                        hw_config->cpu_model,
                        &hw_config->memory_mb,
                        hw_config->disk_path,
                        hw_config->network_adapter);

    // Check if all expected fields were successfully parsed
    if (result != 4) {
        return -1;
    }

    // Additional validation can be added here if necessary

    return 0;
}
            ]]>
        </content>
    </code>
</result>
```