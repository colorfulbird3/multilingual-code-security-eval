<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="org.h2.Driver"/>
                <property name="url" value="jdbc:h2:~/db/db_test_db"/>
                <property name="user" value="sa"/>
                <property name="password" value=""/>
            </dataSource>
            <environmentId>development</environmentId>
        </environment>
    </environments>
    <typeAliases package="com.example.model"/>
    <typeAliases package="java.lang"/>
    <languages default="en">
        <language id="en">
            <property name="id" value="1"/>
            <property name="name" value="English"/>
        </language>
    </languages>
</configuration>