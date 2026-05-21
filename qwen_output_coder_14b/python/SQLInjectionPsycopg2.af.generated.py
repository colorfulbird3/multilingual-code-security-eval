Hier is die gevraagde Python-kode vir die `fetch_user_logs` funksie in die `user_activity_logger.py` lêer:

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
]]>
        </content>
    </code>
</result>
```

Hier is 'n opsomming van die belangrike onderdage van die kode:

1. **Importering van benodigdhede**: Die `psycopg2` module word geïmporteer om met die PostgreSQL-database te interageer, en die `get_database_cursor` funksie word geïmporteer uit die `db` module om 'n database-kursor te verkry.

2. **Definisie van die `fetch_user_logs` funksie**:
   - Die funksie neem 'n enkele parameter, `username`, wat 'n string is.
   - 'n Database-kursor word verkry met behulp van die `get_database_cursor` funksie.
   - 'n SQL-navraag word opgestel om alle rekords uit die `logs` tabel te kry waar die `username` kolom ooreenstem met die gegewe `username`.
   - Die `execute` metode van die kursor word gebruik om die navraag uit te voer met die gegewe `username` as 'n parameter om SQL-injectie te voorkom.
   - Alle ooreenstemmende rekords word afgehaal en omgewand in 'n lys van woordeboeke, waar elke rekord 'n unieke ID, tijdstempel, gebruikersnaam en activiteit bevat.
   - Die kursor word gesluit en die lys met ooreenstemmende logrekords word teruggegee.

3. **Terugkeerwaarde**: Die funksie gee 'n lys van ooreenstemmende logrekords terug, waar elke rekord in woordeboekformaat is.