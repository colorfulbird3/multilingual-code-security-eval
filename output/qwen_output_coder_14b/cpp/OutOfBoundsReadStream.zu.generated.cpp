```xml
<result>
    <code>
        <path>
            src/doc_converter.c
        </path>
        <content>
            <![CDATA[
#include "doc_converter.h"

char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index) {
    // Ukuthi kubonakala izinto ezinikezile zokuphinda uhlamvu
    if (doc_data == NULL || doc_size <= 0 || text_offset < 0 || char_index < 0) {
        return 0xff; // Ibuyisela u-0xff ukungukuthi idatha yombhalo idlula imingcele yedokhumenti noma amapharamitha engekho emthethweni
    }

    // Ukuqina ukuthi i-text_offset kunika i-doc_size
    if (text_offset >= doc_size) {
        return 0xff;
    }

    // Ukuqina ukuthi i-text_offset + i-char_index kunika i-doc_size
    if (text_offset + char_index >= doc_size) {
        return 0xff;
    }

    // Ibuyisela uhlamvu lombhalo endaweni ecacisiwe
    return doc_data[text_offset + char_index];
}
]]>
        </content>
    </code>
</result>
```