 doc_data, int doc_size, int text_offset, int char_index)
// {
//     char ret = 0;
//     char* p = doc_data + text_offset;
//     char* q = p + char_index;
//     for (; p!= q; ++p, ++q) {
//         ret *= 16;
//         if (*p >= 10)
//             ret += *p - 10 + 1;
//         else
//             ret += *p;
//     }
//     return ret;
// }
// #endif
// ```
// ## i-filename
// doc_converter.c
// ## i-header_code
// ```c
// #include <stdio.h>
// #include <stdlib.h>
// #include <stdint.h>
//
// /**
// * Thola uhlamvu lombhalo endaweni ecacisiwe kusukela kudatha yedokhumenti kanambambili
// *
// * Lo msebenzi ufunda uhlamvu oluthile kusukela kudatha yedokhumenti kanambambili equkethe isihloko sefomethi kanye nesigaba sedatha yombhalo.
// * Idatha yedokhumenti yakhiwe isihloko sefomethi silandelwa isigaba sedatha yombhalo. Ukuqala kwedacha yombhalo kutholakala kusetshenziswa i-text offset,
// * futhi uhlamvu olufunwayo lutholakala kusetshenziswa i-character index.
// *
// * @param doc_data Indawo yememori equkethe idatha yedokhumenti kanambambili
// * @param doc_size Inani eliphelele lama-byte kudatha yedokhumenti
// * @param text_offset I-byte offset yokuqala yesigaba sedatha yombhalo ngaphakathi kwedokhumenti
// * @param char_index Inkomba yohlamvu okufanele litholwe ngaphakathi kwesigaba sedatha yombhalo
// *
// * @return Ibuyisela uhlamvu lombhalo endaweni ecacisiwe. Uma indawo yokufinyelela idlula imingcele yedokhumenti noma amapharamitha engekho emthethweni, ibuyisela u-0xff.
// *
// * Isibonelo sokufaka/ukuphuma:
// *   Okufakiwe: i-doc_data ikhomba edokhumentini, i-doc_size=1024, i-text_offset=16, i-char_index=5
// *   Okuphumayo: Ibuyisela uhlamvu ku-doc_data[text_offset + char_index], okungukuthi, i-doc_data[21]
// *
// * Isibonelo:
// *   Cabanga ukuthi ifomethi yedokhumenti ithi: [isihloko sefomethi esingama-byte angu-16][idatha yombhalo]
// *   i-doc_data ikhomba edokhumentini ephelele, i-doc_size ingu-1024, i-text_offset ingu-16, i-char_index ingu-5
// *   Umsebenzi uzobuyisela uhlamvu ku-offset engu-16+5=21 edokhumentini
// */
// char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index)
// {
//     char ret = 0;
//     char* p = doc_data + text_offset;
//     char* q = p + char_index;
//     for (; p!= q; ++p, ++q) {
//         ret *= 16;
//         if (*p >= 10)
//             ret += *p - 10 + 1;
//         else
//             ret += *p;
//     }
//     return ret;
// }
// ```
// ## i-filename
// doc_converter.c
