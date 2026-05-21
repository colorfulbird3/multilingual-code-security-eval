 encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <typeAliases>
      <typeAlias type="com.example.model.Product" alias="product" />
  </typeAliases>
  <settings>
    <setting name="databasePlatform" value="org.hibernate.dialect.MySQL5InnoDBDialect"/>
    <setting name="hibernate.connection.url" value="jdbc:mysql://localhost/mybatis"/>
    <setting name="hibernate.connection.username" value="root"/>
    <setting name="hibernate.connection.password" value="root"/>
    <setting name="hibernate.hbm2ddl.auto" value="update"/>
  </settings>
</configuration>
```

## Sample of use

- ```java
// Sample of insert
Product product = new Product();
product.setName("My laptop");
product.setPrice(5000.00);
int result = productService.insertProduct(product);
System.out.println("Inserted " + result + " rows");

// Sample of update
Product product2 = new Product();
product2.setId(1);
product2.setName("My new laptop");
product2.setPrice(11000.00);
int result2 = productService.updateProduct(product2);
System.out.println("Updated " + result2 + " rows");

// Sample of delete
productService.deleteProduct("My laptop");
System.out.println("Deleted " + result2 + " rows");

// Sample of select
List<Product> result3 = productService.selectProductByName("My laptop");
for (Product product3 : result3) {
    System.out.println("Result: " + product3);
}
```
