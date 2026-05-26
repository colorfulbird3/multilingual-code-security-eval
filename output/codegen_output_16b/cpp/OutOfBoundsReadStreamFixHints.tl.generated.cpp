/to/file.c
        </path>
        <content>
            <![CDATA[
#include...

char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index) {
    //...
}
        ]]>
        </content>
    </code>
</result>
```
"""
from. import Result, _reserved

@Result.register(_reserved.get_doc_char_at)
def get_doc_char_at(doc_data, doc_size, text_offset, char_index):
    return doc_data[text_offset + char_index]
