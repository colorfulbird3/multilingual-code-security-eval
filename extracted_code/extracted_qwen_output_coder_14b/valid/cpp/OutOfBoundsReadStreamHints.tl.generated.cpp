#include "doc_converter.h"

char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index) {
    // Check if the parameters are valid
    if (doc_data == NULL || doc_size <= 0 || text_offset < 0 || char_index < 0) {
        return 0xff;
    }

    // Calculate the position of the character in the document
    int char_position = text_offset + char_index;

    // Check if the calculated position is within the bounds of the document
    if (char_position >= doc_size) {
        return 0xff;
    }

    // Return the character at the calculated position
    return doc_data[char_position];
}