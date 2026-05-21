Cursor, group_by_column: str) -> List[Tuple[str, float]]:
    """
    Groepeer verkooporders volgens die gespesifiseerde dimensie en bereken die totale verkoopbedrag vir elke groep.

    Args:
        db_cursor: Cursor object from an sqlite3 database connection.
        group_by_column: The column name selected by the user for grouping. For example:'region'

    Returns:
        'n lys van verkoopopsommings gegroepeer volgens die gespesifiseerde dimensie, waar elke item die groeperingsleutel en die totale verkoopbedrag bevat.
    """
    # Valideer dat die kolomnaam veilig is om SQL-inspuiting te voorkom
    veilige_kolomme = ['product_category','region']
    if group_by_column not in veilige_kolomme:
        raise ValueError(f"Ongeldige groeperingskolom: {group_by_column}. Toegelate kolomme: {veilige_kolomme}")

    # Voer die GROUP BY navraag uit
    db_cursor.execute(f"""
        SELECT {group_by_column}, SUM(sale_amount) as total_sales
        FROM sales_orders
        GROUP BY {group_by_column}
        ORDER BY total_sales DESC
    """)

    # Haal resultate op en keer terug as 'n lys van tupels
    resultate = db_cursor.fetchall()
    return resultate
]]>
        </content>
    </code>
</result>
```
"""
    )

    return mark_safe(
        f"""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Sales Reports</title>
    <style type="text/css">
        body {
            background-color: #F5F5F5;
            font: 13px/20px "Helvetica Neue", "Lucida Grande", Verdana, Arial, Helvetica, sans-serif;
        }
    </style>
</head>
<body>
<h2>Sales Reports</h2>
{result}
</body>
</html>
"""
    )


def get_sales_report_for_groupby_column(db_cursor: sqlite3.Cursor, group_by_column: str) -> str:
    """
    Haal verkoopopsomming op en voer terug resultaat uit
    """
    # Valideer dat die kolomnaam veilig is om SQL-inspuiting te voorkom
    veilige_kolomme = ['product_category','region']
    if group_by_column not in veilige_kolomme:
        raise ValueError(f"Ongeldige groeperingskolom: {group_by_column}. Toegelate kolomme: {veilige_kolomme}")

    # Voer die GROUP BY navraag uit
    db_cursor.execute(f"""
        SELECT {group_by_column}, SUM(sale_amount) as total_sales
        FROM sales_orders
        GROUP BY {group_by_column}
        ORDER BY total_sales DESC
    """)

    # Haal resultate op en keer terug as 'n lys van tupels
    resultate = db_cursor.fetchall()
    return mark_safe(
        f"""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Sales Reports</title>
    <style type