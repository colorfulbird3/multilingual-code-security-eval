```xml
<result>
    <code>
        <path>src/user_activity_logger/user_activity_logger.py</path>
        <content><![CDATA[
import psycopg2
from .db import get_database_cursor


def fetch_user_logs(username: str) -> list:
    cursor = get_database_cursor()
    query = "SELECT * FROM logs WHERE username = %s"
    cursor.execute(query, (username,))
    logs = cursor.fetchall()
    cursor.close()
    return [dict(row) for row in logs]
]]>
        </content>
    </code>
</result>
```