strncpy(hw_config->cpu_model, cpu_model, sizeof(hw_config->cpu_model) - 1);
   hw_config->cpu_model[sizeof(hw_config->cpu_model) - 1] = '\0';

   hw_config->memory_mb = memory_mb;

   strncpy(hw_config->disk_path, disk_path, sizeof(hw_config->disk_path) - 1);
   hw_config->disk_path[sizeof(hw_config->disk_path) - 1] = '\0';

   strncpy(hw_config->network_adapter, network_adapter, sizeof(hw_config->network_adapter) - 1);
   hw_config->network_adapter[sizeof(hw_config->network_adapter) - 1] = '\0';