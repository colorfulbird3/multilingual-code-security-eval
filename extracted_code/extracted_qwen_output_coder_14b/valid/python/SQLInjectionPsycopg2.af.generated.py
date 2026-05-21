import psycopg2
from .db import get_database_cursor

def fetch_user_logs(username: str) -> list:
    """Fetch logs for a specific username from the database."""
    cursor = get_database_cursor()
    query = "SELECT * FROM logs WHERE username = %s"
    cursor.execute(query, (username,))
    
    logs = []
    for row in cursor.fetchall():
        log_record = {
            'id': row[0],
            'timestamp': row[1],
            'username': row[2],
            'activity': row[3]
        }
        logs.append(log_record)
    
    cursor.close()
    return logs