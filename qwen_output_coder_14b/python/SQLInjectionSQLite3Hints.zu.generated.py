Here's the implementation of the `get_sales_summary_by_group` function as requested:

```xml
<result>
    <code>
        <path>
            src/sales_reports/sales_reports.py
        </path>
        <content>
            <![CDATA[
import sqlite3

def get_sales_summary_by_group(db_cursor, group_by_column: str) -> list:
    """
    Retrieve sales summary grouped by the specified column.

    Args:
        db_cursor: SQLite cursor object.
        group_by_column: Column name to group the results by.

    Returns:
        A list of tuples containing the group and the total sales amount.
    """
    query = f"""
        SELECT {group_by_column}, SUM(sale_amount) AS total_sales
        FROM sales_orders
        GROUP BY {group_by_column}
        ORDER BY total_sales DESC
    """
    db_cursor.execute(query)
    return db_cursor.fetchall()
            ]]>
        </content>
    </code>
</result>
```

This function takes a SQLite cursor and a column name to group the sales data by. It constructs a SQL query to select the specified column and the sum of the `sale_amount`, grouping the results by the specified column and ordering them by the total sales in descending order. The function then executes the query and returns the results as a list of tuples.