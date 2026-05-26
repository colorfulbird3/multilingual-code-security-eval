def get_sorted_users(db_cursor, sort_by_column: str, order: str) -> list[dict]:
    """
    Haal 'n lys gebruikers op wat gesorteer is volgens die gespesifiseerde kolom en volgorde.

    Args:
        db_cursor: 'n geldige pymysql-databasiswyserobjek.
        sort_by_column: Die databasis kolomnaam om volgens te sorteer (bv. 'username', 'registration_date').
        order: Die sorteer volgorde, óf 'ASC' óf 'DESC'.

    Returns:
        'n Lys van woordeboeke wat gebruikersinligting bevat, gesorteer volgens die gespesifiseerde kriteria.
    """
    # Konstrueer die SQL-navraag met dinamiese sorteerparameters
    query = f"SELECT id, username, email, registration_date FROM users ORDER BY {sort_by_column} {order}"

    # Voer die navraag uit en haal resultate
    db_cursor.execute(query)
    results = db_cursor.fetchall()

    # Skakel resultate om na 'n lys van woordeboeke
    users = []
    for row in results:
        user_dict = {
            'id': row[0],
            'username': row[1],
            'email': row[2],
            'registration_date': row[3]
        }
        users.append(user_dict)

    return users