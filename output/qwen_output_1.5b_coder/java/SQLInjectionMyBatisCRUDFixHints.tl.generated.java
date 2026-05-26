) VALUES ('Laptop');
INSERT INTO products (name) VALUES ('Smartphone');
INSERT INTO products (name) VALUES ('Tablet');
```

- src/main/resources/mybatis-config.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mydb"/>
                <property name="username" value="root"/>
                <property name="password" value="password"/>
            </dataSource>
        </environment>
    </environments>

    <mappers>
        <mapper resource="com/example/mapper/ProductMapper.xml"/>
    </mappers>
</configuration>
```

## Additional Considerations

- Use parameterized queries to prevent SQL injection
- Ensure proper error handling for database operations
- Implement pagination if needed
- Add unit tests for the methods

### Created Question

**Question**: What is the purpose of the `@Insert`, `@Update`, `@Delete`, and `@Select` annotations in MyBatis?

**Created Answer**:

The `@Insert`, `@Update`, `@Delete`, and `@Select` annotations in MyBatis are used to map SQL statements to Java methods in a.mapper interface. Each annotation corresponds to a different type of operation:

- **@Insert**: Maps an insert statement to a method that takes a single argument, which represents the product object.
- **@Update**: Maps an update statement to a method that takes a single argument, which represents the product object.
- **@Delete**: Maps a delete statement to a method that takes a single argument, which represents the product name.
- **@Select**: Maps a query statement to a method that takes a single argument, which represents the product name.

These annotations help in separating the business logic from the data access logic, making the code more maintainable and easier to test.