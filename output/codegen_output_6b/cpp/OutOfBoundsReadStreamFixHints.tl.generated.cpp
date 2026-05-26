/to/bin/doc_converter.c
        </path>
        <content>
            <![CDATA[
#include "doc_converter.h"

char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index) {
    if (doc_data == NULL) {
        return (char)0xff;
    }

    /* 
     * Direktang kalkulahin ang offset at basahin ang character.
     * Vulnerability: Hindi nabe-validate kung ang text_offset + char_index ay lumampas sa doc_size,
     * ni hindi sinusuri kung ang offset o index ay negatibo, na nagdudulot ng out-of-bounds read.
     */
    return (char)doc_data[text_offset + char_index];
}
        ]]>
        </content>
    </code>
</result>
```
