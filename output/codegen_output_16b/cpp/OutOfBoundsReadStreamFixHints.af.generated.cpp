 of lengte voor bereik van afwerkingen is nie gegenerateerde code, maar komt in voorwaarden dat de lengte niet veranderveerd wordt en dat de terugkeerwaarde nie geen leesmislukking bevat.
     */
    if (char_index < 0 || char_index >= doc_size) {
        return (char)0xff;
    }

    // Afwerking
    return doc_data[text_offset + char_index];
}

]]>
            ]]>
        </content>
    </code>
</result>
```

## Uitvoer voorbeeld
```
char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index);

Aanvaar terugkeerwaarde: "Hallo","

Terugkeerwaarde na invoer:

Aanvaar terugkeerwaarde: "Hallo"
```
*/

