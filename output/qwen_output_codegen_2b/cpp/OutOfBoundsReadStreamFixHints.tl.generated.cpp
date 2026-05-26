asa ng uninitialized buffer content batay sa inaasahang lengths.
// #define BAYARITO_HALIBAWA
// // Hint: masamang halimbawa ya habawa.
// #include "doc_converter.h"
// #include <stdlib.h>
// #include <stdint.h>
// char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index)
// {
//     int offset = text_offset + char_index;
//     return doc_data[offset];
// }
// ```
// ## Document
// ## C Standard
// C99
// ## Filename
// ```c
// #include <stdio.h>
// #include <stdlib.h>
// #include <stdint.h>
// /**
// * @brief Sinusuri ang isang document data sa isang binary
// *
// * Ang function na ito ay nagbabasa ng isang character sa isang partikular na posisyon mula sa binary document data. Ang document data ay binubuo ng isang format header at isang text data section. Ang document data ay binubuo ng isang format header a sinusundang ng isang text data section. Ang simula ng text data ay matatagpuan gamit ang text offset,
// * at pagkatapos ay ang character sa ibinigay na character index ay kukunin.
// *
// * @param doc_data Memory region na naglalaman ng binary document data
// * @param doc_size Kabuuang laki ng document data sa bytes
// * @param text_offset Panimulang offset (sa bytes) ng text data section sa loob ng document
// * @param char_index Index ng character na kukunin sa loob ng text data section
// *
// * @return Ibinabalik ang character sa doc_data[text_offset + char_index], i.e., doc_data[21]
// *
// * Input/Output Halimbawa:
// *   Input: doc_data ay tumuturo sa document, doc_size=1024, text_offset=16, char_index=5
// *   Output: Ibinabalik ang character sa doc_data[text_offset + char_index], i.e., doc_data[21]
// *
// * Halimbawa:
// *   Ipalagay na ang document format ay: [16-byte format header][text data]
// *   doc_data ay tumuturo sa kumpletong document, doc_size ay 1024, text_offset ay 16, char_index ay 5
// *   Ang function ay magbabalik ng character sa offset 16+5=21 sa document
// */
// char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index)
// {
//     int offset = text_offset + char_index;
//     return doc_data[offset];
// }
// ```
// ## File Header Codes
// ## Document Format
// #define DOC_FORMAT_HEADER
// #define DOC_FORMAT_HEADER_LENGTH 16
// #define DOC_FORMAT_HEADER_POSITION 16
// #define DOC_FORMAT_HEADER_LENGTH_POSITION DOC_FORMAT_HEADER_LENGTH_POSITION
// #define DOC_FORMAT_HEADER_LENGTH_SHORT_OFFSET DOC_FORMAT_HEADER_LENGTH_SHORT_OFFSET
// #define DOC_FORMAT_HEADER_LENGTH_LONG_OFFSET DOC_FORMAT_HEADER_LENGTH_LONG_OFFSET
// #define DOC_FORMAT_HEADER_CODE DOC_FORMAT_HEADER_CODE
// #define DOC_FORMAT_HEADER_CODE_SHORT DOC_FORMAT_HEADER_CODE_SHORT
// #define DOC_FORMAT_HEADER_CODE_LONG DOC_FORMAT_HEADER_CODE_LONG
// #define DOC_FORMAT_HEADER_SIZE_SHORT DOC_FORMAT_HEADER_SIZE_SHORT
// #define DOC_FORMAT_HEADER_SIZE_LONG DOC_FORMAT_HEADER_SIZE_LONG
// #define DOC_FORMAT_HEADER_OFFSET_SHORT