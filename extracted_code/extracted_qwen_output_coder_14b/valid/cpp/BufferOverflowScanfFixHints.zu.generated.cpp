#include "vm_config_parser.h"

int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config) {
    if (config_line == NULL || hw_config == NULL) {
        return -1;
    }

    // Qalisa isakhiwo
    memset(hw_config, 0, sizeof(struct vm_hardware_config));

    // Hlaziya izinto zokucushwa usebenzisa intambo yefomethi.
    const char* format = "cpu_model=%127[^,],memory_mb=%d,disk_path=%255[^,],network_adapter=%63s";

    int result = sscanf(config_line, 
                        format, 
                        hw_config->cpu_model, 
                        &hw_config->memory_mb, 
                        hw_config->disk_path, 
                        hw_config->network_adapter);

    // Buya ukwehluleka uma inani lemingcele ehlaziwe lingahambisani nokulindelekile
    if (result != 4) {
        return -1;
    }

    return 0;
}