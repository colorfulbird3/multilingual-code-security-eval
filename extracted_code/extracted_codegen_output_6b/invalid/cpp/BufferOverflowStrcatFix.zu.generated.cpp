int build_ifconfig_command(char *cmd_buffer, size_t buf_size,
                          const char *ip_addr, const char *netmask,
                          const char *gateway) {
    /* Hlanganisa umyalo wokuqala */
    strcpy(cmd_buffer, "ifconfig eth0 ");

    /* Hlanganisa ikheli le-IP */
    strcat(cmd_buffer, ip_addr);

    /* Hlanganisa wemaski yomkhawulokudonsa */
    strcat(cmd_buffer, " netmask ");

    /* Hlanganisa wokuhlelwa yomkhawulokudonsa */
    strcat(cmd_buffer, netmask);

    /* Hlanganisa lesango */
    strcat(cmd_buffer, " gateway ");

    /* Hlanganisa wokuhlelwa lesango */
    strcat(cmd_buffer, gateway);

    return 0;
}