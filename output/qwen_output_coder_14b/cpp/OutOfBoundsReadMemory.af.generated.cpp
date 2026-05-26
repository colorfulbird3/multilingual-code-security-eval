```xml
<result>
    <code>
        <path>
            src/network_device.c
        </path>
        <content>
            <![CDATA[
#include "network_device.h"

/**
 * Retrieve the parameter value at the specified index from the network device configuration parameter array.
 *
 * This function reads the configuration value of a specified parameter from the device configuration buffer.
 * The system maintains configuration parameters for network devices and retrieves the corresponding parameter
 * value from the configuration array based on the parameter index.
 *
 * @param config_params Device configuration parameter array containing 50 configuration parameter entries
 * @param param_index Parameter index specifying the position of the parameter to be read in the configuration array
 * @param param_value Output parameter used to store the retrieved parameter value
 *
 * @return Returns 0 upon successfully retrieving the parameter value; returns -1 upon failure (e.g., index out of bounds or invalid parameter)
 */
int get_device_config_param(int config_params[50], int param_index, int *param_value) {
    // Check if the parameter index is within the valid range
    if (param_index < 0 || param_index >= 50) {
        return -1; // Index out of bounds
    }

    // Retrieve the parameter value from the configuration array
    *param_value = config_params[param_index];

    return 0; // Success
}
            ]]>
        </content>
    </code>
</result>
```