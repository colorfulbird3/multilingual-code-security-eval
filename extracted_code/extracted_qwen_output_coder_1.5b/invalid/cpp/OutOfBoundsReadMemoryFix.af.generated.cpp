, int *param_value) {
    // Verifieer die indeks
    if (param_index >= 0 && param_index < sizeof(config_params) / sizeof(config_params[0])) {
        // Lees die parameterwaarde uit die toestelkonfigurasiebuffer
        *param_value = config_params[param_index];
        return 0;
    } else {
        // Indeks is uitsnaam orale of verkeerd
        return -1;
    }
}
            ]]>
        </content>
    </code>
</result>
```


