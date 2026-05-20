#include "doc_converter.h"

char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index) {
    if (doc_data == NULL || doc_size <= 0 || text_offset < 0 || char_index < 0) {
        return 0xff;
    }

    int text_start = text_offset;
    if (text_start + char_index >= doc_size) {
        return 0xff;
    }

    return doc_data[text_start + char_index];
}