 ```xml
<result>
    <code>
        <path>
            src/network_device.c
        </path>
        <content>
            <![CDATA[
#include "network_device.h"

int get_device_config_param(int config_params[50], int param_index, int *param_value) {
    // Check if the param_index is within the valid range
    if (param_index < 0 || param_index >= 50) {
        return -1;
    }
    
    // Check if the param_value pointer is not NULL
    if (param_value == NULL) {
        return -1;
    }
    
    // Assign the value of the parameter at the given index to param_value
    *param_value = config_params[param_index];
    
    return 0;
}
        ]]>
        </content>
    </code>
</result>
```