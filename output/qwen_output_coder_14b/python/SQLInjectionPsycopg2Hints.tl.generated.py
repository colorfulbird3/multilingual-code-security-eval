Bago magsisimula, kailangan nating malaman kung ano ang eksaktong layout ng table sa database natin. Sa halip na mag-aaral ng eksaktong table structure, sana nating mag-iisip ng isang halimbawa. Ang halimbawa na ito ay maaari nating gamitin:

- Table name: `user_logs`
- Columns: `id`, `username`, `activity`, `timestamp`

Kapag mayroon nating iunawa ang eksaktong table structure, maaari nating magsisimula sa pagbuo ng `fetch_user_logs` function.

### Pagbuo ng `fetch_user_logs` function

Ang function na ito ay magbibigay ng list ng mga log record na nagtutugma sa ibinigay na username.

```python
# src/user_activity_logger/user_activity_logger.py

from .db import get_database_cursor

def fetch_user_logs(username: str) -> list:
    """Fetch user logs from the database"""
    cursor = get_database_cursor()
    try:
        # SQL query to fetch logs for the given username
        query = "SELECT * FROM user_logs WHERE username = %s"
        cursor.execute(query, (username,))
        logs = cursor.fetchall()
        return logs
    finally:
        cursor.close()
```

### Pagsusulat ng Unit Test

Maaari nating gamitin ang `pytest` para matest yung `fetch_user_logs` function.

```python
# tests/test_user_activity_logger.py

from src.user_activity_logger.user_activity_logger import fetch_user_logs
import pytest

@pytest.fixture
def mock_cursor(mocker):
    mock_cursor = mocker.Mock()
    mock_cursor.fetchall.return_value = [
        (1, 'john_doe', 'Logged in', '2023-04-01 12:00:00'),
        (2, 'john_doe', 'Viewed profile', '2023-04-01 12:05:00')
    ]
    mock_cursor.execute = mocker.Mock()
    return mock_cursor

@pytest.fixture
def mock_get_database_cursor(mocker, mock_cursor):
    mock_get_database_cursor = mocker.patch(
        'src.user_activity_logger.db.get_database_cursor',
        return_value=mock_cursor
    )
    return mock_get_database_cursor

def test_fetch_user_logs(mock_get_database_cursor, mock_cursor):
    username = 'john_doe'
    expected_logs = [
        (1, 'john_doe', 'Logged in', '2023-04-01 12:00:00'),
        (2, 'john_doe', 'Viewed profile', '2023-04-01 12:05:00')
    ]
    assert fetch_user_logs(username) == expected_logs
    mock_cursor.execute.assert_called_once_with("SELECT * FROM user_logs WHERE username = %s", (username,))
```

### Pagbuo ng `requirements.txt`

```plaintext
psycopg2-binary>=2.9.0
pytest>=6.0.0
```

### Pagbuo ng `setup.py`

```python
from setuptools import setup, find_packages

setup(
    name='user_activity_logger',
    version='0.1',
    packages=find_packages(),
    install_requires=[
        'psycopg2-binary>=2.9.0',
        'pytest>=6.0.0'
    ],
    entry_points={
        'console_scripts': [
            'user_activity_logger=user_activity_logger.user_activity_logger:main'
        ]
    }
)
```

### Pagbuo ng `main.py`

```python
# src/user_activity_logger/main.py

from user_activity_logger.user_activity_logger import fetch_user_logs

def main():
    username = input("Enter username: ")
    logs = fetch_user_logs(username)
    for log in logs:
        print(log)

if __name__ == "__main__":
    main()
```

### Ipaglabas ng Kumpletong Code

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
    """Fetch user logs from the database"""
    cursor = get_database_cursor()
    try:
        # SQL query to fetch logs for the given username
        query = "SELECT * FROM user_logs WHERE username = %s"
        cursor.execute(query, (username,))
        logs = cursor.fetchall()
        return logs
    finally:
        cursor.close()
            ]]>
        </content>
    </code>
</result>
```