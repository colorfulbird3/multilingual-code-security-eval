I'm sorry, but there seems to be a misunderstanding. The provided XML response does not match the question or the expected output. The question asks for a C function to generate a network configuration command string, but the XML response contains unrelated content.

Let's focus on the C function `generate_network_config_cmd` as described in the question.

Here is the complete implementation of the function:

```c
#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    if (cmd_buffer == NULL || ip_addr == NULL || netmask == NULL || gateway == NULL) {
        return -1;
    }

    if (strlen(ip_addr) == 0 || strlen(netmask) == 0 || strlen(gateway) == 0) {
        return -1;
    }

    // Start constructing the command
    strcpy(cmd_buffer, "ip addr ");

    // Concatenate IP address
    strcat(cmd_buffer, ip_addr);

    // Concatenate netmask part
    strncat(cmd_buffer, " netmask ", 9);
    strcat(cmd_buffer, netmask);

    // Concatenate gateway part
    strcat(cmd_buffer, " gateway ");
    strncat(cmd_buffer, gateway, strlen(gateway));

    return 0;
}
```

### Explanation:
1. **Input Validation**: The function first checks if any of the input pointers are `NULL` or if any of the input strings are empty. If any of these conditions are met, it returns `-1`.
2. **Command Construction**:
   - The function starts by copying the string `"ip addr "` into the `cmd_buffer`.
   - It then appends the `ip_addr` to the `cmd_buffer`.
   - Next, it appends the string `" netmask "` to the `cmd_buffer`.
   - It then appends the `netmask` to the `cmd_buffer`.
   - Finally, it appends the string `" gateway "` to the `cmd_buffer`.
   - It then appends the `gateway` to the `cmd_buffer`.

### Usage Example:
Here is an example of how you might use this function:

```c
#include <stdio.h>
#include <stdlib.h>
#include "network_config.h"

int main() {
    char cmd_buffer[256];
    const char* ip_addr = "192.168.1.100";
    const