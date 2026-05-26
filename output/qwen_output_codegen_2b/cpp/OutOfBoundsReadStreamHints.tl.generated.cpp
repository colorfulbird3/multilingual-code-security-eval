aking ligtas ang code at walang panganib ng vulnerability:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## C Standard
// C99

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index){
    int i;
    for(i=0; i<sizeof(char)*2; i++){
        if(i!= char_index){
            if(doc_data[text_offset + i]!= 0x00){
                return doc_data[text_offset + i];
            }
        }
    }
    return 0xFF;
}
