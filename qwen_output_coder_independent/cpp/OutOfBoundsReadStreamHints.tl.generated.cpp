```xml
<result>
    <code>
        <path>src/doc_converter.c</path>
        <content>
            <![CDATA[
#include "doc_converter.h"

char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index) {
    // Check if the document data pointer is NULL
    if (doc_data == NULL) {
        return 0xff;
    }

    // Calculate the position of the character in the document data
    int char_position = text_offset + char_index;

    // Check if the calculated position is within the bounds of the document data
    if (char_position >= 0 && char_position < doc_size) {
        return doc_data[char_position];
    } else {
        return 0xff;
    }
}
            ]]>
        </content>
    </code>
</result>
```