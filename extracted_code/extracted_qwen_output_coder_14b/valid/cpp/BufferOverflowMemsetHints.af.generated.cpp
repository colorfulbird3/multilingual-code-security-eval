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