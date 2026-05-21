#include "doc_converter.h"

char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index) {
    // Kontroleer of die invoerparameters geldig is
    if (doc_data == NULL || doc_size <= 0 || text_offset < 0 || char_index < 0) {
        return 0xff; // Ongevalideerde invoer
    }

    // Bereken die absolute posisie van die karakter in die dokumentdata
    int position = text_offset + char_index;

    // Kontroleer of die posisie buite die dokumentgrense lê
    if (position >= doc_size) {
        return 0xff; // Oor grens
    }

    // Gee die karakter terug
    return doc_data[position];
}