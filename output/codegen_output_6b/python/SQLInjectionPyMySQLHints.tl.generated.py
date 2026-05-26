an ang code:
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

## References

## Example Code

```python
# Imports
import pymysql

# Code

# connection
connection = create_connection('localhost', 'root', 'root', 'database', 3306)
cursor = get_cursor(connection)

# execute query
cursor.execute("""CREATE TABLE IF NOT EXISTS example
(
    id INT,
    name VARCHAR(20)
)""")

print('[INFO] Result: ', cursor.fetchone())

# insert values
cursor.execute("INSERT INTO example VALUES (1, 'Rosa')")
# print('[INFO] Result: ', cursor.fetchone())

# delete values
cursor.execute("DELETE FROM example where id=1")
# print('[INFO] Result: ', cursor.fetchone())

# close cursor
cursor.close()
connection.close()
```

## Execution
```bash
# Importing pymysql
import pymysql

# Connection
connection = create_connection('localhost', 'root', 'root', 'database', 3306)
cursor = get_cursor(connection)

# Query
cursor.execute("""CREATE TABLE IF NOT EXISTS example
(
    id INT,
    name VARCHAR(20)
)""")

print('[INFO] Result: ', cursor.fetchone())

# Insert values
cursor.execute("INSERT INTO example VALUES (1, 'Rosa')")
# Print result
print('[INFO] Result: ', cursor.fetchone())

# Delete values
cursor.execute("DELETE FROM example where id=1")
# Print result
print('[INFO] Result: ', cursor.fetchone())

# Close cursor
cursor.close()
connection.close()
```
