#include <stdio.h>

int main() {
    int config_params[50] = {10, 20, 30, 40, 50};
    int param_value;
    int index = 2;

    if (get_device_config_param(config_params, index, &param_value) == 0) {
        printf("Parameter value at index %d is %d\n", index, param_value);
    } else {
        printf("Failed to get parameter value\n");
    }

    return 0;
}