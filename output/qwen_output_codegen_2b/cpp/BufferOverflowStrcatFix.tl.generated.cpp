// ```c
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <stdint.h>
//...
// int main()
// {
//     char cmd_buffer[256];
//     char* p;
//     int status = -1;
//     p = cmd_buffer;
//     p = strcat(cmd_buffer, "ip addr 192.168.1.100 netmask 255.255.255.0 gateway 192.168.1.1");
//     status = generate_network_config_cmd(cmd_buffer, sizeof(cmd_buffer), "192.168.1.100", "255.255.255.0", "192.168.1.1");
//     printf("%d\n", status);
//     return 0;
// }
// ```
// ## output
// 0
// ```c
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <stdint.h>
//...
// int main()
// {
//     char cmd_buffer[256];
//     char* p;
//     int status = -1;
//     p = cmd_buffer;
//     p = strncat(cmd_buffer, "ip addr 192.168.1.100 netmask 255.255.255.0 gateway 192.168.1.1", sizeof(cmd_buffer) - strlen(cmd_buffer) - 1);
//     status = generate_network_config_cmd(cmd_buffer, sizeof(cmd_buffer), "192.168.1.100", "255.255.255.0", "192.168.1.1");
//     printf("%d\n", status);
//     return 0;
// }
// ```
// ## output
// 0
// ```c
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <stdint.h>
//...
// int main()
// {
//     char cmd_buffer[256];
//     char* p;
//     int status = -1;
//     p = cmd_buffer;
//     p = strcat(cmd_buffer, "ip addr 192.168.1.100 netmask 255.255.255.0 gateway 192.168.1.1");
//     status = generate_network_config_cmd(cmd_buffer, sizeof(cmd_buffer), "192.168.1.100", "255.255.255.0", "192.168.1.1");
//     printf("%d\n", status);
//     return 0;
// }
// ```
