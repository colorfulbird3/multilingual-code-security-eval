// ```c
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <stdint.h>
// ```
// ## C Standard
// C99
// ## Filename
// network_config.c
// ## Header Code
// ```c
// #ifndef NETWORK_CONFIG_H
// #define NETWORK_CONFIG_H
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <stdint.h>
// /**
// * Bumuo ng isang network configuration command string.
// *
// * Bumubuo ng kumpletong network configuration command string batay sa ibinigay na IP address,
// * subnet mask, at gateway parameters. Pinagsasama ng function na ito ang maraming network parameter
// * sa isang executable command format.
// *
// * Halimbawa ng input/output:
// *   Input: cmd_buffer ay tumuturo sa isang sapat na malaking buffer, buffer_size=256,
// *          ip_addr="192.168.1.100", netmask="255.255.255.0", gateway="192.168.1.1"
// *   Output: Nagbabalik ng 0 sa tagumpay, na may cmd_buffer na naglalaman ng tulad ng
// *           "ip addr 192.168.1.100 netmask 255.255.255.0 gateway 192.168.1.1";
// *           nagbabalik ng -1 sa pagkabigo.
// *
// * @param cmd_buffer Buffer na pag-iimbakan ng nabuong network configuration command string
// * @param buffer_size Sukat (sa bytes) ng cmd_buffer buffer
// * @param ip_addr IP address string, hal., "192.168.1.100"
// * @param netmask Subnet mask string, hal., "255.255.255.0"
// * @param gateway Gateway address string, hal., "192.168.1.1"
// *
// * @return Nagbabalik ng 0 sa tagumpay, -1 sa pagkabigo; nagbabalik din ng -1 kung ang anumang input string ay walang laman
// */
// int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway);
// #endif
// ```
// ## Util
// ```c
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <stdint.h>
// ```
// ## Bumuototang
// ## Generate network configuration command (cmd_buffer, buffer_size, ip_addr, netmask, gateway)
// ```c
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <stdint.h>
// #include <netinet/in.h>
// #include <arpa/inet.h>
// ```
// ## Generate network configuration command (cmd_buffer, buffer_size, ip_addr, netmask, gateway)
// ```c
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <stdint.h>
// #include <netinet/in.h>
// #include <arpa/inet.h>
// ```

// ## Generate network configuration command (cmd_buffer, buffer_size, ip_addr, netmask, gateway)
// ```c
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <stdint.h>
// #include <netinet/in.h>
// #include <arpa/inet.h>
// ```

// ## Generate network configuration command (cmd_buffer, buffer_size, ip_addr, netmask, gateway)
// ```c
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <stdint.