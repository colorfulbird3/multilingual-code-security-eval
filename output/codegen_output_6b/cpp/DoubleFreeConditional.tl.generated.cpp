
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
`src/firmware_updater.c` sa sumusunod na format:
```xml
<context>
    <parameter name="firmware_data">
        <![CDATA[
        firmware_data
        ]]>
    </parameter>
    <parameter name="firmware_size">
        <![CDATA[
        firmware_size
        ]]>
    </parameter>
    <parameter name="version">
        <![CDATA[
        version
        ]]>
    </parameter>
</context>
```

## bug report
* Bug: `firmware_size` should be `size_t`
* Bug: `version` should be `char*`
* Bug: `firmware_data` should be `unsigned char*`
* Bug: `firmware_data` should be `char*`
* Bug: `firmware_data` should be `char*`
* Bug: `firmware_data` should be `char*`
* Bug: `firmware_data` should be `char*`
* Bug: `firmware_data` should be `char*`
* Bug: `version` should be `char*`
* Bug: `version` should be `char*`
* Bug: `version` should be `char*`
* Bug: `version` should be `char*`
* Bug: `version` should be `char*`
* Bug: `version` should be `char*`
* Bug: `version` should be `char*`

## licence
Copyright (c) 2014-2016 - All right reserved - Tawagata Story <story@tawagata.io>

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.

3. Neither the name of the