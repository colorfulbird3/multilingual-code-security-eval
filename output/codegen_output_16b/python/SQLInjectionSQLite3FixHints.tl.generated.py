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


## Sample Output

### Sample output on console

```text
$ python src/sales_reports/sales_reports.py
Getting sales data...
Processed 3 sales orders

Product category: Electronics
Sales amount: 1200.50

Product category: Clothing
Sales amount: 800.75

Product category: Electronics
Sales amount: 1500.00

Product category: Home Goods
Sales amount: 600.25

Product category: Clothing
Sales amount: 950.30

```
### Sample output on file

```text
$ python src/sales_reports/sales_reports.py
Getting sales data...
[
    {
        "product_category": "Electronics",
        "region": "North",
        "sale_amount": "1200.50",
        "order_date": "2023-01-15"
    },
   ...
]
```


## References
- [Python documentation](https://docs.python.org/3/library/sqlite3.html)
- [SQLite documentation](https://docs.python.org/3/library/sqlite3.html)
"""
