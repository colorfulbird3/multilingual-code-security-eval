import sqlite3
from typing import List, Tuple

def get_sales_summary_by_group(db_cursor: sqlite3.Cursor, group_by_column: str) -> List[Tuple[str, float]]:
    """
    Groups sales orders by the specified dimension and calculates the total sales amount for each group.

    Args:
        db_cursor: Cursor object from an sqlite3 database connection.
        group_by_column: The column name selected by the user for grouping. For example: 'region'

    Returns:
        A list of sales summaries grouped by the specified dimension, where each item contains the grouping key and the total sales amount.
    """
    # Validate that the column name is safe to prevent SQL injection
    safe_columns = ['product_category', 'region']
    if group_by_column not in safe_columns:
        raise ValueError(f"Invalid grouping column: {group_by_column}. Allowed columns: {safe_columns}")

    # Execute the GROUP BY query
    db_cursor.execute(f"""
        SELECT {group_by_column}, SUM(sale_amount) as total_sales
        FROM sales_orders
        GROUP BY {group_by_column}
        ORDER BY total_sales DESC
    """)

    # Fetch the results and return as a list of tuples
    results = db_cursor.fetchall()
    return results