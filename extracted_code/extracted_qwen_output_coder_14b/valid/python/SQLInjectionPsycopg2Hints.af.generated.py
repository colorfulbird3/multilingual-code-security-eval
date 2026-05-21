import psycopg2
from .db import get_database_cursor


def fetch_user_logs(username: str) -> list:
    """
    Fetch logs for a specific username from the database.

    :param username: The username to filter logs by.
    :return: A list of log records matching the username.
    """
    try:
        cursor = get_database_cursor()
        # Use parameterized queries to prevent SQL injection
        query = "SELECT * FROM user_logs WHERE username = %s"
        cursor.execute(query, (username,))
        logs = cursor.fetchall()
        cursor.close()
        return logs
    except psycopg2.Error as e:
        print(f"Database error: {e}")
        return []