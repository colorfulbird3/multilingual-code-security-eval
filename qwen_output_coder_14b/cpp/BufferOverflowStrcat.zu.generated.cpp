This XML snippet contains a code example for a function named `generate_network_config_cmd`. This function is designed to generate a network configuration command string based on the provided IP address, netmask, and gateway parameters. Here's a breakdown of the function:

### Function Signature
```c
int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway)
```
- **Parameters:**
  - `cmd_buffer`: A pointer to the buffer where the generated command will be stored.
  - `buffer_size`: The size of the `cmd_buffer`.
  - `ip_addr`: A pointer to the string representing the IP address.
  - `netmask`: A pointer to the string representing the netmask.
  - `gateway`: A pointer to the string representing the gateway.

- **Return Value:**
  - Returns `0` on success.
  - Returns `-1` if any of the input parameters are `NULL`, empty, or if the combined length of the command exceeds the buffer size.

### Function Logic
1. **Input Validation:**
   - Checks if any of the input pointers (`cmd_buffer`, `ip_addr`, `netmask`, `gateway`) are `NULL`.
   - Checks if any of the input strings (`ip_addr`, `netmask`, `gateway`) are empty.

2. **Length Calculation:**
   - Calculates the total length of the command string that will be generated.
   - Ensures that the total length does not exceed the provided `buffer_size`.

3. **Command Construction:**
   - Initializes `cmd_buffer` with a null character to ensure it starts as an empty string.
   - Uses `strncat` to safely append each component of the command to `cmd_buffer`, ensuring that the buffer does not overflow.

4. **Return:**
   - Returns `0` if the command is successfully constructed and fits within the buffer.
   - Returns `-1` if any validation fails or if the command exceeds the buffer size.

### Example Usage
```c
char cmd[100];
if (generate_network_config_cmd(cmd, sizeof(cmd), "192.168.1.100", "255.255.255.0", "192.168.1.1") == 0) {
    printf("Generated Command: %s\n", cmd);
} else {
    printf("Failed to generate command.\n");
}
```

This function is useful for dynamically generating network configuration commands based on runtime inputs, which can be particularly handy in network management or automation scripts.