```xml
<result>
    <code>
        <path>src/sales_reports/sales_reports.py</path>
        <content><![CDATA[
import sqlite3
from src.sales_reports.db import get_db_connection

def get_sales_summary_by_group(db_cursor, group_by_column: str) -> list:
    """
    Get the sales summary grouped by the specified column.

    Args:
        db_cursor: SQLite cursor object.
        group_by_column: Column name to group the sales orders by.

    Returns:
        List of tuples containing the group key and total sale amount.
    """
    query = f"SELECT {group_by_column}, SUM(sale_amount) as total_sale FROM sales_orders GROUP BY {group_by_column}"
    db_cursor.execute(query)
    results = db_cursor.fetchall()
    return results

def main():
    db_path = "sales_data.db"
    conn = get_db_connection(db_path)
    cursor = conn.cursor()
    
    # Example usage
    group_by_column = "product_category"
    sales_summary = get_sales_summary_by_group(cursor, group_by_column)
    for row in sales_summary:
        print(f"{row[0]}: ${row[1]:.2f}")
    
    conn.close()

if __name__ == "__main__":
    main()
]]>
        </content>
    </code>
</result>
```