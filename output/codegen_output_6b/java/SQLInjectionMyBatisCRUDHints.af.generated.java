JDBC">
                <property name="driverType">org.gjt.mm.mysql.Driver</property>
                <property name="user">root</property>
                <property name="password">root</property>
                <property name="url">jdbc:mysql://localhost:3306/dao_test</property>
            </transactionManager>
        </environment>
    </environments>
    <typeAliases>
        <typeAlias alias="long" type="java.lang.Integer"/>
    </typeAliases>
</configuration>
```