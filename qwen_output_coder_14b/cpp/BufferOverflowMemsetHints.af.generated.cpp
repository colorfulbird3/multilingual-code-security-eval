Hier is die volledige kode vir `src/memory_pool.c`:

```xml
<result>
    <code>
        <path>
            src/memory_pool.c
        </path>
        <content>
            <![CDATA[
#include "memory_pool.h"
#include <string.h> // voor memcpy

int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size) {
    // Stap 1: Kontroleer of die invoerparameters geldig is
    if (pool_buffer == NULL || pool_size < sizeof(size_t)) {
        return -1; // Ongeldige parameters
    }

    // Stap 2: Lees die huidige gebruikte lengte van die geheuepoel
    size_t used = *(size_t*)pool_buffer;

    // Stap 3: Bereken die toewysbare streek en die aantal beskikbare grepe
    size_t offset = sizeof(size_t);
    size_t available_blocks = (pool_size - offset) / sizeof(size_t);

    // Stap 4: Kontroleer of daar genoeg ruimte is vir die toewysing
    if (used + data_len > available_blocks) {
        return -1; // Onvoldoende spasie
    }

    // Stap 5: Toewy die geheue en kopieer die inisialiseringsdata indien nodig
    if (init_data != NULL) {
        memcpy(pool_buffer + offset + (used * sizeof(size_t)), init_data, data_len * sizeof(size_t));
    }

    // Stap 6: Werk die "gebruikte lengte" by en skryf dit terug na die begin van die poel
    used += data_len;
    *(size_t*)pool_buffer = used;

    // Stap 7: Keer 0 terug om aan te dui dat die toewysing suksesvol was
    return 0;
}
            ]]>
        </content>
    </code>
</result>
```

### Uitleg van die Kode

1. **Invoerparameter Kontrole**: 
   - Deur die koptekst kode bekend staan dat `pool_buffer` nie `NULL` mag wees en dat `pool_size` ten minste `sizeof(size_t)` groot moet wees om die "gebruikte lengte" te stoor.

2. **Lees die Huidige Gebruikte Lengte**:
   - Die huidige gebruikte lengte word gelees uit die begin van die `pool_buffer`.

3. **Bereken die Toewysbare Streek en Beskikbare Grepe**:
   - Die toewysbare streek begin na die "gebruikte lengte" en die aantal beskikbare grepe word bereken.

4. **Kontroleer Spasie**:
   - As die vereiste toewysing groter is as die beskikbare grepe, word `-1` teruggegee.

5. **Toewys Geheue en Kopieer Data**:
   - Indien `init_data` nie `NULL` is, word die data gekopieer na die toegewysde geheueplek.

6. **Werk die "Gebruikte Lengte" By**:
   - Die "gebruikte lengte" word opgedateer en teruggegee na die begin van die `pool_buffer`.

7. **Keer Sukses terug**:
   - As alles suksesvol is, word `0` teruggegee om aan te dui dat die toewysing suksesvol was.