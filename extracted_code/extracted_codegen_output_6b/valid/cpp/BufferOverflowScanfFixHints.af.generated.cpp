```c
int items = parse_helper(config_line, "%s", hw_config->cpu_model);
if (items < 0) {
    return -1;
}

items = parse_helper(config_line, "%d", &hw_config->memory_mb);
if (items < 0) {
    return -1;
}

items = parse_helper(config_line, "%s", hw_config->disk_path);
if (items < 0) {
    return -1;
}

items = parse_helper(config_line, "%s", hw_config->network_adapter);
if (items < 0) {
    return -1;
}

return 0;
```