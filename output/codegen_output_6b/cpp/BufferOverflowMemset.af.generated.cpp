 0;
    }
}

void free_pool_memory(char* pool_buffer, size_t pool_size)
{
    // Misluk as pool_buffer NULL is of pool_size te klein is vir die gebruikte lengte-opsomming
    if (pool_buffer == NULL || pool_size < sizeof(size_t))
    {
        return;
    }

    // As pool_buffer is geheuze voor uitgevoegbare poel, moet uit
    *((size_t*)pool_buffer) = 0;
}

void print_pool_memory(char* pool_buffer, size_t pool_size, char* out_buffer, size_t out_buffer_size)
{
    // Misluk as pool_buffer NULL is of pool_size te klein is vir die gebruikte lengte-opsomming
    if (pool_buffer == NULL || pool_size < sizeof(size_t))
    {
        return;
    }

    // Lees die gebruikte lengte uit die poel-opsomming
    size_t used = *((size_t*)pool_buffer);

    // Beperk karaktersets en convert op de eenheid '\n' tot een karakter ('\0')
    const char* print_buffer = (const char*)pool_buffer;
    int remaining_size = out_buffer_size;
    for (size_t i = 0; i < used; i++)
    {
        if (print_buffer[i] == '\n')
        {
            if (remaining_size > 1)
            {
                out_buffer[0] = '\r';
                out_buffer[1] = '\n';
            }
            else
            {
                out_buffer[0] = '\n';
            }
            remaining_size--;
            print_buffer++;
        }
        else
        {
            out_buffer[0] = print_buffer[i];
            remaining_size--;
        }
    }
}

]]></pre></body></html>
"""

if