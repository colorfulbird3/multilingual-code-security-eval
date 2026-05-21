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