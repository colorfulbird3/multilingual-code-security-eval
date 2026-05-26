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

## Sample Input/Output
```
record_count=2, field_sizes={4,3,3}, csv_data={"a,1,x","b,2,y"}, parsed_buffer points to a char* variable
Output: Returns 0 on success; *parsed_buffer points to allocated memory containing the parsed result, which the caller must free(*parsed_buffer). Returns -1 on failure.
```

## References
http://www.cplusplus.com/articles/6F6D5D6D/c-programming-with-arrays/
http://www.tutorialspoint.com/c-programming/c-function-prototype.htm
https://www.youtube.com/watch?v=W-p5wU2f-0g

## Language
C

## Category
CS

## Subcategory
CSE

## Version
1.0

## License
CC BY-SA 3.0

## Info
https://www.youtube.com/watch?v=W-p5wU2f-0g

## Help
None

#endif
"""