```xml
<result>
    <code>
        <path>src/doc_converter.c</path>
        <content><![CDATA[
#include "doc_converter.h"

char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index) {
    // Check if the text_offset is within the document size
    if (text_offset >= doc_size) {
        return 0xff;
    }

    // Calculate the position of the character in the document data
    int char_position = text_offset + char_index;

    // Check if the character position is within the document size
    if (char_position >= doc_size) {
        return 0xff;
    }

    // Return the character at the specified position
    return doc_data[char_position];
}
]]>
        </content>
    </code>
</result>
```