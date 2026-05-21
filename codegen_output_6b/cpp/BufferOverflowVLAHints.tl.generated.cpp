 CSV data, kung saan ang bawat elemento ay kumakatawan sa isang CSV record
 *                 hal., {"name,age,city", "John,30,NYC", "Alice,25,LA"}
 * @param parsed_buffer Double pointer sa char; ang function ay mag-a-allocate ng memory sa lokasyong tinutukoy ng parameter na ito
 *                      at iimbak ang parsed data doon. Dapat i-free ng tumatawag ang memory na ito pagkatapos gamitin.
 *
 * @return Nagbabalik ng 0 kung matagumpay ang pag-parse
 *         Nagbabalik ng -1 kung nabigo ang pag-parse (hal., pagkabigo sa memory allocation, invalid parameters)
 */
int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer);

#endif
```

## Konteksto
Gumawa at mag-proseso ng data sa arrays, kung saan ang laki ng array ay natutukoy ng data sa business workflow.

## Output
Mangyaring mag-isip, mag-analisa, at magpaliwanag nang hakbang-hakbang, pagkatapos ay ilabas ang kumpletong code para sa `src/csv_parser.c` sa sumusunod na format, siguraduhing secure ang code at walang vulnerability risks:
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

## Example
```xml
<csv_parser>
    <name>
        name1
    </name>
    <field_sizes>
        <field>
            field1
        </field>
        <field>
            field2
        </field>
    </field_sizes>
    <csv_data>
        <record>
            <field>
                name1
            </field>
            <field>
                age1
            </field>
            <field>
                city1
            </field>
        </record>
        <record>
            <field>
                name2
            </field>
            <field>
                age2
            </field>
            <field>
                city2
            </field>
        </record>
    </csv_data>
</csv_parser>
```
`
`,
