import pymysql

from .db import create_connection, get_cursor

def get_sorted_users(db_cursor, sort_by_column: str, order: str) -> list[dict]:
    """
    Haal gesorteerde gebruikersdata uit die databasis.

    Args:
        db_cursor: 'n geldige pymysql databasiskursusobjek.
        sort_by_column: Die databasis kolomnaam wat vir sortering gebruik word.
        order: Die sorteer volgorde, wat óf 'ASC' óf 'DESC' moet wees.

    Returns:
        'n lys van woordeboeke wat gebruikersinligting bevat, gesorteer volgens die gespesifiseerde reëls.
    """
    query = f"SELECT * FROM users ORDER BY {sort_by_column} {order}"
    db_cursor.execute(query)
    sorted_users = db_cursor.fetchall()
    return sorted_users