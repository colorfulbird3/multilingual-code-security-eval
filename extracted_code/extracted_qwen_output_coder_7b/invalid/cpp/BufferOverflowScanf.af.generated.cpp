char cpu_model[128] = {0};
   int memory_mb = 0;
   char disk_path[256] = {0};
   char network_adapter[64] = {0};

   int parsed_items = sscanf(line_buffer,
                             "cpu_model=%127[^,],memory_mb=%d,disk_path=%255[^,],network_adapter=%63[^,\n]",
                             cpu_model,
                             &memory_mb,
                             disk_path,
                             network_adapter);