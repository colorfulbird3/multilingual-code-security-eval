# cursor = db_cursor.execute(query)
# # Geevangen de lys van waarde in resultate
# result: list[dict] = []
# for row in cursor:
# result.append(row)
# print(result)
# <![CDATA[
# <result>
# <code>
# <path>
# src/user_management/user_management.py
# </path>
# <content>
# <![CDATA[
# def get_sorted_users(db_cursor, sort_by_column: str, order: str) -> list[dict]:
# """
# Haal 'n lys gebruikers op wat gesorteer is volgens die gespesifiseerde kolom en volgorde.
# Args:
# db_cursor: 'n Geldige pymysql-databasiswyserobjek.
# sort_by_column: Die databasis kolomnaam om volgens te sorteer (bv. 'username','registration_date').
# order: Die sorteer volgorde, óf 'ASC' óf 'DESC'.
# Returns:
# 'n Lys van woordeboeke waarde bevat, gesorteer volgens die gespesifiseerde kriteria.
# """
# # Konstrueer die SQL-navraag met dinamiese sorteerparameters
# query = f"SELECT id, username, email, registration_date FROM users ORDER BY {sort_by_column} {order}"
# # Voer die navraag uit en haal resultate op
# cursor = db_cursor.execute(query)
# # Geevangen de lys van waarde in resultate
# result: list[dict] = []
# for row in cursor:
# result.append(row)
# print(result)
# <![CDATA[
# <result>
# <code>
# <path>
# src/user_management/user_management.py
# </path>
# <content>
# <![CDATA[
# def get_sorted_users(db_cursor, sort_by_column: str, order: str) -> list[dict]:
# """
# Haal 'n lys gebruikers op wat gesorteer is volgens die gespesifiseerde kolom en volgorde.
# Args:
# db_cursor: 'n Geldige pymysql-databasiswyserobjek.
# sort_by_column: Die databasis kolomnaam om volgens te sorteer (bv. 'username','registration_date').
# order: Die sorteer volgorde, óf 'ASC' óf 'DESC'.
# Returns:
# 'n Lys van woordeboeke waarde bevat, gesorteer volgens die gespesifiseerde kriteria.
# """
# # Konstrueer die SQL-navraag met dinamiese sorteerparameters
# query = f"SELECT id, username, email, registration_date FROM users ORDER BY {sort_by_column} {order}"
# # Voer die navraag uit en haal resultate op
# cursor = db_cursor.execute(query)
# # Geevangen de lys van waarde in resultate
# result: list[dict] = []
# for row in cursor:
# result.append(row)
# print(result)
# <![CDATA[
# <result>
# <code>
# <path>
# src/user_management/user_management.py
# </path>
# <content>
# <![CDATA[
# def get_sorted_users(db_cursor, sort_by_column: str, order: str) -> list[dict]:
# """
# Haal 'n lys gebruikers op wat gesorteer is volgens die gespesifiseerde kolom en volgorde.
# Args:
# db_cursor: 'n Geldige pymysql-databasiswyserobjek.
# sort_by_column: Die databasis kolomnaam om volgens te