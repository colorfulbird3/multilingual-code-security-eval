Hier is die volledige kode voor `src/network_config.c`:

```xml
<result>
    <code>
        <path>src/network_config.c</path>
        <content><![CDATA[
#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    // Check if any input string parameter is empty
    if (ip_addr == NULL || netmask == NULL || gateway == NULL ||
        ip_addr[0] == '\0' || netmask[0] == '\0' || gateway[0] == '\0') {
        return -1;
    }

    // Construct the network configuration command string
    int result = snprintf(cmd_buffer, buffer_size, "ip addr %s netmask %s gateway %s", ip_addr, netmask, gateway);
    
    // Check if the snprintf call was successful
    if (result < 0) {
        return -1;
    }

    // Ensure the command string fits within the buffer
    if ((size_t)result >= buffer_size) {
        return -1;
    }

    return 0;
}
]]>
        </content>
    </code>
</result>
```

### Verduideliking van die kode:

1. **Kontrole van lege invoer**: Die kode begin met 'n kontrole om te verifieer of enige van die invoerparameters (`ip_addr`, `netmask`, `gateway`) `NULL` of leeg is. Dit word gedaan deur te konsolider om elke parameter of sy eerste karakter `\0` is.

2. **Konstruksie van die opdragstreng**: Die `snprintf`-funksie word gebruik om die netwerkconfiguratie-opdragstreng te bou. Hierdie funksie word gekoos omdat dit 'n veilige manier is om strengen te formateer en te kopieer, wat 'n potensiële buffer-overvlakkingsaanval vermy.

3. **Gee 'n foutindikator terug**: Die `snprintf`-funksie gee 'n negatiewe waarde terug indien er 'n fout voorkomt. In hierdie geval word `-1` geretourneer.

4. **Kontrole van die buffer-grootte**: