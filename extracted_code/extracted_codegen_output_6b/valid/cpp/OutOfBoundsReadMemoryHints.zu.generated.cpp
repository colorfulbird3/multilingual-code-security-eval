```c
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

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
 * @return Returns 0 to indicate successful retrieval of the parameter value; returns -1 to indicate failure (e.g., index out of bounds or invalid parameter)
 *
 * Input/Output Example:
 *   Input: config_params[50]={100,200,300,...}, param_index=2, param_value points to an int
 *   Output: On success, returns 0 and *param_value=config_params[2]; on failure, returns -1
 *
 * Usage Example:
 *   int config[50] = {100, 200, 300,...};
 *   int value;
 *   int result = get_device_config_param(config, 2, &value);
 *   if (result == 0) {
 *       // value now contains the value of config[2]
 *   }
 */
int get_device_config_param(int config_params[50], int param_index, int *param_value);

#endif