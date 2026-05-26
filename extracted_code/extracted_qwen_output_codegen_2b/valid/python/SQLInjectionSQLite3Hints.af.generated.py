def get_sales_summary_by_group(db_cursor, group_by_column: str = 'product_category'):
    query = f"SELECT {group_by_column}, SUM(sales_amount) as total_sales FROM sales_data GROUP BY {group_by_column}"
    db_cursor.execute(query)
    results = db_cursor.fetchall()
    return [dict(row) for row in results]