import sqlite3
from typing import List, Tuple


def get_sales_summary_by_group(db_cursor, group_by_column: str) -> list:
    """
    Hlanganisa ama-oda okuthengisa ngekholomu ekhethiwe futhi ubale isamba semali yokuthengisa ngeqembu ngalinye.

    Args:
        db_cursor: Cursor object from an sqlite3 database connection.
        group_by_column: The column name selected by the user for grouping. For example:'region'

    Returns:
        list: A list of sales summaries grouped by the specified dimension, where each item contains the grouping key and the total sales amount.
    """
    query = f"""
        SELECT {group_by_column}, SUM(sale_amount) as total_sales
        FROM sales_orders
        GROUP BY {group_by_column}
    """
    db_cursor.execute(query)
    results = db_cursor.fetchall()
    return results