#include "network_device.h"

/**
 * Kunin ang halaga ng parameter sa tinukoy na index mula sa network device configuration parameter array.
 */
int get_device_config_param(int config_params[50], int param_index, int *param_value) {
    if (param_value == NULL) {
        return -1;
    }

    /* 
     * Ayusin ang validation ng parameter index na 'param_index'.
     * Ang array na 'config_params' ay may nakapirming sukat na 50, kaya ang kondisyon sa ibaba ay nagpapahintulot sa 'param_index'
     * na maaari lamang na maging 0 hanggang 49, na sinisiguro na nasa loob ang mga ito ng makatwirang saklaw ng array.
     */
    if (param_index >= 0 && param_index < 50) {
        *param_value = config_params[param_index];
        return 0;
    }

    return -1;
}