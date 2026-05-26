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
    // Check if the parameter index is within the valid range
    if (param_index < 0 || param_index >= 50) {
        return -1; // Return -1 to indicate failure due to invalid index
    }

    // Assign the parameter value at the specified index to the output parameter
    *param_value = config_params[param_index];

    return 0; // Return 0 to indicate successful retrieval of the parameter value
}
            ]]>
        </content>
    </code>
</result>
```