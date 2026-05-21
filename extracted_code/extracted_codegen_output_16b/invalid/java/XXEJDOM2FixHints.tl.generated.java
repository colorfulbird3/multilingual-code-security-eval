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