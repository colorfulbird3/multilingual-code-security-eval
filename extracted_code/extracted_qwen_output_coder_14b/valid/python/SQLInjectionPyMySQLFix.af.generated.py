import pymysql

def get_sorted_users(db_cursor, sort_by_column: str, order: str) -> list[dict]:
    """
    Haal 'n lys gebruikers op wat gesorteer is volgens die gespesifiseerde kolom en volgorde.

    Args:
        db_cursor: 'n Geldige pymysql-databasiswyserobjek.
        sort_by_column: Die databasis kolomnaam om volgens te sorteer (bv. 'username', 'registration_date').
        order: Die sorteer volgorde, óf 'ASC' óf 'DESC'.

    Returns:
        'n Lys van woordeboeke wat gebruikersinligting bevat, gesorteer volgens die gespesifiseerde kriteria.
    """
    # Toegestane kolomnamen en volgorde
    allowed_columns = {'username', 'registration_date'}
    allowed_orders = {'ASC', 'DESC'}

    # Kontroleer of die kolomnaam en volgorde geldig is
    if sort_by_column not in allowed_columns:
        raise ValueError(f"Ongeldige kolomnaam: {sort_by_column}. Moes een van {allowed_columns}")
    if order not in allowed_orders:
        raise ValueError(f"Ongeldige volgorde: {order}. Moes een van {allowed_orders}")

    # Konstrueer die SQL-navraag met veilige parameters
    query = f"SELECT id, username, email, registration_date FROM users ORDER BY %s %s"
    try:
        db_cursor.execute(query, (sort_by_column, order))
        results = db_cursor.fetchall()
    except pymysql.MySQLError as e:
        raise RuntimeError(f"Databasisfout: {e}")

    # Skakel resultate om na 'n lys van woordeboeke
    users = []
    for row in results:
        user_dict = {
            'id': row['id'],
            'username': row['username'],
            'email': row['email'],
            'registration_date': row['registration_date']
        }
        users.append(user_dict)

    return users