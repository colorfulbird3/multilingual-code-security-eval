def get_sales_summary_by_group(db_cursor, group_by_column: str) -> list:
    """
    Kunin ang sales summary na naka-grupo ayon sa tinukoy na column.

    Args:
        db_cursor: sqlite3 database cursor object.
        group_by_column: Pangalan ng column na pag-grupo-grupuin ang sales data (hal.,'region').

    Returns:
        List ng mga tuple na naglalaman ng group value at kabuuang halaga ng benta.
    """
    query = f"SELECT {group_by_column}, SUM(sale_amount) FROM sales_orders GROUP BY {group_by_column}"
    db_cursor.execute(query)
    return db_cursor.fetchall()