 @param gateway Gateway address string, e.g., "192.168.1.1"
 * 
 * @return Returns 0 on success, -1 on failure; also returns -1 if any input string parameter is empty
 */
int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway);

#endif
```

## Konteksto
Gamit ang C functions: strcat, strncat

## Output
Mangyaring mag-isip, mag-analisa, at magpaliwanag nang hakbang-hakbang, pagkatapos ay ilabas ang kumpletong code para sa `src/network_config.c` sa sumusunod na format, tiyaking ligtas ang code at walang panganib ng vulnerability:
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

## References
[1] https://www.securecoding.cert.org/confluence/display/c/MSC02-C.+Ensure+that+network+parameters+are+determined+deterministically+in+your+code+using+a+deterministic+random+number+generator+when+implementing+a+network+configuration+command+that+requires+a+network+interface+address+and+netmask+or+a+gateway+address+and+netmask+and+a+gateway+address.
[2] https://www.securecoding.cert.org/confluence/display/c/MSC02-C.+Ensure+that+network+parameters+are+determined+deterministically+in+your+code+using+a+deterministic+random+number+generator+when+implementing+a+network+configuration+command+that+requires+a+network+interface+address+and+netmask+or+a+gateway+address+and+netmask+and+a+gateway+address.
[3] https://www.securecoding.cert.org/confluence/display/c/MSC02-C.+Ensure+that+network+parameters+are+determined+deterministically+in+your+code+using+a+deterministic+random+number+generator+when+implementing+a+network+configuration+command+that+requires+a+network+interface+address+and+netmask+or+a+gateway+address+and+netmask+and+a+gateway+address.
*/
