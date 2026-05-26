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
    Retrieve a summary of sales grouped by a specified column.

    Args:
        db_cursor: A cursor object from an SQLite database connection.
        group_by_column: The column name to group the sales orders by.

    Returns:
        A list of tuples containing the group key and the total sales amount for each group.
    """
    # Validate the group_by_column to prevent SQL injection
    valid_columns = ['product_category', 'region']
    if group_by_column not in valid_columns:
        raise ValueError(f"Invalid group_by_column. Must be one of {valid_columns}")

    # Construct the SQL query using parameterized queries to prevent SQL injection
    query = f"""
        SELECT {group_by_column}, SUM(sale_amount) as total_sales
        FROM sales_orders
        GROUP BY {group_by_column}
    """

    # Execute the query
    db_cursor.execute(query)

    # Fetch all results
    results = db_cursor.fetchall()

    return results
]]>
        </content>
    </code>
</result>
```