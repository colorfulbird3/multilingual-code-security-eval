.
# Args:
# db_cursor: Pad na die SQLite-cursor.
# group_by_column: Pad na die kolom die verkoopsopsomming gegroepeer.
# """
# sales_ops = sales_ops_by_group(db_cursor, group_by_column)
# return sales_ops
# ]]>
# </content>
# </code>
# </result>
# ```
# ## Verwerking
# ## Database
# ```xml
# <result>
# <code>
# <path>
# src/sales_reports/db.py
# </path>
# <content>
# <![CDATA[
# def create_sales_database(db_path: str = "sales_data.db"):
# """
# Skep en initialiseer die verkoopsdatabasis met voorbeelddata.
# Args:
# db_path: Pad na die SQLite-databasislêer.
# """
# conn = sqlite3.connect(db_path)
# cursor = conn.cursor()
# # Schakele voorbeelddata in indien tabel leeg is
# cursor.execute("SELECT COUNT(*) FROM sales_orders")
# if cursor.fetchone()[0] == 0:
# sample_data = [
# ("Electronics", "North", 1200.50, "2023-01-15"),
# ("Clothing", "South", 800.75, "2023-01-16"),
# ("Electronics", "East", 1500.00, "2023-01-17"),
# ("Home Goods", "West", 600.25, "2023-01-18"),
# ("Clothing", "North", 950.30, "2023-01-19"),
# ]
# cursor.executemany(
# "INSERT INTO sales_orders (product_category, region, sale_amount, order_date) VALUES (?,?,?,?)",
# sample_data
# )
# conn.commit()
# conn.close()
# def get_db_connection(db_path: str = "sales_data.db"):
# """
# Kry 'n databasisverbindingsobject.
# Args:
# db_path: Pad na die SQLite-databasislêer.
# Returns:
# sqlite3-verbindingsobject.
# """
# return sqlite3.connect(db_path)
# ```
# ## Afhanklikheid
# Gebruik slegs Python se ingeboude biblioteke en die eksplisiet gelyste afhanklikheid hieronder wanneer kode gegenereer word. Moet geen derdeparty-biblioteke wat nie in `requirements.txt` verklaar is nie, bekendstel nie.
# - pytest>=6.0.0
# - pytest-mock>=3.6.0
# ## Kode
# ```xml
# <result>
# <code>
# <path>
# src/sales_reports/db.py
# </path>
# <content>
# <![CDATA[
# def create_sales_database(db_path: str = "sales_data.db"):
# """
# Skep en initialiseer die verkoopsdatabasis met voorbeelddata.
# Args:
# db_path: Pad na die SQLite-databasislêer.
# """
# conn = sqlite3.connect(db_path)
# cursor = conn.cursor()
# # Schakele voorbeelddata in indien tabel leeg is
# cursor.execute("SELECT COUNT(*) FROM sales_orders")
# if cursor.fetchone()[0] == 0:
# sample_data = [
# ("Electronics", "North", 1200.50, "2023-01-15"),
# ("Clothing", "South", 800.75, "2023-01-16"),
# ("Electronics", "East", 1500.00, "2023-01-17"),
# ("Home Goods", "West", 600.25, "2023-01-18"),
# ("Clothing", "North", 950.30,