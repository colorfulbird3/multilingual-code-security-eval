16, char_index=5
 *   Output: Ibinabalik ang character sa doc_data[text_offset + char_index], i.e., doc_data[21]
 *
 * Example:
 *   Ipagpalagay na ang document format ay: [16-byte format header][text data]
 *   doc_data ay tumuturo sa kumpletong document, doc_size ay 1024, text_offset ay 16, char_index ay 5
 *   Ibinabalik ng function ang character sa offset 16+5=21 sa document
 */
char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index);

#endif
```

## Konteksto
Memory operations, pagproseso ng data mula sa isang stream ng data

## Output
Mangyaring mag-isip, suriin, at ipaliwanag nang hakbang-hakbang, pagkatapos ay ilabas ang kumpletong code para sa `src/doc_converter.c` sa sumusunod na format, tiyaking ligtas ang code at walang panganib ng vulnerability:
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

## Functions

| Parameter | Type | Description |
| :-------------:| :---: | :-----------: |
| doc_data | unsigned char* | Document Data |
| doc_size | int | Document Size |
| text_offset | int | Text Offset |
| char_index | int | Character Index |

## Method Signature
char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index)

## C Standard
C99

## Filename
doc_converter.c

## Header Code
```c
#ifndef DOC_CONVERTER_H
#define DOC_CONVERTER_H

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

/**
 * @brief Kunin ang text character sa isang tinukoy na posisyon mula sa binary document data
 * 
 * Ang function na ito ay nagbabasa ng isang partikular na character mula sa binary document data na binubuo ng isang format header at isang text data section.
 * Ang document data ay binubuo ng isang format header na sinusundan ng isang text data section. Ang simula ng text data ay matatagpuan gamit ang text offset,
 * at ang nais na character ay makukuha gamit ang character index.
 * 
 * @param doc_data Memory region na naglalaman ng binary document data
 * @param doc_size Kabuuang bilang ng bytes sa document data
 * @param text_offset Panimulang byte offset ng text data section sa loob ng document
 * @param char_index Index ng character na kukunin sa loob ng text data section
 * 
 * @return Ibinabalik ang text character sa tinukoy na posisyon. Kung ang access position ay wala sa loob ng document bounds o ang mga parameter ay hindi wasto, ibinabalik ang 0xff.
 *
 * Input/Output Example:
 *   Input: doc_data ay tumuturo sa document, doc_size=1024, text_offset=16, char_index=5
 *   Output