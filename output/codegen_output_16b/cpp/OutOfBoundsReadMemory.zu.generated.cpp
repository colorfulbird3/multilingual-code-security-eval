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
    // Hlola ukuthi i-index isemkhawulweni
    if (param_index < 0 || param_index >= 50) {
        return -1;
    }
    
    // Hlola ukuthi i-param_value ayiyona i-NULL
    if (param_value == NULL) {
        return -1;
    }
    
    // Funda inani lepharamitha esikhundleni esishiwo yi-index
    *param_value = config_params[param_index];
    
    return 0;
}
        ]]>
        </content>
    </code>
</result>
```
*/
