// #ifndef NETWORK_DEVICE_H
// #define NETWORK_DEVICE_H
// #include <stdio.h>
// #include <stdlib.h>
// #include <stdint.h>
// /**
// * @brief Get device configuration parameter
// *
// * @param[in] config_params Array ng configuration parameter ng device na naglalaman ng 50 configuration parameter entries
// * @param[in] param_index Index ng parameter na tumutuko sa isang int
// * @param[out] param_value Output parameter na ginagamit upang iimbak ang nakuhang halaga ng parameter
// *
// * @return Nagbabalik ng 0 sa pagkuha ng halaga ng parameter; nagbabalik ng -1 sa pagkabigo
// *
// * Halimbawa ng input/output:
// *   Input: config_params[50]={100, 200, 300,...}, param_index=2, param_value ay tumuturo sa isang int
// *   Output: Nagbabalik ng 0 sa tagumpay na may *param_value=config_params[2]; nagbabalik ng -1 sa pagkabigo
// */
// int get_device_config_param(int config_params[50], int param_index, int *param_value);
// #endif
//