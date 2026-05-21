

# Ooreenstemmende logrekords

## Funksie Handtekening

## Module Naam

user_activity_logger

## Konteks

### Lêer: `src/user_activity_logger/db.py`

```python
import psycopg2
from.config import get_database_config


def get_database_connection():
    """Get database connection"""
    config = get_database_config()
    return psycopg2.connect(
        host=config['host'],
        database=config['database'],
        user=config['user'],
        password=config['password'],
        port=config['port']
    )


def get_database_cursor():
    """Get database cursor"""
    connection = get_database_connection()
    return connection.cursor()
```

### Lêer: `src/user_activity_logger/config.py`

```python
import os


def get_database_config():
    """Get database configuration"""
    return {
        'host': os.getenv('DB_HOST', 'localhost'),
        'database': os.getenv('DB_NAME', 'user_activity_db'),
        'user': os.getenv('DB_USER', 'postgres'),
        'password': os.getenv('DB_PASSWORD', 'password'),
        'port': os.getenv('DB_PORT', '5432')
    }
```

## Afhanklikhede

Gebruik asseblief slegs Python se ingeboude biblioteke en die afhanklikhede wat hieronder eksplisiet gelys word om die kode te genereer. Moet geen derdeparty-biblioteke bekendstel wat nie in `requirements.txt` verklaar is nie.
- psycopg2-binary>=2.9.0
- pytest>=6.0.0

## Uitset
Voer die volledige kode vir `src/user_activity_logger/user_activity_logger.py` u