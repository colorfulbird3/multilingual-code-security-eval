```xml
<result>
    <code>
        <path>
            src/user_management/user_management.py
        </path>
        <content>
            <![CDATA[
import pymysql
from .db import create_connection, get_cursor

def get_sorted_users(db_cursor, sort_by_column: str, order: str) -> list[dict]:
    """
    Retrieve and return a sorted list of users from the database.

    Args:
        db_cursor: A valid pymysql database cursor object.
        sort_by_column: The column name to sort by, e.g., 'username' or 'registration_date'.
        order: The sorting order, either 'ASC' or 'DESC'.

    Returns:
        A list of dictionaries containing user information, sorted according to the specified criteria.
    """
    try:
        # Construct the SQL query with dynamic sorting
        query = f"SELECT * FROM users ORDER BY {sort_by_column} {order}"
        
        # Execute the query
        db_cursor.execute(query)
        
        # Fetch all results
        users = db_cursor.fetchall()
        
        return users
    except Exception as e:
        print(f"An error occurred: {e}")
        return []

# Example usage:
if __name__ == "__main__":
    # Establish a database connection
    connection = create_connection('localhost', 'user', 'password', 'database_name')
    
    # Get a cursor
    cursor = get_cursor(connection)
    
    # Fetch sorted users
    sorted_users = get_sorted_users(cursor, 'registration_date', 'DESC')
    
    # Print the sorted users
    for user in sorted_users:
        print(user)
    
    # Close the connection
    connection.close()
            ]]>
        </content>
    </code>
</result>
```