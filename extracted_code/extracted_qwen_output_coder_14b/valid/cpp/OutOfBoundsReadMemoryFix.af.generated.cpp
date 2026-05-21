#include "network_device.h"

/**
 * Haal die parameterwaarde by die gespesifiseerde indeks uit die netwerktoestelkonfigurasieparameterskikking.
 */
int get_device_config_param(int config_params[50], int param_index, int *param_value) {
    if (param_value == NULL) {
        return -1;
    }

    /* 
     * Verbeterde validering van die parameterindeks 'param_index'.
     * Die skikking 'config_params' het 'n vaste grootte van 50, dus 'param_index'
     * moet tussen 0 en 49 lig.
     */
    if (param_index >= 0 && param_index < 50) {
        *param_value = config_params[param_index];
        return 0;
    }

    return -1;
}