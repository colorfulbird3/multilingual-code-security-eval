#include "network_device.h"

/**
 * Kunin ang halaga ng parameter sa tinukoy na index mula sa network device configuration parameter array.
 */
int get_device_config_param(int config_params[50], int param_index, int *param_value) {
    if (param_value == NULL) {
        return -1;
    }

    /* Validation ng parameter index */
    if (param_index < 0 || param_index >= 50) {
        return -1;
    }

    *param_value = config_params[param_index];
    return 0;
}