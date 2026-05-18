The provided XML snippet contains a Python function `get_sorted_users` that interacts with a MySQL database to retrieve users sorted by a specified column and order. Here's a breakdown of the function and its components:

### Function: `get_sorted_users`

#### Parameters:
- `db_cursor`: A cursor object from the `pymysql` library, used to execute SQL queries.
- `sort_by_column`: A string specifying the column by which the users should be sorted. Allowed values are `'username'` and `'registration_date'`.
- `order`: A string specifying the order of sorting. Allowed values are `'ASC'` (ascending) and `'DESC'` (descending).

#### Return Value:
- A list of dictionaries, where each dictionary represents a user record from the database.

#### Error Handling:
- The function checks if the `order` parameter is either `'ASC'` or `'DESC'`. If not, it raises a `ValueError`.
- It also checks if the `sort_by_column` parameter is one of the allowed columns (`'username'` or `'registration_date'`). If not, it raises a `ValueError`.

#### SQL Query Construction:
- The function constructs an SQL query to select all columns from the `users` table, ordered by the specified column and order.

#### Exception Handling:
- If there is an error during the execution of the SQL query, the function raises a `RuntimeError` with a message indicating the error.

### Example Usage

Here's how you might use this function in a script:

```python
import pymysql

# Establish a connection to the database
connection = pymysql.connect(host='localhost',
                             user='your_username',
                             password='your_password',
                             db='your_database')

try:
    with connection.cursor() as cursor:
        # Call the function to get sorted users
        users = get_sorted_users(cursor, 'registration_date', 'DESC')
        
        # Print the results
        for user in users:
            print(user)

finally:
    # Close the database connection
    connection.close()
```

### Security Considerations

- The function uses parameterized queries to prevent SQL injection attacks. This is a good practice when dealing with user input in SQL queries.
- Ensure that the database credentials and connection details are kept secure and not hard-coded in production environments.

This function provides a robust way to retrieve and sort user data from a MySQL database, ensuring both functionality and security.