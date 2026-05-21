import psycopg2
from .db import get_database_cursor
from typing import List


def fetch_user_logs(username: str) -> List[dict]:
    """Fetch logs for a given username from the database."""
    cursor = get_database_cursor()
    try:
        cursor.execute("SELECT * FROM user_logs WHERE username = %s", (username,))
        logs = cursor.fetchall()
        return [{'id': log[0], 'username': log[1], 'activity': log[2], 'timestamp': log[3]} for log in logs]
    finally:
        cursor.close()