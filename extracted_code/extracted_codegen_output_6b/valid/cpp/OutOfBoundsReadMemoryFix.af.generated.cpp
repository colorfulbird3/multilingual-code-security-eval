#include "network_device.h"

/**
 * Haal die parameterwaarde by die gespesifiseerde indeks uit die netwerktoestelkonfigurasieparameterskikking.
 */
int get_device_config_param(int config_params[50], int param_index, int *param_value) {
    if (param_value == NULL) {
        return -1;
    }

    /* 
     * Kwesbaarheidsnota: Die huidige validering van die parameterindeks 'param_index' is onvoldoende.
     * Die skikking 'config_params' het 'n vaste grootte van 50, maar die toestand hieronder laat 'param_index'
     * tot 127 toe en kontroleer nie of 'param_index' negatief is nie,
     * wat moontlik 'n buite-perke lees (CWE-125) kan veroorsaak.
     */
    if (param_index < 128) {
        *param_value = config_params[param_index];
        return 0;
    }

    return -1;
}