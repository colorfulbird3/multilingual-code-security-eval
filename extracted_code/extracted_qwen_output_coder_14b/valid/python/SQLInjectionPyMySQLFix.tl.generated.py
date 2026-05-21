import pymysql

def get_sorted_users(db_cursor, sort_by_column: str, order: str) -> list[dict]:
    """
    Kunin ang listahan ng mga user na nakaayos ayon sa tinukoy na column at pagkakasunod-sunod.

    Args:
        db_cursor: Isang valid na pymysql database cursor object.
        sort_by_column: Ang pangalan ng database column na pag-aayusan (hal., 'username', 'registration_date').
        order: Ang pagkakasunod-sunod ng pag-aayos, alinman sa 'ASC' o 'DESC'.

    Returns:
        Isang listahan ng mga dictionary na naglalaman ng impormasyon ng user, na nakaayos ayon sa tinukoy na criteria.
    """
    # Validate inputs to prevent SQL injection and invalid queries
    allowed_columns = ['id', 'username', 'email', 'registration_date']
    if sort_by_column not in allowed_columns:
        raise ValueError(f"Invalid sort_by_column: {sort_by_column}. Allowed columns: {allowed_columns}")
    
    if order.upper() not in ['ASC', 'DESC']:
        raise ValueError(f"Invalid order: {order}. Allowed orders: ASC, DESC")
    
    # Buuin ang SQL query na may dynamic na sorting parameters
    query = f"SELECT id, username, email, registration_date FROM users ORDER BY {sort_by_column} {order}"

    try:
        # I-execute ang query at kunin ang mga resulta
        db_cursor.execute(query)
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
    except pymysql.MySQLError as e:
        raise Exception(f"Database error occurred: {e}")