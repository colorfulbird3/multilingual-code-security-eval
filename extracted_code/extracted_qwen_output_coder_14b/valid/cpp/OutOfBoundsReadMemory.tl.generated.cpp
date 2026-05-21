#include "network_device.h"

int get_device_config_param(int config_params[50], int param_index, int *param_value) {
    // Check if the provided index is within the valid range
    if (param_index < 0 || param_index >= 50) {
        return -1; // Invalid index
    }

    // Assign the value from the configuration array to the output parameter
    *param_value = config_params[param_index];

    return 0; // Success
}