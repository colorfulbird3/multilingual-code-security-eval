char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index) {
    if (doc_data == NULL || doc_size <= 0 || text_offset < 0 || text_offset >= doc_size || char_index < 0) {
        return 0xff;
    }
    int current_offset = text_offset;
    int current_char_index = 0;
    while (current_offset < doc_size) {
        unsigned char current_byte = doc_data[current_offset];
        if (current_byte == 0x00) {
            break;
        }
        if (current_byte < 0x80) {
            if (current_char_index == char_index) {
                return (char)current_byte;
            }
            current_char_index++;
            current_offset++;
        } else if (current_byte < 0xC0) {
            return 0xff;
        } else if (current_byte < 0xE0) {
            if (current_offset + 1 >= doc_size) {
                return 0xff;
            }
            if (current_char_index == char_index) {
                return (char)(((current_byte & 0x1F) << 6) | (doc_data[current_offset + 1] & 0x3F));
            }
            current_char_index++;
            current_offset += 2;
        } else if (current_byte < 0xF0) {
            if (current_offset + 2 >= doc_size) {
                return 0xff;
            }
            if (current_char_index == char_index) {
                return (char)(((current_byte & 0x0F) << 12) | ((doc_data[current_offset + 1] & 0x3F) << 6) | (doc_data[current_offset + 2] & 0x3F));
            }
            current_char_index++;
            current_offset += 3;
        } else {
            return 0xff;
        }
    }
    return 0xff;
}