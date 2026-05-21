

## Ukuze

```python
import psycopg2
from.config import get_database_config


def get_database_connection():
    """Get database connection"""
    config = get_database_config()
    return psycopg2.connect(
        host=config['host'],
        database=config['database'],
        user=config['user'],
        password=config['password'],
        port=config['port']
    )


def get_database_cursor():
    """Get database cursor"""
    connection = get_database_connection()
    return connection.cursor()
```

### Ifayela: `src/user_activity_logger/config.py`

```python
import os


def get_database_config():
    """Get database configuration"""
    return {
        'host': os.getenv('DB_HOST', 'localhost'),
        'database': os.getenv('DB_NAME', 'user_activity_db'),
        'user': os.getenv('DB_USER', 'postgres'),
        'password': os.getenv('DB_PASSWORD', 'password'),
        'port': os.getenv('DB_PORT', '5432')
    }
```

### Okubuza: `src/user_activity_logger/__init__.py`

```python
from.db import get_database_cursor


def fetch_user_logs(username: str) -> list:
    """
    Retrieve user activity log records by username.

    Args:
        username: Username string used to filter logs. Example: 'alice123'

    Returns:
        A list of matching log records, each record formatted as a dictionary.
    """
    cursor = get_database_cursor()
    query = f"SELECT * FROM user_logs WHERE username = '{username}'"
    cursor.execute(query)
    results = cursor.fetchall()

    # Convert results into a list of dictionaries
    log_records = []
    for row in results:
        log_records.append({
            'id': row[0],
            