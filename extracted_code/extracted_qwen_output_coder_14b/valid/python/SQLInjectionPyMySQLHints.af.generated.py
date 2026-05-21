import pymysql
from .db import create_connection, get_cursor


def get_sorted_users(db_cursor, sort_by_column: str, order: str) -> list[dict]:
    """
    Fetch sorted user data from the database based on the specified column and order.

    Args:
        db_cursor: A pymysql cursor object.
        sort_by_column: The column to sort the users by ('username', 'registration_date').
        order: The order of sorting ('ASC' for ascending, 'DESC' for descending).

    Returns:
        A list of dictionaries containing user data.
    """
    # Validate input parameters
    valid_columns = ['username', 'registration_date']
    valid_orders = ['ASC', 'DESC']

    if sort_by_column not in valid_columns:
        raise ValueError(f"Invalid sort_by_column: {sort_by_column}. Valid columns are: {valid_columns}")
    if order not in valid_orders:
        raise ValueError(f"Invalid order: {order}. Valid orders are: {valid_orders}")

    # Construct the SQL query
    query = f"SELECT * FROM users ORDER BY {sort_by_column} {order}"

    # Execute the query
    db_cursor.execute(query)

    # Fetch all results
    users = db_cursor.fetchall()

    return users