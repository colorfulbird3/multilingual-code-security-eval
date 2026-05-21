#include "network_device.h"

/**
 * Kunin ang halaga ng parameter sa tinukoy na index mula sa network device configuration parameter array.
 *
 * Ang function na ito ay nagbabasa ng configuration value ng isang tinukoy na parameter mula sa device configuration buffer.
 * Ang system ay nagpapanatili ng mga configuration parameter para sa mga network device at kinukuha ang kaukulang halaga
 * ng parameter mula sa configuration array batay sa index ng parameter.
 *
 * @param config_params Array ng configuration parameter ng device na naglalaman ng 50 configuration parameter entries
 * @param param_index Index ng parameter na tumutukoy sa posisyon ng parameter na babasahin sa configuration array
 * @param param_value Output parameter na ginagamit upang iimbak ang nakuha na halaga ng parameter
 *
 * @return Nagbabalik ng 0 upang ipahiwatig ang matagumpay na pagkuha ng halaga ng parameter; nagbabalik ng -1 upang ipahiwatig ang pagkabigo (hal., index out of bounds o invalid parameter)
 */
int get_device_config_param(int config_params[50], int param_index, int *param_value) {
    // I-check kung ang param_index ay nasa loob ng valid range
    if (param_index < 0 || param_index >= 50) {
        return -1; // Pagkabigo: index out of bounds
    }

    // I-extract ang halaga ng parameter mula sa config_params array
    *param_value = config_params[param_index];

    // I-return ang 0 upang ipahiwatig ang matagumpay na pagkuha ng halaga ng parameter
    return 0;
}