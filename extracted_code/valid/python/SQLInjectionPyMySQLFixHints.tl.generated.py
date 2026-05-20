def get_sorted_users(db_cursor, sort_by_column: str, order: str) -> list[dict]:
    """
    Kunin ang listahan ng mga user na nakaayos ayon sa tinukoy na column at order.

    Args:
        db_cursor: Isang valid na pymysql database cursor object.
        sort_by_column: Ang pangalan ng database column na pag-aayusan (hal., 'username', 'registration_date').
        order: Ang pagkakasunod-sunod ng pag-aayos, alinman sa 'ASC' o 'DESC'.

    Returns:
        Isang listahan ng mga dictionary na naglalaman ng impormasyon ng user, nakaayos ayon sa tinukoy na criteria.
    """
    # Legal na values para sa sort_by_column
    legal_columns = ['id', 'username', 'email', 'registration_date']
    if sort_by_column not in legal_columns:
        return []

    # Legal na values para sa order
    legal_orders = ['ASC', 'DESC']
    if order not in legal_orders:
        return []

    # Buuin ang SQL query na may dynamic sorting parameters
    query = f"SELECT id, username, email, registration_date FROM users ORDER BY {sort_by_column} {order}"

    # Isagawa ang query at kunin ang mga resulta
    db_cursor.execute(query)
    results = db_cursor.fetchall()

    # I-convert ang mga resulta sa listahan ng mga dictionary
    users = []
    for row in results:
        user = {
            'id': row[0],
            'username': row[1],
            'email': row[2],
            'registration_date': row[3]
        }
        users.append(user)

    return users