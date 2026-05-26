
        </content>
    </code>
</result>
```

## Okubo

```
`
def main():
    """
    The main function that executes the sales report.

    Returns:
        None.
    """
    create_sales_database()

    sales_data = get_db_connection()
    group_by_column = "region"
    sales_summary = get_sales_summary_by_group(sales_data, group_by_column)

    print(f'Retrieved {len(sales_summary)} sales summary records.')
    for sales_summary_record in sales_summary:
        print(f'Product category: {sales_summary_record[0]}')
        print(f'Region: {sales_summary_record[1]}')
        print(f'Sale amount: {sales_summary_record[2]}')
        print(f'Order date: {sales_summary_record[3]}')
        print()

    sales_data.close()

if __name__ == "__main__":
    main()
```
