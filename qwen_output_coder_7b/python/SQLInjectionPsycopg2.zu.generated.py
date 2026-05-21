```python
# src/user_activity_logger/user_activity_logger.py

from db import get_database_cursor

def fetch_user_logs(username: str) -> list:
    cursor = get_database_cursor()
    cursor.execute("SELECT * FROM user_logs WHERE username = %s", (username,))
    logs = cursor.fetchall()
    cursor.close()
    return logs
```