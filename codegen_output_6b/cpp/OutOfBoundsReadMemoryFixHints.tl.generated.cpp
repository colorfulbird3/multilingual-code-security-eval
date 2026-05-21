 `src/network_device.c` sa sumusunod na format:
```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## parametri
Parametri: 
- `config_params`: Array ng configuration parameter ng 50 mga configuration parameter entries
- `param_index`: Index ng parameter na tumutukoy sa posisyon ng parameter na babasahin sa configuration array
- `param_value`: Output parameter na ginagamit upang iimbak ang ngayon ng halaga ng parameter mula sa device configuration buffer

## example

```xml
<result>
    <code>
        <path>
            src/network_device.c
        </path>
        <content>
            <![CDATA[
#include "network_device.h"

/**
 * Kunin ang halaga ng parameter sa tinukoy na index mula sa network device configuration parameter array.
 */
int get_device_config_param(int config_params[50], int param_index, int *param_value) {
    if (param_value == NULL) {
        return -1;
    }

    /* 
     * Tala ng kasalukuyang validation ng parameter index na 'param_index' ay hindi sapat.
     * Ang array na 'config_params' ay may nakapirming sukat na 50, ngunit ang kondisyon sa ibaba ay nagpapahintulot sa 'param_index'
     * na umabot hanggang 127 at hindi sinusuri kung ang 'param_index' ay negatibo, na humahantong sa out-of-bounds read (CWE-125).
     */
    if (param_index < 128) {
        *param_value = config_params[param_index];
        return 0;
    }

    return -1;
}
        ]]>
        </content>
    </code>
</result>
```

## more

##### References

* [C99](https://www.securecoding.cert.org/confluence/display/seccode/C99-C.+)
* [C++](https://www.securecoding.cert.org/confluence/display/seccode/C++11-C++.+)
* [C11](