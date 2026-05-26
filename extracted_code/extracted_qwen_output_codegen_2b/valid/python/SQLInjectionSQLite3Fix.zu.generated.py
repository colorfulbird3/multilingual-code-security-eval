# def get_sales_summary_by_group(db_cursor, group_by_column: str) -> list:
# """
# Retrieve sales summary grouped by the specified column.
# Args:
# db_cursor: sqlite3 database cursor object.
# group_by_column: column to group by.
# """
# sales_summary = []
# for sale_data in db_cursor.execute(
# "SELECT id, product_category, region, sale_amount, order_date FROM sales_orders"
# ).fetchall():
# sales_summary.append(
# {
# "product_category": sale_data[1],
# "region": sale_data[2],
# "sale_amount": sale_data[3],
# "order_date": sale_data[4]
# }
# )
# return sales_summary
#