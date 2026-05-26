* gateway) {
    if (strlen(ip_addr) == 0 || strlen(netmask) == 0 || strlen(gateway) == 0) {
        return -1;
    }

    size_t total_length = snprintf(cmd_buffer, buffer_size, "ip addr %s netmask %s gateway %s", ip_addr, netmask, gateway);
    if (total_length >= buffer_size) {
        return -1;
    }
    cmd_buffer[total_length] = '\0';

    return 0;
}
            ]]>
        </content>
    </code>
</result>
```


