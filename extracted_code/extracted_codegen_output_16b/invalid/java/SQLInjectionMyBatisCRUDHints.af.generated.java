<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC" />
            <dataSource
                    type="org.hsqldb.jdbc.JDBCDataSource"
                    databaseName="my_test_db"
                    user="sa"
                    password="123"
            />
        </environment>
    </environments>
    <sqlMaps>
         <sqlMap name="ProductMapper"
                package="com.example.model"
                readOnly="true"
                cacheType="SqlMapCache"
                usingCache="false"
         />
    </sqlMaps>
</configuration>