
"""

from.db import get_database_cursor

def fetch_user_logs(username: str) -> list:
    """
    Onttrek gebruikeraktiwiteitlogrekords volgens gebruikersnaam.

    Args:
        username: gebruikersnaamstring wat gebruik word om logboeke te filter. Voorbeeld: 'alice123'

    Returns:
        'n Lys van ooreenstemmende logrekords, elke rekord geformateer as 'n woordeboek.
    """
    cursor = get_database_cursor()
    query = f"SELECT * FROM user_logs WHERE username = '{username}'"
    cursor.execute(query)
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
    """
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
    """
"""
    <code>
        <path>
            path2
        </path>
        <content>
            <![CDATA[
        content2
        ]]>
        </content>
    </code>
    """
    """
    </content>
</code>
    """
