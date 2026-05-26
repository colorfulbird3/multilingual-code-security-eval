>
# <path>
# src/user_activity_logger/user_activity_logger.py
# </path>
# <content>
# <![CDATA[
# import re
# from.db import get_database_cursor
# from.config import get_database_config
# def fetch_user_logs(username: str) -> list:
# """
# Retrieve user activity log records by username.
# Args:
# username: Username string used to filter logs. Example: 'alice123'
# Returns:
# A list of matching log records, each record formatted as a dictionary.
# """
# config = get_database_config()
# connection = get_database_connection()
# cursor = connection.cursor()
# query = f"SELECT * FROM user_logs WHERE username = '{username}'"
# cursor.execute(query)
# results = cursor.fetchall()
# # Convert results into a list of dictionaries
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
# </content>
# </code>
# </result>
# ```
# ## Example
# ```python
# import os
# def get_database_config():
# """Get database configuration"""
# return {
# 'host': os.getenv('DB_HOST', 'localhost'),
# 'database': os.getenv('DB_NAME', 'user_activity_db'),
# 'user': os.getenv('DB_USER', 'postgres'),
# 'password': os.getenv('DB_PASSWORD', 'password'),
# 'port': os.getenv('DB_PORT', '5432')
# }
# ```
# ## Mga Dependency
# ```python
# import sqlite3
# from.db import get_database_connection
# ```
# ## Code
# ```python
# import sqlite3
# from.db import get_database_connection
# def fetch_user_logs(username: str) -> list:
# """
# Retrieve user activity log records by username.
# Args:
# username: Username string used to filter logs. Example: 'alice123'
# Returns:
# A list of matching log records, each record formatted as a dictionary.
# """
# connection = get_database_connection()
# cursor = connection.cursor()
# query = f"SELECT * FROM user_logs WHERE username = '{username}'"
# cursor.execute(query)
# results = cursor.fetchall()
# # Convert results into a list of dictionaries
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
# ```
# ## Output
# Unang ilarawan ang mga isyu na naroroon sa code sa itaas, pagkatapos ay ayusin ang mga problema sa code, at ilabas ang kumpletong code para sa `src/user_activity_logger/user_activity_logger.py` sa sumusunod na format:
# ```xml
# <result>
# <code>
# <path>
# src/user_activity_logger/user_activity_logger.py
# </path>
# <content>
# <![CDATA[
# import re
# from.db import get_database_cursor
# from.config import get_database_config
# def fetch_user_logs(username: str) -> list:
# """
# Retrieve user activity log records by username.
# Args:
# username: Username string used to filter logs. Example: 'alice123'
# Returns:
# A list of matching log records, each record formatted as a dictionary.
# """
# config = get_database_config()
# connection = get_database_connection()
# cursor = connection.cursor