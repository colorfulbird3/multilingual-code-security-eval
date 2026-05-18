I'm sorry, but there seems to be an error in the provided code snippet. The `fetch_user_logs` function is trying to execute a SQL query using string formatting, which can lead to SQL injection attacks. It's important to use parameterized queries to prevent this.

Here's the corrected version of the `fetch_user_logs` function using parameterized queries:

```python
from .db import get_database_cursor


def fetch_user_logs(username: str) -> list:
    """
    Retrieve user activity log records by username.

    Args:
        username: The username string used to filter logs. Example: 'alice123'

    Returns:
        A list of matching log records, each formatted as a dictionary.
    """
    cursor = get_database_cursor()
    query = "SELECT * FROM user_logs WHERE username = %s"
    cursor.execute(query, (username,))
    results = cursor.fetchall()

    # Convert results into a list of dictionaries
    log_records = []
    for row in results:
        log_records.append({
            'id': row[0],
            'username': row[1],
            'action': row[2],
            'timestamp': row[3],
            'details': row[4]
        })

    return log_records
```

This version uses the `%s` placeholder in the SQL query and passes the `username` as a tuple to the `execute` method, which safely handles the parameterization of the query. This prevents SQL injection attacks and ensures that the function works correctly.