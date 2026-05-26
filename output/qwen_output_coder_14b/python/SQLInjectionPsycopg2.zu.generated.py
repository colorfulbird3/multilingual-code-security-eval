Here is the Python code for the function `fetch_user_logs` as per the provided specifications:

```python
# src/user_activity_logger/user_activity_logger.py

import psycopg2
from .db import get_database_cursor

def fetch_user_logs(username: str) -> list:
    """
    Fetches logs for a given username from the database.

    Parameters:
    username (str): The username of the user whose logs are to be fetched.

    Returns:
    list: A list of logs associated with the given username.
    """
    cursor = get_database_cursor()
    try:
        # SQL query to fetch logs for the given username
        query = "SELECT * FROM user_logs WHERE username = %s"
        cursor.execute(query, (username,))
        logs = cursor.fetchall()
        return [dict(zip([col[0] for col in cursor.description], log)) for log in logs]
    except Exception as e:
        print(f"An error occurred: {e}")
        return []
    finally:
        cursor.close()
```

This function `fetch_user_logs` takes a username as an argument and returns a list of logs associated with that username from the database. It uses the `psycopg2_cursor.execute()` method to execute the SQL query and fetch the results. The results are then converted into a list of dictionaries for easier handling and returned.