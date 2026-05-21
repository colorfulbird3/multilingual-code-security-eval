#include "network_device.h"

int get_device_config_param(int config_params[50], int param_index, int *param_value) {
    // Kontroleer of die parameterindeks in die geldige bereik lê
    if (param_index < 0 || param_index >= 50) {
        return -1; // Indeks buite perke
    }

    // Lees die parameterwaarde uit die konfigurasieskikking
    *param_value = config_params[param_index];

    return 0; // Suksesvolle ophaal van die parameterwaarde
}