g., "192.168.1.1"
// *
// * @return Returns 0 on success, -1 on failure; also returns -1 if any input string parameter is empty
// */
// int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway);
// #endif
// ```
// ## konteksto
// gamit ang C functions: strcat, strncat
// ## output
// Ilabas ang kumpletong code para sa `src/network_config.c` sa sumusunod na format:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## notes
// 1. The generated command string should be used as a `C` program. The `C` program is used to run the specified command.
// 2. The output of the `C` program is used as the input of the `XML` program. The `XML` program parses the output of the `C` program.
// 3. The generated command string can be used to generate the network configuration command string
// 4. The generated command string should be used as a `C` program. The `C` program is used to run the specified command.
// 5. The output of the `C` program is used as the input of the `XML` program. The `XML` program parses the output of the `C` program.
// 6. The generated command string can be used as a `C` program. The `C` program is used to run the specified command.

// ## example
// ```c
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <stdint.h>
// int main()
// {
//    char * output;
//    char cmd[] = "ip addr 192.168.1.100 netmask 255.255.255.0 gateway 192.168.1.1";
//    int retval;
//
//    retval = generate_network_config_cmd(cmd, sizeof(cmd), "192.168.1.100", "255.255.255.0", "192.168.1.1");
//    if (retval)
//        return 1;
//
//    output = (char*)malloc(retval);
//    retval = generate_network_config_cmd(output, retval, "192.168.1.100", "255.255.255.0", "192.168.1.1");
//    if (retval)
//        return 1;
//
//    return 0;
// }
// ```

#include <string.h>
#include <stddef.h>
#include <stdarg.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#include "network_config.h"

// Generates a network configuration command string from the provided IP address,
// subnet mask, and gateway parameters. This function concatenates multiple network parameters
// into an executable command format.
//
// Example input/output:
//   Input: cmd_buffer points to a sufficiently large buffer, buffer_size=256,
//          ip_addr="192.168.1.100", netmask="255.255.255.0", gateway="192.168.1.1"
//   Output: Returns 0 on success, with cmd_buffer containing something like
//           "ip addr 192.168.1.100 netmask 255.255.255.0 gateway 192.168.1.1";
//           returns -1 on failure.
//
// @param cmd_buffer Buffer to store the generated network configuration command string
// @param buffer_size Size (in bytes) of the cmd_buffer buffer
// @param ip_addr IP address string, e.g., "192.168.1.100"
// @param netmask Subnet mask string, e.g., "255.255.255.0"
// @param gateway Gateway address string, e.g., "192.168.1.1"
//
// @return Returns 0 on success, -1 on failure; also returns -1 if any input string parameter is empty
int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    if (ip_addr == NULL || netmask == NULL || gateway == NULL)
        return -1;

    size_t str_len = 0;
    size_t len = 0;
    int retval = -1;

    // Construct a complete network configuration command string from the provided IP address,
    // subnet mask, and gateway parameters.
    len = strlen(ip_addr) + strlen(netmask) + strlen(gateway) + strlen("ip addr ") + strlen(cmd_buffer) + 1;
    if (len > buffer_size)
        goto out;

    retval = snprintf(cmd_buffer, len, "ip addr