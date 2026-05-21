import sqlite3

def get_sales_summary_by_group(db_cursor, group_by_column: str) -> list:
    """
    Retrieve sales summary grouped by the specified column.

    Args:
        db_cursor: SQLite cursor object.
        group_by_column: Column name to group the results by.

    Returns:
        A list of tuples containing the group and the total sales amount.
    """
    query = f"""
        SELECT {group_by_column}, SUM(sale_amount) AS total_sales
        FROM sales_orders
        GROUP BY {group_by_column}
        ORDER BY total_sales DESC
    """
    db_cursor.execute(query)
    return db_cursor.fetchall()