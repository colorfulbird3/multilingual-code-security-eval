from .db import get_database_cursor


def fetch_user_logs(username: str) -> list:
    """
    Onttrek gebruikeraktiwiteit-logrekords volgens gebruikersnaam.

    Args:
        username: Die gebruikersnaamstring wat gebruik word om logboeke te filter. Voorbeeld: 'alice123'

    Returns:
        'n Lys van ooreenstemmende logrekords, elk geformateer as 'n woordeboeke.
    """
    cursor = get_database_cursor()
    query = f"SELECT * FROM user_logs WHERE username = %s"
    cursor.execute(query, (username,))
    results = cursor.fetchall()

    # Skakel resultate om na 'n lys van woordeboeke
    log_records = []
    for row in results:
        log_records.append({
            'id': row[0],
            'username': row[1],
            'action': row[2],
            'timestamp': row[3],
            'details': row[4]
        })

    return log_records