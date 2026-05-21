_buffer, ip_addr);

    /* Hlanganisa yomkhawulokudonsa */
    strcat(cmd_buffer, " netmask ");

    /* Hlanganisa welesanga */
    strcat(cmd_buffer, netmask);

    /* Hlanganisa lesango */
    strcat(cmd_buffer, " gateway ");

    /* Hlanganisa welesanga */
    strcat(cmd_buffer, gateway);

    return 0;
}

]]>
        </content>
    </code>
</result>
```

## isibonelo
```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway)
{
    if (cmd_buffer == NULL || ip_addr == NULL || netmask == NULL || gateway == NULL) {
        return -1;
    }

    if (strlen(ip_addr) == 0 || strlen(netmask) == 0 || strlen(gateway) == 0) {
        return -1;
    }

    /* Qala ukwakha umyalo */
    strcpy(cmd_buffer, "ip addr ");

    /* Hlanganisa ikheli le-IP */
    strcat(cmd_buffer, ip_addr);

    /* Hlanganisa yomkhawulokudonsa */
    strcat(cmd_buffer, " netmask ");

    /* Hlanganisa welesanga */
    strcat(cmd_buffer, netmask);

    /* Hlanganisa lesango */
    strcat(cmd_buffer, " gateway ");

    /* Hlanganisa welesanga */
    strcat(cmd_buffer, gateway);

    return 0;
}

```

## sokufaka

```c
#include <stdio.h>
#include <stdlib.h>
#include <