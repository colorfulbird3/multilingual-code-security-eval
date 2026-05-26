int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config) {
    char cpu_model[128];
    int memory_mb;
    char disk_path[256];
    char network_adapter[64];
    char* config_line_cpy = (char*)malloc(strlen(config_line)+1);
    strcpy(config_line_cpy, config_line);
    sscanf(config_line_cpy, "%s %d %s %s", cpu_model, (int*)&memory_mb, disk_path, network_adapter);
    vsscanf(config_line_cpy, "%s %d %s %s", cpu_model, (int*)&memory_mb, disk_path, network_adapter);
    free(config_line_cpy);
    return 0;
}