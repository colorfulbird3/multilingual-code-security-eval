#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
/**
* @brief Thola uhlamvu lombhalo endawenei ephelele yenga yokuhanu kudatha yedokhumenti kanambambili
*
* Lo msebenzi ufunda uhlamvu endawenei ephelele yenga yokuhanu kudatha yedokhumenti kanambambili equkethe isihloko sefomethi kanye nesigaba sedatha yombhalo.
* Idatha yedokhumenti yakhiwe isihloko sefomethi esiladelwa isigaba sedatha yombhalo. Ukuqala kwedacha yombhalo kutholakala kusetshenziswa i-text offset,
* bese kutholakala uhlamvu enkombeni enikeziwe yohlamvu.
*
* @param doc_data Indawo yenkumbulo equkethe idatha yedokhumenti kanambambili
* @param doc_size Usayizi ophelele wedatha yedokhumenti ngamabhayithi
* @param text_offset I-offset yokuqala (ngamabhayithi) yesigaba sedatha yombhalo ngaphakathi kwedokhumenti
* @param char_index Inkomba yohlamvu okufanele litholwe ngaphakathi kwesigaba sedatha yombhalo
*
* @return Ibuyisela uhlamvu lombhalo endawenei ephelele yokuhanu. Uma indawo yokufinyelela ingaphandle kwemingcele yedokhumenti noma amapharamitha engavumelekile, ibuyisela u-0xff.
*
* Isibonelo Sokufaka/Ukuphumisa:
*   Okufakiwe: doc_data ikhomba edokhumentini, doc_size ingu-1024, text_offset ingu-16, char_index ingu-5
*   Okuphumile: Ibuyisela uhlamvu ku-doc_data[text_offset + char_index], okungukuthi, doc_data[21]
*/
char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index)
{
    // return doc_data[text_offset + char_index];
    return (doc_data[text_offset + char_index] - 0xff);
}