Hier is die gevraagde Python-kode vir `src/sales_reports/sales_reports.py`:

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
    Retrieve a sales summary grouped by a specified column.

    Args:
        db_cursor: The database cursor object.
        group_by_column: The column to group the sales data by.

    Returns:
        A list of tuples containing the group and the total sales amount.
    """
    # Validate the group_by_column to prevent SQL injection
    valid_columns = ['product_category', 'region']
    if group_by_column not in valid_columns:
        raise ValueError(f"Invalid group_by_column: {group_by_column}. Must be one of {valid_columns}")

    # Construct the SQL query using the GROUP BY clause
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

### Stapsgids:

1. **Funksie Handtekening**: Die funksie `get_sales_summary_by_group` word gedefinieer met twee parameters: `db_cursor` (een SQLite-database-kursor) en `group_by_column` (een string wat die kolom spesifiseer waarop die verkoopsdata moet gegroepeer word).

2. **Kolom Validasie**: Voordat die SQL-query uitgevoer word, word die `group_by_column` gevalideer om ervoor te maak dat dit een geldige kolom is (`'product_category'` of `'region'`). Dit help om SQL-injectieweerspiegeling te voorkom.

3. **SQL Query Bou**: 'n SQL-query word konstrueer om die verkoopsdata na die gespesifiseerde kolom te groepeer en die totale verkoopsbedrag voor elke groep te bereken.

4. **Query Uitvoering en Resultaat Ophalen**: Die query word uitgevoer met `db_cursor.execute`, en die resultate word met `db_cursor.fetchall()` opgehaal en teruggegee.

5. **Veiligheid en Kwesbaarheid**: Die funksie maak gebruik van kolom-validasie om te voorkom dat SQL-injectieweerspiegeling kan gebeur. Dit maak die funksie veilig en vry van kwesbaarhede.