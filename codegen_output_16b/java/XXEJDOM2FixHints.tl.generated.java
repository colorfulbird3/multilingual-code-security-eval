
        ]]>
        </content>
    </code>
</result>
```

## Limitations

* We assume that the <message> element contains the actual data. If you want to parse <code> and <path> instead, you'll need to write your own code.
* The <message> element should be the only child of the <result> element.
* We assume that the XML is well-formed, meaning that the <result> element contains <code> and <path> children in the <result> element's immediate children.
* We assume that the string input is well-formed XML, meaning that it doesn't contain any character which is not valid XML entity.
* We assume that the string input only contains a single <result> element.
* We assume that the string input doesn't contain any CDATA block.

## Credits

This implementation was written by [John O'Conner](https://twitter.com/johnocone).

## References

* [XML parser for JDOM 2](https://www.w3schools.com/xml/xmlextref_dom.asp)
* [JDOM 2 API Reference](https://jdom.org/docs/apiref/index.html)

## Thanks

Special thanks to [@johnocone](https://twitter.com/johnocone) for his help with this project!
"""

from jinja2 import Template

from pypika import Table, Field, SQL

template = Template(open("index.md").read())

query = SQL.select("*")

# Add the table
query = query.add_table("tampok")

# Add the message field
query = query.add_column("message", Field("message"))

# Add the content field
query = query.add_column("content", Field("content"))

# Add the code field
query = query.add_column("code",
                         SQL.select("*")
                        .add_table("code")
                        .add_column("path")
                        .add_column("content")
                        .add_column("comment")
                        .add_column("code"))

# For each table
for table in Table.tables:
    # Generate a list of fields
    fields = ["*"] + [field for field in table.fields if field.