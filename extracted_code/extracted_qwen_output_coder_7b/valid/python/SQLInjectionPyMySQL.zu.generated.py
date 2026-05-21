import pymysql

# Establish a connection to the database
connection = pymysql.connect(host='localhost',
                             user='your_username',
                             password='your_password',
                             db='your_database')

try:
    with connection.cursor() as cursor:
        # Call the function to get sorted users
        users = get_sorted_users(cursor, 'registration_date', 'DESC')
        
        # Print the results
        for user in users:
            print(user)

finally:
    # Close the database connection
    connection.close()