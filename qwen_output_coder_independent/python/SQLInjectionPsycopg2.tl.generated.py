```xml
<result>
    <code>
        <path>src/user_activity_logger/user_activity_logger.py</path>
        <content><![CDATA[
import psycopg2
from .db import get_database_cursor


def fetch_user_logs(username: str) -> list:
    cursor = get_database_cursor()
    try:
        cursor.execute("SELECT * FROM logs WHERE username = %s", (username,))
        records = cursor.fetchall()
        return [dict(row) for row in records]
    finally:
        cursor.close()
        cursor.connection.close()
        ]]></content>
    </code>
</result>
```