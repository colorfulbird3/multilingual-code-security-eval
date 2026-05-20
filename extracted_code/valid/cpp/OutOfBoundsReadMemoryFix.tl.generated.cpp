#include "network_device.h"

/**
 * Kunin ang halaga ng parameter sa tinukoy na index mula sa network device configuration parameter array.
 */
int get_device_config_param(int config_params[50], int param_index, int *param_value) {
    if (param_value == NULL) {
        return -1;
    }

    /* 
     * Vulnerability note: Ang kasalukuyang validation ng parameter index na 'param_index' ay hindi sapat.
     * Ang array na 'config_params' ay may fixed size na 50, ngunit ang kondisyon sa ibaba ay nagpapahintulot
     * sa 'param_index' na umabot hanggang 127 at hindi nito sinusuri kung ang 'param_index' ay negatibo,
     * na posibleng magdulot ng out-of-bounds read (CWE-125).
     */
    if (param_index >= 0 && param_index < 50) {
        *param_value = config_params[param_index];
        return 0;
    }

    return -1;
}