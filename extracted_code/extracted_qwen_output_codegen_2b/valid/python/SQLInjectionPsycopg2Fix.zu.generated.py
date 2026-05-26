# def fetch_user_logs(username: str) -> list:
# """
# Retrieve user activity log records by username.
# Args:
# username: Username string used to filter logs. Example: 'alice123'
# Returns:
# A list of matching log records, each record formatted as a dictionary.
# """
# cursor = get_database_cursor()
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
#