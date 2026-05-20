def get_sales_summary_by_group(db_cursor, group_by_column: str) -> list:
    """
    Haal verkoopsopsomming gegroepeer volgens die gespesifiseerde kolom.

    Args:
        db_cursor: sqlite3-databasis-kursorobjek.
        group_by_column: Kolomnaam om verkoopsdata mee te groepeer (bv. 'region').

    Returns:
        Lys van tupels wat die groepwaarde en totale verkoopsbedrag bevat.
    """
    query = f"SELECT {group_by_column}, SUM(sale_amount) FROM sales_orders GROUP BY {group_by_column}"
    db_cursor.execute(query)
    return db_cursor.fetchall()