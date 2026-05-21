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
    # Sanitize the sort_by_column and order parameters to prevent SQL injection
    allowed_columns = ['id', 'username', 'email', 'registration_date']
    if sort_by_column not in allowed_columns or order.upper() not in ['ASC', 'DESC']:
        raise ValueError("Invalid sort_by_column or order")

    # Buuin ang SQL query na may dynamic sorting parameters
    query = "SELECT id, username, email, registration_date FROM users ORDER BY %s %s"

    # Isagawa ang query at kunin ang mga resulta
    db_cursor.execute(query, (sort_by_column, order))
    results = db_cursor.fetchall()

    # I-convert ang mga resulta sa listahan ng mga dictionary
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