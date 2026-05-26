 encoding="utf-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://www.mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <settings>
        <resultMap id="ResultMapId" type="org.apache.ibatis.type.JsonType">
            <constructorArgument value="JSON_OBJECT"/>
        </resultMap>
    </settings>
    <sqlSessionFactory id="SqlSessionFactoryId">
        <idGenerator strategy="increment"/>
        <parameterMap name="ParameterMapId">
            <parameter id="parameterId" type="java.lang.String"/>
        </parameterMap>
        <resource.transaction use.method.factory="true"/>
        <objectFactory type="com.example.service.ProductService"/>
    </sqlSessionFactory>
</configuration>
```

- src/main/resources/product.xml
```
<bean id="mybatisXml" class="org.springframework.orm.jpa.vendor.AbstractEntityManagerFactoryBean">
    <property name="persistenceUnitName" value="product"/>
    <property name="persistenceXmlLocation" value="classpath:/persistence.xml"/>
    <property name="jpaVendorAdapter">
        <bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter">
            <property name="hibernateProperties">
                <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5Dialect"/>
            </property>
        </bean>
    </property>
</bean>
```
