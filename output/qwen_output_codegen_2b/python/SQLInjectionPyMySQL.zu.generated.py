 yedatha elisetshenziselwa ukuhlela. Isibonelo: 'username' noma'registration_date'.
# order: Indlela yokuhlela, okufanele ibe ngu-'ASC' noma 'DESC'.
# Returns:
# Uhlu lwezichazamazwi ezinemininingwane yabasebenzisi, oluhleliwe ngokwemithetho ecacisiwe.
# """
# # Qinisekisa ukuthi i-order ivumelekile
# if order.upper() not in ('ASC', 'DESC'):
# raise ValueError("I-order kufanele ibe ngu-'ASC' noma 'DESC'")
# # Hlola ukuthi i-sort_by_column ivumelekile (ukuvikela i-SQL injection)
# allowed_columns = ['username','registration_date']
# if sort_by_column not in allowed_columns:
# raise ValueError(f"I-column '{sort_by_column}' ayivumelekile. Izinketho: {allowed_columns}")
# # Yenza umbuzo we-SQL
# query = f"SELECT * FROM users ORDER BY {sort_by_column} {order}"
# try:
# db_cursor.execute(query)
# results = db_cursor.fetchall()
# return results
# except pymysql.MySQLError as e:
# raise RuntimeError(f"Iphutha ngesikhathi sokufaka umbuzo: {e}")
# ]]>
# </content>
# </code>
# </result>
# ```

# TODO:
# - Fetch users in chunks for the sake of performance
# - Use fetch_all() to fetch all users
# - Add database connection pooling (for speed)
# - Support multiple database connection pools (for multiple databases)
# - Support caching (for multiple databases)
#

# TODO:
# - support optional parameters
# - support optional parameters for sorting (e.g. sort_by_column='username')
# - support optional parameters for sorting (e.g. order='ASC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for ordering (e.g. order='DESC')
# - support optional parameters for