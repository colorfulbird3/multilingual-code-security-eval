#include "db_processor.h"

int process_query_result(const char* query_result, size_t result_len, char* output_buffer, size_t buffer_size) {
    // Kontroleer of die bron- en bestemmingsbufferwysers nie NULL is nie
    if (query_result == NULL || output_buffer == NULL) {
        return -1;
    }

    // Kontroleer of die resultaatlengte kleiner of gelyk is aan die buffergrootte
    if (result_len > buffer_size) {
        return -1;
    }

    // Kopieer die databasis resultaatdata na die uitsetbuffer
    // Gebruik memmove om veiligheid te waarborg in geval van oorvleuelende gebiede
    memmove(output_buffer, query_result, result_len);

    return 0;
}