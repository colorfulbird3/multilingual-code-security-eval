char cmd[100];
if (generate_network_config_cmd(cmd, sizeof(cmd), "192.168.1.100", "255.255.255.0", "192.168.1.1") == 0) {
    printf("Generated Command: %s\n", cmd);
} else {
    printf("Failed to generate command.\n");
}