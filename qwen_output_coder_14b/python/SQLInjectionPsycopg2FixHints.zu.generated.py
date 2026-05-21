Here is the code snippet that you requested:

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
    Retrieve user activity log records by username.

    Args:
        username: The username string used to filter logs. Example: 'alice123'

    Returns:
        A list of matching log records, each formatted as a dictionary.
    """
    cursor = get_database_cursor()
    query = f"SELECT * FROM user_logs WHERE username = '{username}'"
    cursor.execute(query)
    results = cursor.fetchall()

    # Convert results into a list of dictionaries
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