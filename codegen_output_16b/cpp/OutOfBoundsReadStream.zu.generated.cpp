char_index=5
 *   Okuphumayo: Ibuyisela uhlamvu ku-doc_data[text_offset + char_index], okungukuthi, i-doc_data[21]
 *
 * Isibonelo:
 *   Cabanga ukuthi ifomethi yedokhumenti ithi: [isihloko sefomethi esingama-byte angu-16][idatha yombhalo]
 *   i-doc_data ikhomba edokhumentini ephelele, i-doc_size ingu-1024, i-text_offset ingu-16, i-char_index ingu-5
 *   Umsebenzi uzobuyisela uhlamvu ku-offset engu-16+5=21 edokhumentini
 */
char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index);

#endif
```

## umongo
Imisebenzi yememori, ukucubungula idatha evela kumjikelezo wedatha

## okuphumayo
Phuma ikhodi ephelele ye-`src/doc_converter.c` ngefomethi elandelayo:
```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```


## isiguquli
Imisebenzi yememori, ukucubungula idatha evela kumjikelezo wedatha

## incazelo
Isiguquli sefomethi yedokhumenti sifunda okuqukethwe kombhalo kusukela kudatha yedokhumenti kanambambili. Ifomethi yedokhumenti iqukethe isihloko sefomethi kanye nesigaba sedatha yombhalo. Abasebenzisi bangalayisha amafayela edokhumenti, futhi umsebenzi udinga ukubuyisela uhlamvu lombhalo oluhambisanayo ngokusekelwe kumapharamitha e-text offset nobude.

## i-method_signature
char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index)

## i-c standard
C99

## i-filename
doc_converter.c

## i-header_code
```c
#ifndef DOC_CONVERTER_H
#define DOC_CONVERTER_H

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

/**
 * @brief Thola uhlamvu lombhalo endaweni ecacisiwe kusukela kudatha yedokhumenti kanambambili
 * 
 * Lo msebenzi ufunda uhlamvu oluthile kusukela kudatha yedokhumenti kanambambili equkethe isihloko sefomethi kanye nesigaba sedatha yombhalo.
 * Idatha yedokhumenti yakhiwe isihloko sefomethi silandelwa isigaba sedatha yombhalo. Ukuqala kwedatha yombhalo kutholakala kusetshenziswa i-text offset,
 * futhi uhlamvu olufunwayo lutholakala kusetshenziswa i-character index.
