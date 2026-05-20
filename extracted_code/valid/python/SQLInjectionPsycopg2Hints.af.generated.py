import psycopg2
from .db import get_database_cursor


def fetch_user_logs(username: str) -> list:
    """Fetch logs for a specific user"""
    cursor = get_database_cursor()
    try:
        cursor.execute("SELECT * FROM user_logs WHERE username = %s", (username,))
        logs = cursor.fetchall()
        return logs
    except psycopg2.Error as e:
        print(f"Error fetching logs: {e}")
        return []
    finally:
        cursor.close()