## Sekuriteitskwesbaarheid

Die sekuriteitskwesbaarheid wat in die bostaande kode teenwoordig is, is SQL-injectieweerskaap. Die `fetch_user_logs`-funksie bou 'n SQL-navraag op basis van die invoer van die `username`-parameter, wat kan leid tot 'n SQL-injectieweerskaap indien die invoer nie korrekt gevalideer of verduidelik word. Hier is 'n voorbeeld van hoe 'n aanvaller SQL-injectieweerskaap kan gebruik:

Stel dat die aanvaller die volgende invoer gee:

```python
username = "'; DROP TABLE user_logs; --"
```

Die resulterende SQL-navraag sal dan word:

```sql
SELECT * FROM user_logs WHERE username = ''; DROP TABLE user_logs; --'
```

Hierdie navraag sal die `user_logs`-tafel vernietig, wat 'n ernstige sekuriteitsprobleem kan veroorzaak.

## Reggede Kode

Om die SQL-injectieweerskaap te vermyd, moet ons parameteriseerde queries gebruik. Hier is die reggede kode vir `src/user_activity_logger/user_activity_logger.py`:

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

In hierdie reggede kode gebruik ons `%s` as 'n plekhouer in die SQL-navraag en gee die werkelike waarde van `username` as 'n tweedimensionele tupel aan die `cursor.execute()`-funksie. Dit vermyd SQL-injectieweerskaap omdat die invoer van die gebruiker korrekt verduidelik word.