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