#tests/test_sales_reports.py
from unittest.mock import patch, Mock
from src.sales_reports import get_db_connection, get_sales_summary_by_group

def test_get_sales_summary_by_group():
    with patch('sqlite3.connect', return_value=Mock()) as mock_conn:
        mock_conn.cursor.return_value.execute.return_value.fetchall.return_value = [('Region A', 4000), ('Region B', 5000)]
        result = get_sales_summary_by_group(mock_conn, 'region')
        
        assert result == [('Region A', 4000), ('Region B', 5000)]

    mock_conn.cursor.return_value.execute.assert_called_once_with("SELECT region, SUM(sale_amount) FROM sales_orders GROUP BY region")