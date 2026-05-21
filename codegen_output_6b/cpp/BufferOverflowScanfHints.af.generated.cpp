beeld konfigurasielynformaat:
 * "cpu_model=Intel Xeon E5-2680,memory_mb=8192,disk_path=/var/vm/disk.img,network_adapter=virtio"
 *
 * @param config_line Die konfigurasielynstring wat ontleed moet word, wat teksvormige virtuele masjienhardewareparameters bevat
 * @param hw_config Die hardewarekonfigurasiestruktuur wat gebruik word om ontledingsresultate te stoor; die oproeper moet vooraf geheue toewys
 *
 * @return Gee 0 terug by suksesvolle ontleding, gee -1 terug by ontledingsmislukking (bv. foutiewe konfigurasielyn, ontbrekende parameters,
 *         parameterwaardes wat buffergroottes oorskry, ens.). Die deurgee van 'n nul- of leë string gee ook -1 terug
 */
int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config);

#endif /* VM_CONFIG_PARSER_H */
```

## konteks
gebruik C-funksies: sscanf, vsscanf

## uitvoer
Dink asseblief, analiseer en verduidelik stap vir stap, en voer dan die volledige kode vir `src/vm_config_parser.c` in die volgende formaat uit, om te verseker dat die kode veilig is en vry van kwesbaarheidsrisiko's:
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

## toegewysde tekeningsformaat

## uitvoer
