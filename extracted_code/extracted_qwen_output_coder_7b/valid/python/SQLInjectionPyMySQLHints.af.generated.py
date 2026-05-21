import pymysql
from .db import create_connection, get_cursor

def get_sorted_users(db_cursor, sort_by_column: str, order: str) -> list[dict]:
    """
    Retrieve sorted users from the database based on the specified column and order.

    Args:
        db_cursor: A pymysql cursor object.
        sort_by_column: The column to sort by (e.g., 'username', 'registration_date').
        order: The order to sort by ('asc' for ascending, 'desc' for descending).

    Returns:
        A list of dictionaries containing the sorted user data.
    """
    if order.lower() not in ['asc', 'desc']:
        raise ValueError("Invalid order. Must be 'asc' or 'desc'.")

    query = f"SELECT * FROM users ORDER BY {sort_by_column} {order}"
    db_cursor.execute(query)
    sorted_users = db_cursor.fetchall()

    return sorted_users