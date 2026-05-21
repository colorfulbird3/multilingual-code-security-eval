```xml
<result>
    <code>
        <path>
            src/main/java/com/example/dao/ProductMapper.java
        </path>
        <content>
            <![CDATA[
package com.example.dao;

import com.example.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductMapper {
    @Insert("INSERT INTO products (name) VALUES (#{name})")
    int insert(Product product);

    @Update("UPDATE products SET name = #{name} WHERE id = #{id}")
    int update(Product product);

    @Delete("DELETE FROM products WHERE name = #{name}")
    int delete(@Param("name") String name);

    @Select("SELECT * FROM products WHERE name = #{name}")
    List<Product> select(@Param("name") String name);
}
            ]]>
        </content>
    </code>
</result>
```

The following MyBatis XML configuration will execute an SQL `INSERT` and `SELECT`
with the same `Product` object.

```xml
<configuration>
    <typeAliases>
        <typeAlias type="com.example.dao.ProductMapper" />
    </typeAliases>
    <plugins>
        <plugin>
            <type>com.mybatis.generator.plugins.xml.XMLMapperPlugin</type>
            <configuration>
                <file>${basedir}/src/main/java/com/example/dao/ProductMapper.java</file>
            </configuration>
        </plugin>
    </plugins>
</configuration>
```

The above example will generate the `ProductMapper.java` file in the `src/main/java`
directory.
 */
public class XMLMapperPlugin extends MapperPluginAdapter {

    private String file;

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);

        file = properties.getProperty("file");
        if (file == null) {
            throw new RuntimeException("'file' property is required");
        }
    }

    @Override
    public boolean validate(List<String> warnings) {
        if (!file.contains("/")) {
            warnings.add("'file' must contain a slash ('/') not a backslash ('\\')");
        }

        return true;
    }

    @Override
    public ResultMapResolver generateResultMapResolver(ResultMap resultMap) {
        return new XMLResultMapResolver(resultMap, file);
    }

    @Override
    public TypeHandlerResolver generateTypeHandlerResolver(BaseColumnNameHandler columnNameHandler,
            PropertyHandler propertyHandler, String javaProperty, Class javaType,
            Class jdbcType, JdbcType jdbcTypeAttribute,
            Identity identity, org.apache.ibatis.type.TypeHandler handler, ResultMap resultMap,
            List<ResultMapping> resultMappings, List<ParameterMapping> parameterMappings) {
        return new XMLTypeHandlerResolver(columnNameHandler,