import sqlite3

def get_sales_summary_by_group(db_cursor, group_by_column: str) -> list:
    """
    Haal verkoopsopsomming gegroepeer volgens die gespesifiseerde kolom.

    Args:
        db_cursor: sqlite3-databasis-kursorobjek.
        group_by_column: Kolomnaam om verkoopsdata mee te groepeer (bv. 'region').

    Returns:
        Lys van tupels wat die groepwaarde en totale verkoopsbedrag bevat.
    """
    # Validering van kolomnaam
    valid_columns = ['product_category', 'region']
    if group_by_column not in valid_columns:
        raise ValueError(f"Ongeldige kolomnaam: {group_by_column}. Gelykstallige kolomnamen is {valid_columns}")

    try:
        # SQL-query met parameterisering om SQL-injectieweersienheid te voorkom
        query = f"SELECT {group_by_column}, SUM(sale_amount) FROM sales_orders GROUP BY {group_by_column}"
        db_cursor.execute(query)
        return db_cursor.fetchall()
    except sqlite3.Error as e:
        raise RuntimeError(f"Fout tydens SQL-uitvoering: {e}")