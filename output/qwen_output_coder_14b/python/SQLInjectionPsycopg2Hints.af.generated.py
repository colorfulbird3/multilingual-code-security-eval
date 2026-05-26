Hier is die gevraagde Python-kode vir `src/user_activity_logger/user_activity_logger.py`:

```xml
<result>
    <code>
        <path>
            src/user_activity_logger/user_activity_logger.py
        </path>
        <content>
            <![CDATA[
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
            ]]>
        </content>
    </code>
</result>
```

### Toelichting:

1. **Funksie Handtekening**: Die funksie `fetch_user_logs` nemen 'n `username` as 'n parameter en teruggee 'n lys van logboek rekords wat ooreenstem met die gebruikersnaam.

2. **Parameteriseerde Navraag**: Om SQL-injectieweerspawing te voorkom, gebruik 'n parameteriseerde navraag (`%s`) met `cursor.execute()`.

3. **Database Koneksie**: Die funksie maak gebruik van die `get_database_cursor` funksie om 'n database kursor te verkry.

4. **Foutafhandeling**: Foutafhandeling is bygevoeg om eventuele database foute te praat.

5. **Veiligheid**: Die gebruik van parameteriseerde navraage verhoog die veiligheid van die kode teen SQL-injectieweerspawing.