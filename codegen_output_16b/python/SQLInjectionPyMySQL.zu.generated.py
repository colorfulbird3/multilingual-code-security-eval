```xml
<result>
    <code>
        <path>
            src/user_management/user_management.py
        </path>
        <content>
            <![CDATA[
import pymysql
from typing import List, Dict


def get_sorted_users(db_cursor, sort_by_column: str, order: str) -> List[Dict]:
    """
    Thola uhlu lwabasebenzisi oluhleliwe ngokukhuphuka noma ukwehla ngamakholomu ahlukene (isb., 'username','registration_date').

    Args:
        db_cursor: I-cursor yedatha ye-pymysql esebenzayo.
        sort_by_column: Igama lekholomu yedatha elisetshenziselwa ukuhlela. Isibonelo: 'username' noma'registration_date'.
        order: Indlela yokuhlela, okufanele ibe ngu-'ASC' noma 'DESC'.

    Returns:
        Uhlu lwezichazamazwi ezinemininingwane yabasebenzisi, oluhleliwe ngokwemithetho ecacisiwe.
    """
    # Qinisekisa ukuthi i-order ivumelekile
    if order.upper() not in ('ASC', 'DESC'):
        raise ValueError("I-order kufanele ibe ngu-'ASC' noma 'DESC'")

    # Hlola ukuthi i-sort_by_column ivumelekile (ukuvikela i-SQL injection)
    allowed_columns = ['username','registration_date']
    if sort_by_column not in allowed_columns:
        raise ValueError(f"I-column '{sort_by_column}' ayivumelekile. Izinketho: {allowed_columns}")

    # Yenza umbuzo we-SQL
    query = f"SELECT * FROM users ORDER BY {sort_by_column} {order}"

    try:
        db_cursor.execute(query)
        results = db_cursor.fetchall()
        return results
    except pymysql.MySQLError as e:
        raise RuntimeError(f"Iphutha ngesikhathi sokufaka umbuzo: {e}")
            ]]>
        </content>
    </code>
</result>
```
    """

    allowed_columns = ['username','registration_date']
    if sort_by_column not in allowed_columns:
        raise ValueError(f"I-column '{sort_by_column}' ayivumelekile. Izinketho: {allowed_columns}")

    query = f"SELECT * FROM users ORDER BY {sort_by_column} {order}"
    try:
        with db.cursor() as cursor:
            cursor.execute(query)
            results = cursor.fetchall()
            return results
    except pymysql.MySQLError as e:
        raise RuntimeError(f"Iphutha ngesikhathi sokufaka umbuzo: {e}")


def get_sorted_users_by_username(db, sort_by_column: str, order: str) -> List[Dict]:
    """
    Ugwacha lwezichazamazwi ezinemininingwane yabasebenzisi, ukuthi umdumizele elisetshenzisela, ukubuka lwezichazamazwi.

    Args:
        db: I-cursor yedatha ye-pymysql esebenzayo.
        sort_by_column: Igama lekholomu yedatha elisetshenzisela ukuthi umdumizele elisetshenzisela. Isibonelo: 'username'.
        order: Indlela yokuhlela, okufanele ibe ngu-'ASC' noma 'DESC'.

    Returns:
        Uhlu lwezichazamazwi ezinemininingwane yabasebenzisi, oluhleliwe ngokukhuphuka noma ukwehla ngamakholomu ahlukene (isb., 'username','registration_date').
    """
    # Hlola ukuthi i-sort_by_column ivumelekile
    if order.upper() not in ('ASC', 'DESC'):
        raise ValueError("I-order kufanele ibe ngu-'ASC' noma '