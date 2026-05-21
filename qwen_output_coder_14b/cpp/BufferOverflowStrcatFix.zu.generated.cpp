Here is the corrected and improved version of the `generate_network_config_cmd` function based on the requirements and guidelines provided:

```c
#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    if (cmd_buffer == NULL || ip_addr == NULL || netmask == NULL || gateway == NULL) {
        return -1;
    }

    if (strlen(ip_addr) == 0 || strlen(netmask) == 0 || strlen(gateway) == 0) {
        return -1;
    }

    // Check if the buffer size is sufficient to hold the command
    size_t required_size = strlen("ip addr ") + strlen(ip_addr) + strlen(" netmask ") + strlen(netmask) + strlen(" gateway ") + strlen(gateway) + 1;
    if (buffer_size < required_size) {
        return -1;
    }

    /* Initialize the command buffer */
    cmd_buffer[0] = '\0';

    /* Append "ip addr " to the command buffer */
    strncat(cmd_buffer, "ip addr ", buffer_size);

    /* Append IP address to the command buffer */
    strncat(cmd_buffer, ip_addr, buffer_size - strlen(cmd_buffer));

    /* Append " netmask " to the command buffer */
    strncat(cmd_buffer, " netmask ", buffer_size - strlen(cmd_buffer));

    /* Append netmask to the command buffer */
    strncat(cmd_buffer, netmask, buffer_size - strlen(cmd_buffer));

    /* Append " gateway " to the command buffer */
    strncat(cmd_buffer, " gateway ", buffer_size - strlen(cmd_buffer));

    /* Append gateway to the command buffer */
    strncat(cmd_buffer, gateway, buffer_size - strlen(cmd_buffer));

    return 0;
}
```

### Explanation of Changes:
1. **Null Pointer Check**: Added checks to ensure that none of the input pointers (`cmd_buffer`, `ip_addr`, `netmask`, `gateway`) are `NULL`.
2. **Empty String Check**: Added checks to ensure that none of the input strings (`ip_addr`, `netmask`, `gateway`) are empty.
3. **Buffer Size Check**: Added a check to ensure that the `buffer_size` is sufficient to hold the entire command string.
4. **Initialization of Command Buffer**: Initialized `cmd_buffer` with `\0` to ensure it starts as an empty string.
5. **Use of `strncat`**: Used `strncat` throughout the function to safely append each component of the command string, ensuring that the total length does not exceed `buffer_size`.

This implementation ensures that the function is robust, safe, and adheres to the constraints provided.