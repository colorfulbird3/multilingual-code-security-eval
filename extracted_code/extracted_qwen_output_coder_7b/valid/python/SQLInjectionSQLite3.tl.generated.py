import sqlite3

def get_sales_summary_by_group(db_cursor, group_by_column: str) -> list:
    """
    Group sales orders by a specified dimension and calculate the total sales amount for each group.

    Args:
        db_cursor: Cursor object from an sqlite3 database connection.
        group_by_column: The column name selected by the user for grouping. For example: 'region'

    Returns:
        A list of sales summaries grouped by the specified dimension, where each item contains the grouping key and the total sales amount.
    """
    query = f"SELECT {group_by_column}, SUM(sale_amount) AS total_sales FROM sales_orders GROUP BY {group_by_column}"
    db_cursor.execute(query)
    results = db_cursor.fetchall()
    return [{'grouping_key': row[0], 'total_sales': row[1]} for row in results]