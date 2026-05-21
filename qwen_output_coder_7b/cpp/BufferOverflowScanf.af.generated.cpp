The provided XML snippet contains a C function named `parse_vm_config` which is designed to parse a configuration line for a virtual machine's hardware parameters. The function takes two parameters: a string containing the configuration line and a pointer to a structure where the parsed hardware configuration will be stored.

Here's a breakdown of the function:

1. **Function Signature**:
   ```c
   int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config)
   ```
   - `const char* config_line`: A string containing the configuration line.
   - `struct vm_hardware_config* hw_config`: A pointer to a structure where the parsed hardware configuration will be stored.

2. **Input Validation**:
   ```c
   if (config_line == NULL || hw_config == NULL || strlen(config_line) == 0) {
       return -1;
   }
   ```
   - The function checks if the input parameters are valid. If any of them are invalid, it returns `-1`.

3. **Buffer Copy**:
   ```c
   char line_buffer[512];
   if (strlen(config_line) >= sizeof(line_buffer)) {
       return -1;
   }
   strcpy(line_buffer, config_line);
   ```
   - The function copies the input configuration line into a local buffer to ensure safe parsing.

4. **Parameter Parsing**:
   ```c
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
   ```
   - The function uses `sscanf` to parse the configuration line into individual parameters.

5. **Validation**:
   ```c
   if (parsed_items != 4) {
       return -1;
   }

   if (memory_mb <= 0) {
       return -1;
   }
   ```
   - The function checks if all four parameters were successfully parsed and if the memory size is positive.

6. **Storing Parsed Values**:
   ```c
   strncpy(hw_config->cpu_model, cpu_model, sizeof(hw_config->cpu_model) - 1