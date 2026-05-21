Here is the corrected and improved version of the `get_device_config_param` function based on the provided guidelines:

```c
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
```

### Explanation of Changes:
1. **Null Pointer Check**: The function first checks if the `param_value` pointer is `NULL`. If it is, the function returns `-1` to indicate an error.

2. **Index Range Check**: The function then checks if the `param_index` is within the valid range (0 to 49). This ensures that the index does not go out of bounds, which could lead to undefined behavior.

3. **Return Values**: If the index is valid, the function assigns the value at `config_params[param_index]` to `*param_value` and returns `0` to indicate success. If either of the checks fail, it returns `-1`.

This implementation adheres to the guidelines provided, ensuring that the function is robust and handles potential errors gracefully.