```xml
<result>
    <code>
        <path>src/network_device.c</path>
        <content><![CDATA[
#include "network_device.h"

int get_device_config_param(int config_params[50], int param_index, int *param_value) {
    if (param_index >= 0 && param_index < 50) {
        *param_value = config_params[param_index];
        return 0;
    } else {
        return -1;
    }
}
]]></content>
    </code>
</result>
```