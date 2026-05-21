import sqlite3

def get_sales_summary_by_group(db_cursor, group_by_column: str) -> list:
    """
    Retrieve sales summary grouped by the specified column.

    Args:
        db_cursor: sqlite3 database cursor object.
        group_by_column: Column name to group sales data by (e.g., 'region').

    Returns:
        List of tuples containing the group value and total sales amount.
    """
    # Validate the group_by_column
    valid_columns = ['product_category', 'region']
    if group_by_column not in valid_columns:
        raise ValueError(f"Invalid column name: {group_by_column}. Must be one of {valid_columns}")

    try:
        # Use parameterized query to prevent SQL injection
        query = f"SELECT {group_by_column}, SUM(sale_amount) FROM sales_orders GROUP BY {group_by_column}"
        db_cursor.execute(query)
        return db_cursor.fetchall()
    except sqlite3.Error as e:
        raise RuntimeError(f"Database error: {e}")