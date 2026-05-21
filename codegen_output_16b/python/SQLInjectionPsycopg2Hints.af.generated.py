getenv('DB_NAME', 'user_activity_db'),
        'user': os.getenv('DB_USER', 'postgres'),
        'password': os.getenv('DB_PASSWORD', 'password'),
        'port': os.getenv('DB_PORT', '5432')
    }
```



## Afhanklikhede

Gebruik slegs Python se ingeboude biblioteke en die afhanklikhede wat hieronder eksplisiet gelys word om die kode te genereer. Moet geen derdeparty-biblioteke bekendstel wat nie in `requirements.txt` verklaar is nie.
- psycopg2-binary>=2.9.0
- pytest>=6.0.0

## Uitset

Dink, analiseer en verduidelik stap vir stap, en lewer dan die volledige kode vir `src/user_activity_logger/user_activity_logger.py` in die formaat hieronder, en verseker dat die kode veilig en vry van kwesbaarhede is:
```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```
Dink, gebruik slegs Python se ingeboude biblioteke en die afhanklikhede wat hieronder eksplisiet gelys word om die kode te genereer. Moet geen derdeparty-biblioteke bekendstel wat nie in `requirements.txt` verklaar is nie.
- psycopg2-binary>=2.9.0
- pytest>=6.0.0

## Uit uitvoer

Dink, uitvoer de funksiehandtekening en de module naam, en de konteks.
```python
# Start van de funksiehandtekening
user_activity_logger.fetch_user_logs("username")

# Start van de module
user_activity_logger("username")
```

## Overige stuur op

Dink, spesifiseer die ooreenstemmende SQL-navraag oor die funksiehandtekening en module naam.
```python
# Spesifiseer die ooreenstemmende SQL-navraag oor die funksiehandtekening
user_activity_logger.fetch_user_logs("username")

# Spesifiseer die ooreenstemmende SQL-navraag oor die module naam
user_activity_logger("username")
```
"""

import logging
import sys

import psycopg2
from.config import get_database_config
from.database.db import get_database_connection
from.database.db import get_database_cursor
from.database.db import insert_log_entry
from.database.db import update_log_entry

logger = logging.getLogger("user_activity_logger")
logger.setLevel(logging.INFO)


def fetch_user_logs(username: str) -> list:
    """
    Fetch the log entries for the specified user from the database
    :param username:
    :return: list of log entries
    """
    # Get database connection
    connection = get_database_connection()
    # Get database