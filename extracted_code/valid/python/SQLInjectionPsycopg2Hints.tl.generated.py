import psycopg2
from .db import get_database_cursor


def fetch_user_logs(username: str) -> list:
    """Fetch logs for a specific user"""
    cursor = get_database_cursor()
    try:
        cursor.execute("SELECT * FROM user_logs WHERE username = %s", (username,))
        logs = cursor.fetchall()
        return logs
    except Exception as e:
        print(f"Error fetching logs: {e}")
        return []
    finally:
        cursor.close()
        # Ensure the connection is closed if not already done by the cursor
        connection = cursor.connection
        if connection and connection.open:
            connection.close()