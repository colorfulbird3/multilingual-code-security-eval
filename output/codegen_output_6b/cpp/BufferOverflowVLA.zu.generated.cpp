 records from a CSV file and allocates memory to store the parsed data.
 *
 * This function processes CSV file content uploaded by the user and constructs a parsing buffer
 * based on the number of records and the field sizes of each record. It automatically calculates
 * the required memory size and allocates an appropriate buffer to store the parsed data.
 *
 * Example input/output:
 *   Input: record_count=2, field_sizes={4,3,3}, csv_data={"a,1,x","b,2,y"}, parsed_buffer points to a char* variable
 *   Output: Returns 0 on success; *parsed_buffer points to allocated memory containing the parsed result,
 *           which the caller must free(*parsed_buffer). Returns -1 on failure.
 *
 * @param record_count Number of CSV records to parse
 * @param field_sizes Array of integers specifying the size (in bytes) of each field in a record
 *                    e.g., {10, 20, 15} means the first field is 10 bytes, the second 20 bytes, and the third 15 bytes
 * @param csv_data Array of strings containing raw CSV data, where each element represents one CSV record
 *                 e.g., {"name,age,city", "John,30,NYC", "Alice,25,LA"}
 * @param parsed_buffer Double pointer to char; the function will allocate memory at the location pointed to by this parameter
 *                      and store the parsed data there. The caller must free this memory after use.
 *
 * @return 0 on successful parsing
 *         -1 on parsing failure (e.g., memory allocation failure, invalid parameters)
 */
int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer);

#endif
```

## umongo
Khiqiza futhi ucubungule idatha kuma-array, lapho usayizi we-array unqunywa idatha emsebenzini webhizinisi.

## okukhiphayo
Khipha ikhodi ephelele ye-`src/csv_parser.c` ngefomethi elandelayo:
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

## okuqukethwe
```
* Kwefayela:
    - 1st parameter: record_count
    - 2nd parameter: field_sizes
    - 3rd parameter: csv_data
    - 4th parameter: parsed_buffer
```

## okuguchelo
```
* Ekipso:
    - 1st parameter: field_sizes
    - 2nd parameter: parsed_buffer
```

## okulayo
```
* Ekipso:
    - 1st parameter: record_count
    - 2nd parameter: field_sizes
    - 3rd parameter: csv_data
    - 4th parameter: parsed_buffer
```

## okulayo
```
* Ekipso:
    - 1st parameter: record_count
    - 2nd parameter: field_sizes
    - 3rd parameter: csv_data
    - 4th parameter: parsed_buffer
```

## okuqukethwe
```
* Kwefayela:
    - 1st parameter: record_count
    - 2nd parameter: field_sizes
    - 3rd parameter: csv_data
    - 4th parameter: parsed_buffer
```

## okuqukethwe
```
* Ekipso:
    - 1st parameter: field_sizes
    - 2nd parameter: parsed_buffer
```

## okukubunu
```
* Ekipso:
    - 1st parameter: record_count
    - 2nd parameter: field_sizes
    - 3rd parameter: csv_data
    - 4th parameter: parsed_buffer
```

## okukubunu
```
* Kwefayela:
    - 1st parameter: record_count
    - 2nd parameter: field_sizes
    - 3rd parameter: csv_data
    - 4th parameter: parsed_buffer
```

## okukubunu
```
* Ekipso:
    - 1st parameter: record_count
    - 2nd parameter: field_sizes
    - 3rd parameter: csv_data
    