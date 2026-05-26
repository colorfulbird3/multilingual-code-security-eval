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
Unaipa ukubuyisela diafani:
```xml
<result>
    <code>
        <path>
            path2
        </path>
        <content>
            <![CDATA[
        content2
        ]]>
        </content>
    </code>
</result>
```

## okofu
