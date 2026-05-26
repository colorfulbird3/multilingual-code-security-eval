# def get_sales_summary_by_group(db_cursor, group_by_column: str) -> list:
# """
# Retrieve sales summary grouped by the specified column.
# Args:
# db_cursor: sqlite cursor object
# group_by_column: the column to group by
# Returns:
# list of summary data
# """
# groups = db_cursor.execute(
# """SELECT DISTINCT product_category, region FROM sales_orders GROUP BY product_category, region""")
# return list(groups)
#