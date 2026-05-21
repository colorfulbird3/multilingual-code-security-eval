te, verhindering ekstra tekst na hoeveelheid tekens.
     * Alleen 'n eenvoudige 'C' string, met geen spaties, kan nie word.
     */
    int items = parse_helper(config_line, "%127[^,]%[^,],%255[^,]%[^,],%255[^,]%[^,],%255[^,]%[^,],%255[^,]%[^,],%255[^,]%[^,],%255[^,]%[^,],%255[^,]%[^,],%255[^,]%[^,],%255[^,]%[^,]",
        hw_config->cpu_model, hw_config->memory_mb, hw_config->disk_path, hw_config->network_adapter);
    if (items!= 15) {
        return -1;
    }

    return 0;
}
```

## ontleed
Gee 0 terug by suksesvolle ontleding, -1 by mislukking (bv. wanvormige konfigurasielyn, ontbrekende parameters,
parameterwaardes wat buffergroottes oorskry, ens.). Die deurgee van 'n leë string gee ook -1 terug.

## kontrole
## gebruik: make check
