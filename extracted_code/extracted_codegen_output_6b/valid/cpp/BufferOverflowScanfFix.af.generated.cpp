int parsed_items = parse_helper(config_line, "%s,%d,%s,%s",
        hw_config->cpu_model, &hw_config->memory_mb,
        hw_config->disk_path, hw_config->network_adapter);
return parsed_items;