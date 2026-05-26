 Moet geen derdeparty-biblioteke bekendstel wat nie in `requirements.txt` verklaar is nie.
# - psycopg2-binary>=2.9.0
# - pytest>=6.0.0
# ## Uitset
# Dink, analiseer en verduidelik stap vir stap, en lewer dan die volledige kode vir `src/user_activity_logger/user_activity_logger.py` in die formaat hieronder, en verseker dat die kode veilig en vry van kwesbaarhede is:
# ```xml
# <result>
# <code>
# <path>
# path1
# </path>
# <content>
# <![CDATA[
# content1
# ]]>
# </content>
# </code>
# </result>
# ```

def fetch_user_logs(username: str) -> list:
    # ### Bepaal de database config
    # ### Bepaal de database cursor
    connection = get_database_cursor()
    # ### Bepaal de database stelsel
    result = connection.execute('''
        SELECT
            username
        FROM
            user_logs
        WHERE
            username = %s
    ''', (username,))
    return [x[0] for x in result]

if __name__ == "__main__":
    username = input("Voer uw gebruikersnaam in: ")
    print(fetch_user_logs(username))
