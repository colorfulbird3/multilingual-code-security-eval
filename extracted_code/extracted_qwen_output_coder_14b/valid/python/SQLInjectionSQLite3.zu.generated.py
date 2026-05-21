def get_sales_summary_by_group(db_cursor, group_by_column):
    query = f"SELECT {group_by_column}, SUM(sale_amount) FROM sales GROUP BY {group_by_column}"
    db_cursor.execute(query)
    return db_cursor.fetchall()