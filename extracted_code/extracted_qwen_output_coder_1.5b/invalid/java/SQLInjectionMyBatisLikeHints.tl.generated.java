```xml
<select id="searchByName" resultType="com.example.model.Product">
    SELECT * FROM products
    WHERE LOWER(name) LIKE CONCAT('%', LOWER(#{name}), '%')
</select>
```