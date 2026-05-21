import psycopg2
from .db import get_database_cursor


def fetch_user_logs(username: str) -> list:
    """Fetch user logs from the database"""
    cursor = get_database_cursor()
    try:
        # SQL query to fetch logs for the given username
        query = "SELECT * FROM user_logs WHERE username = %s"
        cursor.execute(query, (username,))
        logs = cursor.fetchall()
        return logs
    finally:
        cursor.close()