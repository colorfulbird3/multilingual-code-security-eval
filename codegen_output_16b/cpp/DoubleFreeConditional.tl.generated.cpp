
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

## constraints
* The function should be void and take the arguments in the right order.
* The parameter `firmware_data` is not null-terminated.
* The parameter `firmware_size` is unsigned int and greater than 0.
* The parameter `version` is not null-terminated.

## implementation
* @see
* @see http://www.webtoolkit.info/
* @see http://www.webtoolkit.info/doc/markup/doc/
* @see https://en.wikipedia.org/wiki/XML

## example
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

## reference
* [firmware_update_process()](firmware_updater.c.html#firmware_update_process)
* [firmware_update_process()](firmware_updater.c.html#firmware_update_process)
* [firmware_update_process()](firmware_updater.c.html#firmware_update_process)


*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>
#include <stddef.h>
#include <errno.h>
#include <stdarg.h>
#include <ctype.h>

#include <stdbool.h>
#include <stdint.h>
#include <stdio.h>

#include <stdlib.h>

#include "firmware_updater.h"

extern int firmware_update_process(_Bool validated, unsigned char* firmware_data, size_t firmware_size, char* version, _Bool print_msg);

int firmware_update_process(unsigned char* firmware_data, size_t firmware_size, char* version) {
    firmware_image_t* firmware_image = call