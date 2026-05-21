#include "memory_pool.h"
#include <string.h>

int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size)
{
    // Misluk as pool_buffer NULL is of pool_size te klein is vir die gebruikte lengte-opsomming
    if (pool_buffer == NULL || pool_size < sizeof(size_t))
    {
        return -1;
    }

    // Lees die huidige gebruikte lengte uit die poel-opsomming
    size_t used = *((size_t*)pool_buffer);

    // Bereken die afwyking na die toewysbare streek
    size_t offset = sizeof(size_t);
    size_t available = pool_size - offset;

    // As init_data nie NULL is nie
    if (init_data != NULL)
    {
        // Misluk as die gevraagde lengte die beskikbare spasie oorskry
        if (used + data_len > available)
        {
            return -1;
        }

        // Kopieer die inisialiseringsdata na die toewysbare streek
        memcpy(pool_buffer + offset + used, init_data, data_len);

        // Werk die gebruikte lengte op
        used += data_len;
        *((size_t*)pool_buffer) = used;

        return 0;
    }
    else
    {
        // As init_data NULL is, moet data_len 0 wees vir sukses
        if (data_len != 0)
        {
            return -1;
        }

        // Geen toewysing nodig nie, keer sukses terug
        return 0;
    }
}