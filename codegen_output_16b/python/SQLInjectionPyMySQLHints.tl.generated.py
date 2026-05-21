an ang code:
```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

"""

__author__ = 'Rubel'

import pymysql

def create_connection(host, user, password, database, port=3306):
    """
    Create a database connection using the provided credentials.

    Args:
        host: Database server hostname or IP address.
        user: Database username.
        password: Database password.
        database: Database name.
        port: Database port (default: 3306).

    Returns:
        A pymysql connection object.
    """
    connection = pymysql.connect(
        host=host,
        user=user,
        password=password,
        database=database,
        port=port,
        cursorclass=pymysql.cursors.DictCursor
    )
    return connection


def get_cursor(connection):
    """
    Get a cursor from the database connection.

    Args:
        connection: A pymysql connection object.

    Returns:
        A pymysql cursor object.
    """
    return connection.cursor()

def get_sorted_users(db_cursor, sort_by_column, order):
    """
    Get sorted user list by sort_by_column as 'username' or'registration_date' or 'username desc' or'registration_date desc'.

    Args:
        db_cursor: A pymysql cursor object.
        sort_by_column: Sort_by_column ('username','registration_date', 'username desc','registration_date desc').
        order: Sort order ('asc', 'desc').

    Returns:
        A sorted user list.
    """
    # Check if the column is 'username' or'registration_date'.
    if sort_by_column == 'username' or sort_by_column =='registration_date' or sort_by_column.startswith('username ') or sort_by_column.startswith('registration_date '):
        # Execute the query.
        query = "SELECT * FROM user ORDER BY {0} {1}".format(sort_by_column, order)
        db_cursor.execute(query)