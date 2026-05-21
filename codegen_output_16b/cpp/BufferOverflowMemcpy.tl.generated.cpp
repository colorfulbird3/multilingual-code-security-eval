* db_result =...;  // Query result returned by the database
 *   size_t db_result_len = 1024;
 *   char buffer[2048];
 *   int ret = process_query_result(db_result, db_result_len, buffer, sizeof(buffer));
 */
int process_query_result(const char* query_result, size_t result_len, char* output_buffer, size_t buffer_size);

#endif /* DB_PROCESSOR_H */
```

## konteksto
gamit ang C functions: memcpy, memmove

## output
Ilabas ang kumpletong code para sa `src/db_processor.c` sa sumusunod na format:
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

### template
```xml
<template>
    <header>
        <name>
            name1
        </name>
        <date>
            date1
        </date>
        <author>
            author1
        </author>
        <email>
            email1
        </email>
        <license>
            <!--... -->
        </license>
    </header>
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
</template>
```

## atributo
```xml
<atributo>
    <name>
        name1
    </name>
    <value>
        value1
    </value>
</atributo>
```

## method
```xml
<method>
    <name>
        name1
    </name>
    <parameters>
        <parameter>
            <name>
                name2
            </name>
            <value>
                value2
            </value>
        </parameter>
        <parameter>
            <name>
                name3
            </name>
            <value>
                value3
            </value>
        </parameter>
    </parameters>
</method>
```

## lupulo (header, code)
```xml
<lupulo>
    <header>
        <name>
            name1
        </name>
        <date>
            date1
        </date>
        <author>
            author1
        </author>
        <email>
            email1
        </email>
        <license>
            <!--... -->
        </license>
    </header>
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
</lupulo>
```

## comment
```xml
<comment><![CDATA[
    comment1