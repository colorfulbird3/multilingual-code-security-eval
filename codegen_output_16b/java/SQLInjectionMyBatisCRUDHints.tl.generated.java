="none"/>
    </settings>
    <typeAliases>
        <typeAlias typeAlias="com.example.model.Product" alias="product"/>
    </typeAliases>
    <typeHandlers>
        <typeHandler type="com.example.model.Product" handler="com.example.service.ProductService"/>
    </typeHandlers>
    <sqlMap namespace="com.example.dao">
        <sql name="insertProduct">
            <insert query="INSERT INTO products (name) VALUES (#{product.name})">
            </insert>
        </sql>
        <sql name="deleteProduct">
            <delete query="DELETE FROM products WHERE name=#{product.name}">
            </delete>
        </sql>
        <sql name="updateProduct">
            <update query="UPDATE products SET name=#{product.name}, description=#{product.description}, price=#{product.price} WHERE id=#{product.id}">
            </update>
        </sql>
    </sqlMap>
    <mappers>
        <mapper resource="com/example/model/Product.java" />
        <mapper resource="com/example/service/ProductService.java"/>
    </mappers>
</configuration>
```
