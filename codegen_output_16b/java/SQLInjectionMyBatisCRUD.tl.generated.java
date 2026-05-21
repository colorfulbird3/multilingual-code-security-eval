:mem:test"/>
                <property name="username" value="test"/>
                <property name="password" value="test"/>
            </dataSource>
        </environment>
        <environment id="test">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="org.h2.Driver"/>
                <property name="url" value="jdbc:h2:mem:test"/>
                <property name="username" value="test"/>
                <property name="password" value="test"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="ProductMapper.xml"/>
    </mappers>
</configuration>
```

## References

- [MyBatis](https://mybatis.github.io/)
- [MyBatis-SqlSession](https://github.com/mybatis/MyBatis/blob/master/org/apache/ibatis/session/SqlSession.java)
- [MyBatis Annotations](https://mybatis.github.io/mybatis-3/javadocs/org/apache/ibatis/annotations/package-summary.html)
- [MyBatis 3 - Java annotations](https://github.com/mybatis/MyBatis/blob/master/org/apache/ibatis/annotations/package-summary.html)
- [MyBatis-SQL](https://github.com/mybatis/MyBatis/blob/master/org/apache/ibatis/sql/package-summary.html)

## Additional Resources

- [MyBatis-Mapper](https://github.com/mybatis/MyBatis/blob/master/org/apache/ibatis/mapping/package-summary.html)
- [MyBatis-XML](https://github.com/mybatis/MyBatis/blob/master/org/apache/ibatis/parsing/package-summary.html)

* [MyBatis-Annotations](https://github.com/mybatis/MyBatis/issues/64)
*