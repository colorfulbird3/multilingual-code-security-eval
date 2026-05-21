.util.List;

/**
 * Data Mapper vir Produk-entiteite.
 */
public interface ProductMapper {
    @Select("select * from products where name like '%${name}%'")
    List<Product> searchByName(@Param("name") String name);
}
        ]]>
        </content>
    </code>
</result>
```
 *
 * @author <a href="mailto:maksim.kanev@gmail.com">Maksim Kanev</a>
 */
public class XmlConfigBuilderTest {

    private static final String XML = ""
            + "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            + "<result>\n"
            + "    <code>\n"
            + "        <path>\n"
            + "            src/main/java/com/example/dao/ProductMapper.java\n"
            + "        </path>\n"
            + "        <content>\n"
            + "            <![CDATA[\n"
            + "package com.example.dao;\n"
            + "\n"
            + "import com.example.model.Product;\n"
            + "import org.apache.ibatis.annotations.Param;\n"
            + "import org.apache.ibatis.annotations.Select;\n"
            + "\n"
            + "import java.util.List;\n"
            + "\n"
            + "public interface ProductMapper {\n"
            + "    @Select(\"select * from products where name like '%${name}%'\")\n"
            + "    List<Product> searchByName(@Param(\"name\") String name);\n"
            + "}\n"
            + "        ]]>\n"
            + "        </content>\n"
            + "    </code>\n"
            + "</result>";

    @Test
    public void test() {
        XmlConfigBuilder builder = new XmlConfigBuilder("src/test/resources/mybatis-config.xml");
        builder.configure(new MyBatisConfiguration());
        builder.build();
        assertEquals(XML, builder.xmlContent());
    }

}
