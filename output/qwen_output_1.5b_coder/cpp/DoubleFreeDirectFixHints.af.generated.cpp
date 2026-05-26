 ctx->temp_buffer en ctx->buffer_size.
 *    - Lees de kopstuk en ga door de kompresie-proces.
 *
 * 2. Data-Dekompressie
 *    - Lees die loonvrag en ga door de kompresie-proces.
 *
 * 3. Integriteitsverifikasie
 *    - Lees die kontrolesom en vergelijke die waarde met de berekenende waarde van die gedekomprimeerde data of loonvrag.
 *    - Als het niet overeenkomt, keer terug met mislukking.
 *
 * [Kopstuk-ontleding]
 *
 *   +---------+--------+-------------+-----------+---------------+-------------------+
 *   | Magies | Tipe   | Offset       | Length    | Data          | Kontrolesom         |
 *   +---------+--------+-------------+-----------+---------------+-------------------+
 *   | (2B)   | (1B)   | (2B)        | (2B)      | (Length bytes) | (1B)             |
 *   +---------+--------+-------------+-----------+---------------+-------------------+
 *
 *   - Magies: Vaste 2 grepe wat gebruik word om die CMP-stroom te identifiseer (bv. 0x43 0x4D).
 *   - Tipe: 1 greep wat die kompressie-algoritme tipe aandui. 0 = rou/ongekomprimeer, 1 = RLE, ander gereserveer.
 *   - Offset: 2 greep wat die afstand tot de geheuele data positie in de lêer word geeft.
 *   - Length: 2 greep wat die lengte van die kopstuk dat in die afstand word gevind, word geeft.
 *   - Data: De geheuele data wat in die afstand word gevind.
 *   - Kontrolesom: Laaste 1 greep, wat 'n eenvoudige kontrolesom (bv. lae 8 bisse van som) van die geheuele data of kopstuk kan wees, soos gedefinieer deur die implementering.
 */

#endif /* COMPRESSION_TOOL_H */
```

## context
Een lêer met name 'n CSV-bestand, waarin gegevens over stadiek en sport is gespriet. Hier is die voorbeeld van die CSV-lêer:

| stadiek | sporttype | datum      | aantal_kampioenen |
|---------|------------|--------------|------------------|
| Amsterdam| Football   | 2023-05-10 | 10               |
| Berlin  | Basketball | 2023-05-15 | 5                |
| Amsterdam| Volleyball | 2023-05-20 | 7                |

## problem
Die CSV-lêer is korrekt ingepakkeerd en de data is goed gespieet. Daarom wordt er geen probleem aangetrekken met de CSV-lêer.

## solution
Maak gebruik van die `decompress_file` funksie om die CSV-lêer te dekompresie. Voeg die kompressorie-proces toe aan de `decompress_file` funksie en maak gebruik van die `struct compression_context` om die dekompressie-oplossing op te slaan.

## code snippet
```c
#include "compression_tool.h"

int decompress_file(const unsigned char *compressed_data, size_t data_size, struct compression_context *ctx) {
    // Implementeer hier de dekompression-proces
    // Gebruik ctx->temp_buffer en ctx->buffer_size om die dekompressie-oplossing op te slaan
}
```

## test cases
- Test de `decompress_file` funksie met die voorbeeld CSV-lêer en controleer of die functie de CSV-lêer goed dekompresseer.
- Controleer of die `struct compression_context` correct werkt en dat die de kompressie-oplossing opgeslaan is.
- Controleer of die dekompression-proces werkt en dat die CSV-lêer goed dekompresseer.