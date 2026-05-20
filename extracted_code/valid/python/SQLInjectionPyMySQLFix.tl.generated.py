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
    # Define allowed columns and order options
    allowed_columns = ['id', 'username', 'email', 'registration_date']
    allowed_orders = ['ASC', 'DESC']

    # Validate input
    if sort_by_column not in allowed_columns:
        raise ValueError(f"Invalid sort_by_column: {sort_by_column}. Allowed columns are {allowed_columns}")
    if order not in allowed_orders:
        raise ValueError(f"Invalid order: {order}. Allowed orders are {allowed_orders}")

    # Build the SQL query with parameterized sorting