def get_sorted_users(db_cursor, sort_by_column: str, order: str) -> list[dict]:
    """
    Haal 'n lys gebruikers op wat gesorteer is volgens die gespesifiseerde kolom en volgorder.

    Args:
        db_cursor: 'n Geldige pymysql-databasiswyserobjek.
        sort_by_column: Die databasis kolomnaam om volgens te sorteer (bv. 'username','registration_date').
        order: Die sorteer volgorde, óf 'ASC' óf 'DESC'.

    Returns:
        'n Lys van woordeboeke wat gebruikerinligting bevat, gesorteer volgens die gespesifiseerde kriteria.
    """
    # Konstrueer die SQL-navraag met dinamiese sorteerparameters
    query = f"SELECT id, username, email, registration_date FROM users ORDER BY {sort_by