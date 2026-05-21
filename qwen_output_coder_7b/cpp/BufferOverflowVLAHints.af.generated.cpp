Hier is die volledige kode voor `src/csv_parser.c`:

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

    // Bereken die totale lengte van die ontlede data
    size_t total_length = 0;
    for (int i = 0; i < record_count; i++) {
        total_length += strlen(csv_data[i]) + 1; // +1 vir die null-terminator
    }

    // Toewys geheue vir die ontledingsbuffer
    *parsed_buffer = (char*)malloc(total_length);
    if (*parsed_buffer == NULL) {
        return -1;
    }

    // Kopieer die CSV-data na die ontledingsbuffer
    char* buffer_ptr = *parsed_buffer;
    for (int i = 0; i < record_count; i++) {
        strcpy(buffer_ptr, csv_data[i]);
        buffer_ptr += strlen(csv_data[i]) + 1;
    }

    return 0;
}
]]>
        </content>
    </code>
</result>
```

### Verklaring van die kode:

1. **Funksieontwerp**: Die `parse_csv_records` funksie ontleed CSV-data van 'n CSV-lêer en ken geheue toe om die ontlede data te stoor. Dit bereken outomaties die vereiste geheuegrootte en ken 'n toepaslike buffer toe om die ontlede data te stoor.

2. **Parameterkontrole**: Die funksie kontroleer of die invoerparameters geldig is. Indien enige parameter ongeldig is, retourneer dit `-1`.

3. **Geheueberekening**: Die totale lengte van die ontlede data word bereken deur die lengte van elke CSV-rekord te sommeer en 'n extra karakter vir die null-terminator toe te voeg.

4. **Geheue-toewysing**: Geheue word toewys vir die ontledingsbuffer met behulp