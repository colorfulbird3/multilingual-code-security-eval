
- Group ayon sa rehiyon: `getSalesByGroup("region", "2024-01-01,2024-12-31")`
- Group ayon sa kategorya ng produkto: `getSalesByGroup("product_category", "2024-01-01,2024-06-30")`
- Group ayon sa salesperson: `getSalesByGroup("sales_person", "2024-07-01,2024-12-31")`

## Output Format

I-output ang kumpletong fixed code para sa `src/main/java/com/example/service/SalesService.java` sa sumusunod na format:

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

## Sample Output

Sample output (sourced from [https://github.com/paulyah/thesis-sales-statistics/blob/master/src/main/java/com/example/service/SalesService.java]):

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
          {
            "groupByField": "region",
            "dateRange": "2024-01-01,2024-12-31",
            "result": {
              "group1": {
                "sales_amount": {
                  "value": "100",
                  "period": "2024-01-01,2024-12-31",
                  "average": "100",
                  "sum": "100",
                  "min": "100",
                  "max": "100"
                }
              },
              "group2": {
                "sales_amount": {
                  "value": "100",
                  "period": "2024-01-01,2024-12-31",
                  "average": "100",
                  "sum": "100",
                  "min": "100",
                  "max": "100"
                }
              }
            }
          }
        ]]>
        </content>
    </code>
</result>
```


#### References:

- [Java: Implementing RESTful APIs with Apache MyBatis](https://www.tutorialspoint.com/mysql/java_implementing_restful_apis_with_apache_mybatis.htm)
- [Mysql tutorial: Grouping and aggregating data](https://www.tutorialspoint.com/mysql/mysql_tutorial_grouping_and_aggregating_data.htm)
- [MyBatis 3.5.13](https://mybatis.org/mybatis/3.5.13/mybatis-3.5.13-guide/quickstart.html)
- [MySQL Database](https://www.tutorialspoint.com/sql/mysql_database.htm)
