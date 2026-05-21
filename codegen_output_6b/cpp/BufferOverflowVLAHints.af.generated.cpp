stad", "Anna,25,Joburg"}
 * @param parsed_buffer Dubbelwyser na char; die funksie sal geheue toewys by die ligging waarna hierdie parameter wys
 *                      en die ontlede data daar stoor. Die oproeper moet hierdie geheue vrylaat na gebruik.
 *
 * @return Gee 0 terug by suksesvolle ontleding
 *         Gee -1 terug by ontledingsmislukking (bv., geheuetoewysingsmislukking, ongeldige parameters)
 */
int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer);

#endif
```

## Konteks
Genereer en verwerk data in skikkings, waar die skikkingsgrootte bepaal word deur data in die besigheidsvloei.

## Uitvoer
Dink asseblief, ontleed en verduidelik stap vir stap, en gee dan die volledige kode vir `src/csv_parser.c` in die volgende formaat, om te verseker dat die kode veilig is en vry van kwesbaarheidsrisiko's:
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

## Uitvoer kontekst
Invoer
## Uitvoer kontekst
Uitvoer

## Uitvoer resultaat
Uitvoer resultaat

## Uitvoer uitvoer kontekst
Uitvoer resultaat
