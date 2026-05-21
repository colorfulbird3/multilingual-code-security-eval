#include "network_device.h"

/**
 * Thola inani lepharamitha enkomba ecacisiwe kusuka kuhlu lwamapharamitha okuhlelwa kwemishini yenethiwekhi.
 */
int get_device_config_param(int config_params[50], int param_index, int *param_value) {
    // Check if the pointer to the parameter value is valid
    if (param_value == NULL) {
        return -1;
    }

    // Ensure the parameter index is within the valid range
    if (param_index >= 0 && param_index < 50) {
        *param_value = config_params[param_index];
        return 0;
    }

    return -1;
}