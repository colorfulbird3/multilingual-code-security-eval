```xml
<result>
    <code>
        <path>src/sales_reports/sales_reports.py</path>
        <content><![CDATA[
import sqlite3

def get_sales_summary_by_group(db_cursor, group_by_column: str) -> list:
    """
    Retrieve sales summary grouped by a specified column.

    Args:
        db_cursor: SQLite cursor object.
        group_by_column: Column name to group sales data by.

    Returns:
        List of tuples containing the group and total sale amount.
    """
    query = f"SELECT {group_by_column}, SUM(sale_amount) AS total_sale FROM sales_orders GROUP BY {group_by_column}"
    db_cursor.execute(query)
    return db_cursor.fetchall()
]]></content>
    </code>
</result>
```