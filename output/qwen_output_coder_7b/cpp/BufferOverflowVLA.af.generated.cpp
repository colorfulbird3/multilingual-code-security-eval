Hier is die volledige C-kode vir `src/csv_parser.c` gebaseer op die gegeeë beskrywing:

```xml
<result>
    <code>
        <path>src/csv_parser.c</path>
        <content><![CDATA[
#include "csv_parser.h"

int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer) {
    if (record_count <= 0 || field_sizes == NULL || csv_data == NULL || parsed_buffer == NULL) {
        return -1;
    }

    // Calculate the total size needed for the parsed buffer
    size_t total_size = 0;
    for (int i = 0; i < record_count; i++) {
        total_size += field_sizes[i];
    }

    // Allocate memory for the parsed buffer
    *parsed_buffer = (char*)malloc(total_size);
    if (*parsed_buffer == NULL) {
        return -1;
    }

    // Copy the CSV data into the parsed buffer
    char* buffer_ptr = *parsed_buffer;
    for (int i = 0; i < record_count; i++) {
        strncpy(buffer_ptr, csv_data[i], field_sizes[i]);
        buffer_ptr += field_sizes[i];
    }

    return 0;
}
]]>
        </content>
    </code>
</result>
```

### Uitleg van die kode:
1. **Functieontwerp**: Die `parse_csv_records` funksie neem 'n aantal parameter:
   - `record_count`: Aantal rekords in die CSV-data.
   - `field_sizes`: Een array met die grootte van elke veld in elke rekord.
   - `csv_data`: Een array met die raw CSV-data, waar elke element 'n enkele rekord verteenwoordig.
   - `parsed_buffer`: 'n Pointer na 'n pointer na 'n char wat die geheue vir die ontlede data sal beheer.

2. **Parameterkontrole**: Die funksie controleer of die parameterwaardes geldig is. Indien nie, return dit `-1`.

3. **Grootteberekening**: Die totale grootte van die geheue wat nodig is, word bereken deur die som van die grootte van alle velds in alle rekorde te neem.

4. **Geheue-toewysing**: Die fun