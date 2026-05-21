Here is the implementation of the `parse_vm_config` function in C:

```c
#include "vm_config_parser.h"

int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config) {
    // Check if the input parameters are valid
    if (!config_line || !hw_config) {
        return -1;
    }

    // Initialize the hardware configuration structure
    memset(hw_config, 0, sizeof(struct vm_hardware_config));

    // Parse the configuration line using sscanf
    int result = sscanf(config_line, 
                        "cpu_model=%127[^,],memory_mb=%d,disk_path=%255[^,],network_adapter=%63s",
                        hw_config->cpu_model,
                        &hw_config->memory_mb,
                        hw_config->disk_path,
                        hw_config->network_adapter);

    // Check if all expected fields were successfully parsed
    if (result != 4) {
        return -1;
    }

    return 0;
}
```

This function takes a configuration line as a string and a pointer to a `vm_hardware_config` structure. It uses `sscanf` to parse the configuration line into the respective fields of the structure. If all fields are successfully parsed, it returns 0. If any field fails to parse or if the input parameters are invalid, it returns -1.