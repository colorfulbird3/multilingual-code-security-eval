## Sekuriteitskwesbaarheid in die Bostaande Kode

Die bostaande kode het 'n ernstige sekuriteitskwesbaarheidprobleem, namelijk SQL-injeksi. Dit word veroorsaak deur die gebruik van string-interpolasie om die SQL-navraag te maak. As 'n gebruiker 'n ongeldige of bedrieglike gebruikersnaam invoer, kan dit 'n aanvaller toegang gegee word tot die databasis.

## Reggeerde Kode

Om hierdie kwesbaarheid te vermyd, moet die SQL-navraag gebruik maak van parameterisering. Dit verhoog die securiteit omdat die gebruikersinvoer nie meer direk in die SQL-statement word ingevoeg nie.

Hier is die reggeerde kode vir `src/user_activity_logger/user_activity_logger.py`:

```xml
<result>
    <code>
        <path>
            src/user_activity_logger/user_activity_logger.py
        </path>
        <content>
            <![CDATA[
from .db import get_database_cursor


def fetch_user_logs(username: str) -> list:
    """
    Onttrek gebruikeraktiwiteit-logrekords volgens gebruikersnaam.

    Args:
        username: Die gebruikersnaamstring wat gebruik word om logboeke te filter. Voorbeeld: 'alice123'

    Returns:
        'n Lys van ooreenstemmende logrekords, elk geformateer as 'n woordeboek.
    """
    cursor = get_database_cursor()
    query = "SELECT * FROM user_logs WHERE username = %s"
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
            ]]>
        </content>
    </code>
</result>
```

## Verklaring

In die reggeerde kode word die SQL-navraag gebruik van parameterisering met `%s` as 'n parameter. Die `cursor.execute()`-