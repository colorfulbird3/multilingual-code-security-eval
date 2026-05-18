```xml
<result>
    <code>
        <path>src/user_management/user_management.py</path>
        <content><![CDATA[
import pymysql

from .db import create_connection, get_cursor


def get_sorted_users(db_cursor, sort_by_column: str, order: str) -> list[dict]:
    """
    Fetches sorted user data from the database.

    Args:
        db_cursor: A valid pymysql database cursor object.
        sort_by_column: The column name in the database to sort by. E.g., 'username' or 'registration_date'.
        order: The sorting order, must be 'ASC' or 'DESC'.

    Returns:
        A list of dictionaries containing user information, sorted as per the specified criteria.
    """
    query = f"SELECT * FROM users ORDER BY {sort_by_column} {order}"
    db_cursor.execute(query)
    sorted_users = db_cursor.fetchall()
    return sorted_users
]]>
        </content>
    </code>
</result>
```