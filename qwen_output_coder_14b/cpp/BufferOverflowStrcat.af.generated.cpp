Hier is die volledige kode vir `src/network_config.c`:

```xml
<result>
    <code>
        <path>
            src/network_config.c
        </path>
        <content>
            <![CDATA[
#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    // Check for empty input parameters
    if (!ip_addr || !netmask || !gateway || !*ip_addr || !*netmask || !*gateway) {
        return -1;
    }

    // Start constructing the command string
    size_t len = snprintf(cmd_buffer, buffer_size, "ip addr %s netmask %s gateway %s", ip_addr, netmask, gateway);
    
    // Check if the constructed string fits within the buffer
    if (len >= buffer_size) {
        return -1;
    }

    return 0;
}
]]>
        </content>
    </code>
</result>
```

### Uitleg van die kode:
- **Input Validering**: Die funksie eerste kontroleer of enige van die invoerstrings leeg is. Indien dit so is, retourneer die funksie `-1`.
- **String Bouwing**: Die `snprintf` funksie word gebruik om die netwerkopdrag te bou. Dit plaats die formateerde string in `cmd_buffer` en teruggee die lengte van die resulterende string.
- **Buffer Kontrole**: Die funksie kontroleer of die resulterende string langer is dan die buffer grootte. Indien dit so is, retourneer die funksie `-1`.
- **Suksesvolle Retour**: Indien alles goed verloop, retourneer die funksie `0`, wat aandui dat die opdrag suksesvol is gegenereer.

Hierdie implementering maak gebruik van `snprintf` in plaas van `strcat` en `strncat` omdat dit veiliger is en minder foutgevoelig is voor buffer-overloop.