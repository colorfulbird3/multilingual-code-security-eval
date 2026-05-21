#include "doc_converter.h"

char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index) {
    if (doc_data == NULL || doc_size <= 0 || text_offset < 0 || char_index < 0) {
        return (char)0xff;
    }

    int calculated_offset = text_offset + char_index;

    if (calculated_offset >= doc_size) {
        return (char)0xff;
    }

    return (char)doc_data[calculated_offset];
}