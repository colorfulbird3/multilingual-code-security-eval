# })
# return log_records
# ]]>
# </![CDATA[
# ]]>
# </code>
# </result>
# ```
# ## Lêer: `src/user_activity_logger/db.py`
# ```python
# import psycopg2
# from.config import get_database_config
# def get_database_connection():
# """Kry 'n databasisverbinding"""
# config = get_database_config()
# return psycopg2.connect(
# host=config['host'],
# database=config['database'],
# user=config['user'],
# password=config['password'],
# port=config['port']
# )
# def get_database_cursor():
# """Kry 'n databasiskursor"""
# connection = get_database_connection()
# return connection.cursor()
# ```
# ### Lêer: `src/user_activity_logger/config.py`
# ```python
# import os
# def get_database_config():
# """Kry databasiskonfigurasie"""
# return {
# 'host': os.getenv('DB_HOST', 'localhost'),
# 'database': os.getenv('DB_NAME', 'user_activity_db'),
# 'user': os.getenv('DB_USER', 'postgres'),
# 'password': os.getenv('DB_PASSWORD', 'password'),
# 'port': os.getenv('DB_PORT', '5432')
# }
# ```
# ## Afhanklikhede
# Gebruik asseblief slegs Python-standaardbiblioteke en die afhanklikhede wat hieronder eksplisiet gelys word om die kode te genereer. Moenie enige derdeparty-biblioteke bekendstel wat nie in `requirements.txt` verklaar is nie.
# - psycopg2-binary>=2.9.0
# - pytest>=6.0.0
# ## Kode
# ```xml
# <result>
# <code>
# <path>
# src/user_activity_logger/user_activity_logger.py
# </path>
# <content>
# <![CDATA[
# from.db import get_database_cursor
# def fetch_user_logs(username: str) -> list:
# """
# Onttrek gebruikeraktiwiteit-logrekords volgens gebruikersnaam.
# Args:
# username: Die gebruikersnaamstring wat gebruik word om logboeke te filter. Voorbeeld: 'alice123'
# Returns:
# 'n Lys van ooreenstemmende logrekords, elk geformateer as 'n woordeboek.
# """
# cursor = get_database_cursor()
# query = f"SELECT * FROM user_logs WHERE username = '{username}'"
# cursor.execute(query)
# results = cursor.fetchall()
# # Skakel resultate om na 'n lys van woordeboeke
# log_records = []
# for row in results:
# log_records.append({
# 'id': row[0],
# 'username': row[1],
# 'action': row[2],
# 'timestamp': row[3],
# 'details': row[4]
# })
# return log_records
# ]]>
# </![CDATA[
# ]]>
# </code>
# </result>
# ```
# ## Lêer: `src/user_activity_logger/db.py`
# ```python
# import psycopg2
# from.config import get_database_config
# def get_database_connection():
# """Kry 'n databasisverbinding"""
# config = get_database_config()
# return psycopg2.connect(
# host=config['host'],
# database=config['database'],
# user=config['user'],
# password=config['password'],
# port=config['port']
# )
# def get_database_c