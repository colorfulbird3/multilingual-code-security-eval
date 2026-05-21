int items = parse_helper(config_line, "%127[^,]%[^,],%255[^,]%[^,],%255[^,]%[^,],%255[^,]%[^,],%255[^,]%[^,],%255[^,]%[^,],%255[^,]%[^,],%255[^,]%[^,],%255[^,]%[^,],%255[^,]%[^,]",
        hw_config->cpu_model, hw_config->memory_mb, hw_config->disk_path, hw_config->network_adapter);
    if (items!= 15) {
        return -1;
    }

    return 0;
}