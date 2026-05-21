try:
       db_cursor.execute(query)
       results = db_cursor.fetchall()
       return results
   except pymysql.MySQLError as e:
       raise RuntimeError(f"Iphutha ngesikhathi sokufaka umbuzo: {e}")