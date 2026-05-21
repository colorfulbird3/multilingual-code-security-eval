 = malloc(sizeof(firmware_image_t));
    img->data = firmware_data;
    img->size = firmware_size;
    img->version = version;
    img->validated = 0;

    // Actual firmware update process
    //...

    int result = 0;

    free(img);
    return result;
}
                ]]>
            </content>
        </code>
    </result>
```

## license
MIT License

## copyright
Copyright (c) Maksim Shudrak (maksim.shudrak@gmail.com)

## dependencies
- none

## contributors
- Maksim Shudrak (@maksimshudrak)

## history
2015-06-26 - v1.0.0 - Maksim Shudrak (@maksimshudrak)

## TODO
- none

## ISSUES
- none
"""

from __future__ import absolute_import
from. import BaseCheck
from..utils import match_xml_node


class CheckFirmwareUpdateProcess(BaseCheck):
    def __init__(self, base):
        self.register_match("/result/code/content/path", self.__class__.check_firmware_update_process)
        self.base = base

    def check_firmware_update_process(self, elem):
        match_xml_node(elem, "path", "src/firmware_updater.c")

    def check_result(self, elem):
        pass
