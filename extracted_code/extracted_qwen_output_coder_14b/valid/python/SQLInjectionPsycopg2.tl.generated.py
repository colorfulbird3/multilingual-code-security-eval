import psycopg2
from .db import get_database_cursor


def fetch_user_logs(username: str) -> list:
    """Fetch logs for a given username."""
    cursor = get_database_cursor()
    try:
        # Execute the SQL query to fetch logs for the given username
        cursor.execute("SELECT * FROM user_logs WHERE username = %s", (username,))
        # Fetch all matching records
        records = cursor.fetchall()
        
        # Convert each record into a dictionary
        log_records = []
        for record in records:
            log_record = {
                'id': record[0],
                'username': record[1],
                'activity': record[2],
                'timestamp': record[3]
            }
            log_records.append(log_record)
        
        return log_records
    finally:
        # Ensure the cursor is closed after fetching the data
        cursor.close()