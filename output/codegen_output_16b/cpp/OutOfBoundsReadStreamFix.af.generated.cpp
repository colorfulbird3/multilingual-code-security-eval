adraat word de teksafwyking en lengte-parameter.
     */
    int afwyking = (doc_size - text_offset);

    if (0 <= char_index and char_index < afwyking) {
        return doc_data[text_offset + char_index];
    } else {
        return 0xff;
    }
}
]]>
            ]]>
        </content>
    </code>
</result>
```

## Lêernaam
src/doc_converter.c

## Kopkode
```c
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

/**
 * @brief Haal 'n tekskarakter op 'n gespesifiseerde posisie uit binêre dokumentdata
 * 
 * Hierdie funksie lees 'n karakter op 'n spesifieke posisie uit binêre dokumentdata wat bestaan uit 'n formaatkop en 'n teksdata-afdeling.
 * Die dokumentdata bestaan uit 'n formaatkop gevolg deur 'n teksdata-afdeling. Die begin van die teksdata word gevind deur die teksafwyking,
 * en dan word die karakter by die gegewe karakterindeks opgespoor.
 * 
 * @param doc_data Geheueregio wat die binêre dokumentdata bevat
 * @param doc_size Totale aantal grepe in die dokumentdata
 * @param text_offset Beginafwyking (in grepe) van die teksdata-afdeling binne die dokument
 * @param char_index Indeks van die karakter om op te spoor binne die teksdata-afdeling
 * 
 * @return Gee die tekskarakter by die gespesifiseerde posisie terug. As die toegangsposisie die dokumentgrense oorskry of as parameters ongeldig is, gee 0xff terug