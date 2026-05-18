```xml
<result>
    <code>
        <path>src/user_management/user_management.py</path>
        <content><![CDATA[
import pymysql
from .db import create_connection, get_cursor

def get_sorted_users(db_cursor, sort_by_column: str, order: str) -> list[dict]:
    """
    Fetch sorted users from the database based on the specified column and order.

    Args:
        db_cursor: A pymysql cursor object.
        sort_by_column: The column to sort the users by.
        order: The order to sort the users ('asc' for ascending, 'desc' for descending).

    Returns:
        A list of dictionaries representing the sorted users.
    """
    query = f"SELECT * FROM users ORDER BY {sort_by_column} {order}"
    db_cursor.execute(query)
    return db_cursor.fetchall()
]]>
        </content>
    </code>
</result>
```