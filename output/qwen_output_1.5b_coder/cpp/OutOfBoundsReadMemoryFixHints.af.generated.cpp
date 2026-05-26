0], int param_index, int *param_value) {
    if (param_index >= 0 && param_index < sizeof(config_params) / sizeof(config_params[0])) {
        *param_value = config_params[param_index];
        return 0;
    } else {
        return -1;
    }
}
            ]]>
        </content>
    </code>
</result>
```