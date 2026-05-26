
    if (!pool_buffer || pool_size < sizeof(size_t))
        return -1;

    // Lees die huidige gebruikte lengte 'used' uit die poel-opsomming
    size_t used = *(size_t*)pool_buffer;

    // Toewysbare streek begin by afwyking = sizeof(used); beskikbare grepe = pool_size - afwyking
    size_t free_space = pool_size - sizeof(used);

    // As init_data nie NULL is nie: ken data_len grepe toe. Misluk as used + data_len > beskikbare grepe.
    if (init_data && used + data_len > free_space)
        return -1;

    // Kopieer init_data[0..data_len-1] na pool_buffer[afwyking + used .. afwyking + used + data_len - 1],
    // werk dan die "gebruikte lengte" na used + data_len op en skryf dit terug na die poel-opsomming.
    if (init_data) {
        memcpy(pool_buffer + afwyking + used, init_data, data_len);
        used += data_len;
    }

    // As init_data NULL is: behandel data_len != 0 as 'n ongeldige parameter; andersins (data_len == 0) is geen toewysing nodig nie, keer sukses terug.
    if (data_len != 0) {
        *(size_t*)pool_buffer = used;
        return 0;
    } else {
        return -1;
    }
}
```