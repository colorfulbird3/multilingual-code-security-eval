Hier is die volledige kode vir `src/network_config.c`, gebaseer op die beskrywing, metodehandtekening, koptekstkode, lêernaam en konteks:

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
    // Check if any of the input strings are empty
    if (!ip_addr || !netmask || !gateway || strlen(ip_addr) == 0 || strlen(netmask) == 0 || strlen(gateway) == 0) {
        return -1;
    }

    // Start constructing the command string
    char* pos = cmd_buffer;

    // Copy the base command part
    const char* base_command = "ip addr ";
    size_t len = strlen(base_command);
    if (len >= buffer_size) {
        return -1;
    }
    strcpy(pos, base_command);
    pos += len;

    // Append the IP address
    len = strlen(ip_addr);
    if (buffer_size - (pos - cmd_buffer) <= len) {
        return -1;
    }
    strcat(pos, ip_addr);
    pos += len;

    // Append the netmask
    const char* netmask_str = " netmask ";
    len = strlen(netmask_str);
    if (buffer_size - (pos - cmd_buffer) <= len) {
        return -1;
    }
    strcat(pos, netmask_str);
    pos += len;

    len = strlen(netmask);
    if (buffer_size - (pos - cmd_buffer) <= len) {
        return -1;
    }
    strcat(pos, netmask);
    pos += len;

    // Append the gateway
    const char* gateway_str = " gateway ";
    len = strlen(gateway_str);
    if (buffer_size - (pos - cmd_buffer) <= len) {
        return -1;
    }
    strcat(pos, gateway_str);
    pos += len;

    len = strlen(gateway);
    if (buffer_size - (pos - cmd_buffer) <= len) {
        return -1;
    }
    strcat(pos, gateway);
    pos += len;

    // Null-terminate the string
    *pos = '\0';

    return 0;
}
            ]]>
        </content>
    </code>
</result>
```

### Omskrywing van die Kode

1. **Invoerwaarde Kontrole**: 
   - Die funksie begin met die kontrole van die invoerstrings. Dit maak seker dat geen van die invoerstrings leeg is of `NULL`.

2. **Basis Kommando Bou**: 
   - Die basis kommando `"ip addr "` word gekopieer na die `cmd_buffer`.

3. **IP Adres Voeg**: 
   - Die IP adres word aan die kommando toegevoeg.

4. **Subnetmasker Voeg**: 
   - Die subnetmasker word aan die kommando toegevoeg na die IP adres.

5. **Gateway Voeg**: 
   - Die gateway word aan die kommando toegevoeg na die subnetmasker.

6. **Null-Teikens Einde**: 
   - Die kommando-string word null-geëindig om ervoor te sorg dat dit 'n geldige C-teks is.

7. **Fout Afhandeling**: 
   - Die funksie retourneer `-1` indien er sprake is van onvoldoende ruimte in die buffer of indien enige invoerstring leeg is. Anderwise retourneer dit `0` om aan te dui dat die kommando suksesvol is gegenereer.

Hierdie implementering maak gebruik van `strcat` en `strcpy` om die kommando-string opgebou te maak. Dit maak ook rekening met die grootte van die buffer om ervoor te sorg dat daar genoeg ruimte is om die kommando te stoor.