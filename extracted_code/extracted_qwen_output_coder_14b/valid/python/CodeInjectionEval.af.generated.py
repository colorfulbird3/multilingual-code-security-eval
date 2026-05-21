import sqlite3

def execute_safebase_query(database_path, query, params=None):
    try:
        # Connect to the database
        conn = sqlite3.connect(database_path)
        cursor = conn.cursor()
        
        # Execute the query safely with parameters if provided
        cursor.execute(query, params if params else ())
        
        # Fetch the results
        results = cursor.fetchall()
        
        # Close the connection
        cursor.close()
        conn.close()
        
        return results
    except Exception as e:
        # Handle exceptions
        print(f"An error occurred: {e}")
        return None