#include "doc_converter.h"

char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index) {
    // Uqinisekisa ukuthi indawo yokufinyelela ikhomba edokhumentini
    if (text_offset + char_index >= doc_size || text_offset + char_index < 0) {
        return 0xff; // Ibuyisela u-0xff ukuba indawo yokufinyelela ingaphandle kwemingcele yedokhumenti
    }
    
    // Ibuyisela uhlamvu lombhalo endaweni ecacisiwe
    return doc_data[text_offset + char_index];
}