import pymysql

def get_sorted_users(db_cursor, sort_by_column: str, order: str) -> list[dict]:
    """
    Haal gesorteerde gebruikersdata uit die databasis.

    Args:
        db_cursor: 'n geldige pymysql databasiskursusobjek.
        sort_by_column: Die databasis kolomnaam wat vir sortering gebruik word.
        order: Die sorteer volgorde, wat óf 'ASC' óf 'DESC' moet wees.

    Returns:
        'n lys van woordeboeke terug wat gebruikersinligting bevat, gesorteer volgens die gespesifiseerde reëls.
    """
    # Bou die SQL-opdrag
    query = f"SELECT * FROM users ORDER BY {sort_by_column} {order}"
    
    try:
        # Voer die SQL-opdrag uit
        db_cursor.execute(query)
        
        # Haal die resultate op
        sorted_users = db_cursor.fetchall()
        
        return sorted_users
    except pymysql.MySQLError as e:
        print(f"Fout tydens databasisopdrag: {e}")
        return []

# Voorbeeld van hoe om die funksie te gebruik
if __name__ == "__main__":
    from .db import create_connection, get_cursor
    
    # Skep 'n databasisverbinding
    connection = create_connection('localhost', 'user', 'password', 'database_name')
    
    # Kry 'n kursus
    cursor = get_cursor(connection)
    
    # Kry gesorteerde gebruikers
    sorted_users = get_sorted_users(cursor, 'username', 'ASC')
    
    # Druk die resultate af
    for user in sorted_users:
        print(user)
    
    # Sluit die verbinding
    connection.close()