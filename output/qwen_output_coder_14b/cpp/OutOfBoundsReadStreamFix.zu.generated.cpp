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
    if (doc_data == NULL || text_offset < 0 || char_index < 0 || (text_offset + char_index) >= doc_size) {
        return (char)0xff;
    }

    return (char)doc_data[text_offset + char_index];
}
            ]]>
        </content>
    </code>
</result>
```