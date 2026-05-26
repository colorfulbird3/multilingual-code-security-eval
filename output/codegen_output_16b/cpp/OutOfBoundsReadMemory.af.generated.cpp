ende formaat:
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

## testcase
```c
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

#include "network_device.h"

int main() {
    // setup

    // run test case
    // get_device_config_param(<config_params>, <param_index>, <param_value>);

    // cleanup
    return 0;
}
```

## expected output
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

## input
```xml
<testcase>
    <title>testcase description</title>
    <config>
        <device_ip>192.168.1.1</device_ip>
        <device_port>80</device_port>
        <device_mac>00:00:00:00:00:00</device_mac>
        <config_params>
            <param1>value1</param1>
            <param2>value2</param2>
            <param3>value3</param3>
           ...
        </config_params>
    </config>
</testcase>
```

## verwerking
- Maak surel die funksie `get_device_config_param` = deur de 'config_params' array de volgende waarden bevat:
- Onthou die parameter indeks die voor de waarde die moet worden gebruikt is 'param_index'.
- Onthou die waarde die moet worden getoone is 'param_value'.
- Onthou die funksie is gebaseerd op de waarde die moet worden gebruikt aan die 'config_params' waarde 'param_index'.
- Onthou die funksie gebaseerd op die 'config_params' waarde 'param_index' is een parameterwaarde die moet worden gebruikt in die 'config