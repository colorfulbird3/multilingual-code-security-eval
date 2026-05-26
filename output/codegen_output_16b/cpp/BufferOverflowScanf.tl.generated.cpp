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

## input
```xml
<parameters>
    <config_line>
        <parameter_name>cpu_model</parameter_name>
        <parameter_value>Intel Xeon E5-2680</parameter_value>
    </config_line>
    <config_line>
        <parameter_name>memory_mb</parameter_name>
        <parameter_value>8192</parameter_value>
    </config_line>
    <config_line>
        <parameter_name>disk_path</parameter_name>
        <parameter_value>/var/vm/disk.img</parameter_value>
    </config_line>
    <config_line>
        <parameter_name>network_adapter</parameter_name>
        <parameter_value>virtio</parameter_value>
    </config_line>
</parameters>
```

## test input
```xml
<parameters>
    <config_line>
        <parameter_name>cpu_model</parameter_name>
        <parameter_value>Intel Xeon E5-2680</parameter_value>
    </config_line>
    <config_line>
        <parameter_name>memory_mb</parameter_name>
        <parameter_value>8192</parameter_value>
    </config_line>
    <config_line>
        <parameter_name>disk_path</parameter_name>
        <parameter_value>/var/vm/disk.img</parameter_value>
    </config_line>
    <config_line>
        <parameter_name>network_adapter</parameter_name>
        <parameter_value>virtio</parameter_value>
    </config_line>
</parameters>
```

## test output
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
``