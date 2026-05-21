```xml
<result>
    <code>
        <path>
            src/network_config_parser.c
        </path>
        <content>
            <![CDATA[
#include "network_config_parser.h"

int parse_network_config_params(char* buffer, int buffer_size, char** params, int param_count) {
    if (buffer == NULL || params == NULL || param_count <= 0 || buffer_size <= 0) {
        return -1;
    }

    int parsed_count = 0;
    int current_offset = 0;

    for (int i = 0; i < param_count; i++) {
        if (params[i] == NULL) {
            continue;
        }

        int param_len = strlen(params[i]);
        // +1 for null terminator
        if (current_offset + param_len + 1 > buffer_size) {
            return -1;
        }

        strcpy(buffer + current_offset, params[i]);
        current_offset += param_len + 1;
        parsed_count++;
    }

    return parsed_count;
}
            ]]>
        </content>
    </code>
</result>
```

### Consequence

A new `network_config_parser.h` file is added to the source code. The `network_config_parser.h` file includes the `network_config_parser.c` file. The `network_config_parser.c` file imports `network_config_parser.h` using the `#include` directive.

### Example

##### Make the `network_config_parser.h` file.

```sh
mkdir -p src/network_config_parser
```

##### Update the network_config_parser.c file.

```sh
cd src/network_config_parser/
cp../../network_config_parser.c network_config_parser.c
sed -i -e's/#\$\(INCLUDE_PREFIX\)//$(INCLUDE_PREFIX)/' network_config_parser.c
sed -i -e's/#\$\(INCLUDE_SUFFIX\)//$(INCLUDE_SUFFIX)/' network_config_parser.c
sed -i -e's/#\$\(HASH_HOST_NAME\)//$(HASH_HOST_NAME)/' network_config_parser.c
sed -i -e's/#\$\(HASH_HOST_MAC\)//$(HASH_HOST_MAC)/' network_config_parser.c
sed -i -e's/#\$\(HASH_HOST_IPV4\)//$(HASH_HOST_IPV4)/' network_config_parser.c
sed -i -e's/#\$\(HASH_HOST_IPV6\)//$(HASH_HOST_IPV6)/' network_config_parser.c
sed -i -e's/#\$\(HASH_HOST_VLAN_ID\)//$(HASH_HOST_VLAN_ID)/' network_config_parser.c
sed -i -e's/#\$\(HASH_HOST_ADDR6\)//$(HASH_HOST_ADDR6)/' network_config_parser.c
