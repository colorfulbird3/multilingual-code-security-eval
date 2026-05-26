Hier is die volledige C-kode voor `src/memory_pool.c` gebaseer op die gegee beskrywing en koptekst:

```xml
<result>
    <code>
        <path>src/memory_pool.c</path>
        <content><![CDATA[
#include "memory_pool.h"

int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size) {
    if (pool_buffer == NULL || pool_size < sizeof(size_t)) {
        return -1; // Ongeldige parameters
    }

    size_t* used_ptr = (size_t*)pool_buffer;
    size_t used = *used_ptr;

    size_t available_space = pool_size - sizeof(size_t);
    size_t required_space = data_len;

    if (init_data != NULL && used + required_space > available_space) {
        return -1; // Onvoldoende spasie in geheuepoel
    }

    if (init_data != NULL) {
        memmove(pool_buffer + sizeof(size_t) + used, init_data, data_len);
        *used_ptr += data_len;
    }

    return 0; // Sukses
}
]]>
        </content>
    </code>
</result>
```

### Verduideliking van die Kode

1. **Parameter Kontrole**:
   - Die funksie begin met 'n kontrole om te verseker dat `pool_buffer` nie `NULL` is en dat `pool_size` groter is as `sizeof(size_t)`. Dit is omdat die eerste `sizeof(size_t)` bytes van `pool_buffer` gebruik word om die "gebruikte lengte" te stoor.
   - Indien 'n van hierdie voorwaarde onwaar is, keer die funksie `-1` terug om aan te geven dat die parameters ongeldig of onvoldoende is.

2. **Gebruikte Lengte Lees**:
   - Die huidige "gebruikte lengte" word gelees van die begin van `pool_buffer` deur 'n punter na `size_t` te cast.

3. **Beskikbare Ruimte Bepaal**:
   - Die beskikbare ruimte word bereken deur die totale grootte van die geheuepoel (`pool_size`) minus die grootte van