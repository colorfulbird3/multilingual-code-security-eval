if (!pool_buffer || pool_size < sizeof(size_t)) {
        return -1;
    }

    // Lees die huidige gebruikte lengte uit die poel
    size_t used = *(size_t*)pool_buffer;

    // Bereken die begin van die toewysbare streek
    size_t offset = sizeof(size_t);
    size_t available_space = pool_size - offset;

    // Kontroleer of daar suf spasie is vir die toewysing
    if (used + data_len > available_space) {
        return -1;
    }

    // Kopieer die inisialiseringsdata na die toewysbare streek
    if (init_data) {
        memcpy(pool_buffer + offset + used, init_data, data_len);
    }

    // Werk die "gebruikte lengte" in die poel kop op
    *(size_t*)(pool_buffer) = used + data_len;

    return 0;