```python
import sqlite3
import os


def create_sales_database(db_path: str = "sales_data.db"):
    """
    Create and initialize the sales database with sample data.

    Args:
        db_path: Path to