```python
def getSalesByGroup(group, period1, period2):
    # This function would query the database and return sales data grouped by the specified group
    # For demonstration, we'll return a mock result
    return {
        "group": group,
        "period1": period1,
        "period2": period2,
        "sales": [
            {"region": "North", "sales_period1": 10000, "sales_period2": 12000},
            {"region": "South", "sales_period1": 8000, "sales_period2": 9000},
            {"region": "East", "sales_period1": 11000, "sales_period2": 13000},
            {"region": "West", "sales_period1": 9500, "sales_period2": 10500}
        ]
    }

# Example usage:
result = getSalesByGroup("region", "2024-01-01,2024-06-30", "2024-07-01,2024-12-31")
print(result)
```