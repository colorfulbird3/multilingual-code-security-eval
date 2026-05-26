Hier is die volledige kode vir `src/csv_parser.c`:

```xml
<result>
    <code>
        <path>
            src/csv_parser.c
        </path>
        <content>
            <![CDATA[
#include "csv_parser.h"

int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer) {
    if (record_count <= 0 || field_sizes == NULL || csv_data == NULL || parsed_buffer == NULL) {
        return -1; // Invalid parameters
    }

    // Calculate the total size needed for the parsed buffer
    int total_size = 0;
    for (int i = 0; i < record_count; i++) {
        total_size += field_sizes[i];
    }

    // Allocate memory for the parsed buffer
    *parsed_buffer = (char*)malloc(total_size);
    if (*parsed_buffer == NULL) {
        return -1; // Memory allocation failed
    }

    // Copy data from csv_data to parsed_buffer based on field sizes
    char* current_position = *parsed_buffer;
    for (int i = 0; i < record_count; i++) {
        strncpy(current_position, csv_data[i], field_sizes[i]);
        current_position += field_sizes[i];
    }

    return 0; // Success
}
]]>
        </content>
    </code>
</result>
```

### Omskrywing van die Kode:

1. **Parameter Kontrole**: 
   - Die funksie begin met die kontrole van die invoerparameter. Indien enige van die parameters ongeldig is (soos `record_count` kleiner of gelyk aan nul, `field_sizes`, `csv_data`, of `parsed_buffer` is `NULL`), retourneer die funksie `-1` om 'n fout te duid.

2. **Berekening van Totale Grootte**:
   - Die totale grootte van die ontledingsbuffer word bereken deur die grootte van elke veld in die rekords optelling.

3. **Geheuetoewys**:
   - Geheu word toegewys vir die ontledingsbuffer gebruikmakend van `malloc`. Indien die toewys misluk, retourneer die funksie `-1`.

4. **Ontleding van Data**:
   - Die data word van `csv_data` gekopieër na `parsed_buffer` gebruikmakend van `strncpy` om te verseker dat die veldgroottes respecteer word.

5. **Suksesvolle Retourneering**:
   - As alles suksesvol is, retourneer die funksie `0`.

Hierdie kode bied 'n basiese implementering van die vereiste funksionaliteit om CSV-gegevens te ontledig en om die ontledingsbuffer te stoor.