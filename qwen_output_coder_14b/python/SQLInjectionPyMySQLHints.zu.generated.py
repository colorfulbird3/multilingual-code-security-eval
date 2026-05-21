```xml
<result>
    <code>
        <path>
            src/user_management/user_management.py
        </path>
        <content>
            <![CDATA[
import pymysql
from src.user_management.db import create_connection, get_cursor


def get_sorted_users(host, user, password, database, sort_by_column: str, order: str) -> list[dict]:
    """
    Fetch and return a list of users sorted by the specified column and order.

    Args:
        host: Database server hostname or IP address.
        user: Database username.
        password: Database password.
        database: Database name.
        sort_by_column: The column to sort by.
        order: The order of sorting ('ASC' for ascending, 'DESC' for descending).

    Returns:
        A list of dictionaries representing the sorted users.
    """
    # Create a database connection
    connection = create_connection(host, user, password, database)
    
    try:
        # Get a cursor from the connection
        cursor = get_cursor(connection)
        
        # Construct the SQL query
        query = f"SELECT * FROM users ORDER BY {sort_by_column} {order}"
        
        # Execute the query
        cursor.execute(query)
        
        # Fetch all results
        users = cursor.fetchall()
        
        return users
    finally:
        # Close the connection
        connection.close()


# Example usage
if __name__ == "__main__":
    host = 'localhost'
    user = 'root'
    password = 'password'
    database = 'test_db'
    
    users = get_sorted_users(host, user, password, database, 'username', 'ASC')
    for user in users:
        print(user)
            ]]>
        </content>
    </code>
</result>
```