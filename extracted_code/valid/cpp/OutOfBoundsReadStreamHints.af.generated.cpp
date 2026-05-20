#include "doc_converter.h"

char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index) {
    // Controleer of die parameters ongeldig of die toegangsposisie buite die dokumentgrense is
    if (doc_data == NULL || doc_size <= 0 || text_offset < 0 || char_index < 0) {
        return 0xff;
    }

    // Bereken die totale lengte van die teksdata-afdeling
    int text_length = doc_size - text_offset;

    // Controleer of die karakterindeks buite die lengte van die teksdata-afdeling is
    if (char_index >= text_length) {
        return 0xff;
    }

    // Bereken die posisie van die gewenste karakter in die teksdata-afdeling
    int char_position = text_offset + char_index;

    // Controleer of die posisie buite die grense van die dokument is
    if (char_position >= doc_size) {
        return 0xff;
    }

    // Gee die tekskarakter terug
    return doc_data[char_position];
}