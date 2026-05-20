#include "doc_converter.h"

char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index) {
    if (doc_data == NULL || text_offset < 0 || char_index < 0 || text_offset + char_index >= doc_size) {
        return (char)0xff;
    }

    /* 
     * Direktang kalkulahin ang offset at basahin ang character.
     * Validation na nito nabe-validate kung ang text_offset + char_index ay lumampas sa doc_size,
     * at naka-validate kung ang offset o index ay negatibo.
     */
    return (char)doc_data[text_offset + char_index];
}