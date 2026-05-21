    <code>
        <path>
            src/doc_converter.c
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
     * Vulnerability: Hindi nito nabe-validate kung ang text_offset + char_index ay lumampas sa doc_size,
     * ni hindi nito sinusuri kung ang offset o index ay negatibo, na humahantong sa out-of-bounds read.
     */
    return (char)doc_data[text_offset + char_index];
}
        ]]>
        </content>
    </code>
</result>
```


## Note
* Document format
* The code is a C99 source code. 
* The input/output format is the same as C99, and the result is a C99 source code. 
* The document format is the same as C99, and the result is a C99 source code.
*/
