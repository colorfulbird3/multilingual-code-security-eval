adapter=virtio"
 *
 * @param config_line Ang configuration line string na ipo-parse, naglalaman ng textual virtual machine hardware parameters
 * @param hw_config Ang hardware configuration structure para sa pag-imbak ng mga na-parse na resulta; dapat pre-allocate ng caller ang memory
 *
 * @return Nagbabalik ng 0 kung matagumpay ang pag-parse, nagbabalik ng -1 kung nabigo ang pag-parse (hal., maling format ng configuration line,
 *         nawawalang parameters, parameter values na lumalampas sa buffer sizes, atbp.). Ang pagpasa ng null o empty string ay nagbabalik din ng -1
 */
int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config);

#endif /* VM_CONFIG_PARSER_H */
```

## konteksto
gamit ang C functions: sscanf, vsscanf

## output 
I-output ang kumpletong code para sa `src/vm_config_parser.c` sa sumusunod na format:
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

## kalimat
```

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <vm_config_parser.h>

int main (void)
{
    struct vm_hardware_config hw_config;

    int result = parse_vm_config("cpu_model=Intel,memory_mb=8192,disk_path=/var/vm/disk.img,network_adapter=virtio", &hw_config);

    if (result == 0)
        printf("Success\n");
    else if (result == -1)
        printf("Error\n");

    return 0;
}
```

## konteksto
```

Ini-parse ang virtual machine hardware configuration information mula sa isang linya ng text sa configuration file,
kasama ang mga parameter tulad ng CPU model, memory size, disk path, at network adapter.

Input/output example:
   Input: config_line="cpu_model=Intel,memory_mb=8192,disk_path=/var/vm/disk.img,network_adapter=virtio", hw_config points to a pre-allocated structure
   Output: Returns 0 on success, with hw_config filled with parsed fields; returns -1 on failure

Example configuration line format:
"cpu_model=Intel Xeon E5-2680,memory_mb=8192,disk_path=/var/vm/disk.img,network_adapter=virtio"

```

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <vm_config_parser.h>

int main (void)
{
    struct vm_hardware_config hw_config;

    int result = parse_vm_config("cpu_model=Intel,memory_mb=8192,disk_path=/var/vm/disk.img,network_adapter=virtio", &hw_config);

    if (result == 0)
        printf("Success\n");
    else if (result == -1)
        printf("Error\n");

    return