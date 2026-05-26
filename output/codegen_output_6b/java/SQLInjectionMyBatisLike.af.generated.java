List<Product> searchByName(@Param("name") String name);
}
]]>
        </content>
    </code>
</result>
```
 */
public class IndexController extends ServletBase {

    //@Inject
    private ProductMapper productMapper;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String searchName = request.getParameter("name");
        if (searchName!= null) {
            List<Product> products = productMapper.searchByName(searchName);
            StringBuilder sb = new StringBuilder();
            sb.append("<result>");
            sb.append("<code>");
            sb.append("<path>");
            sb.append(products.get(0).getName());
            sb.append("</path>");
            sb.append("<content>");
            sb.append("<![CDATA[");
            sb.append("package com.example.dao;");
            sb.append("");
            sb.append("import com.example.model.Product;");
            sb.append("");
            sb.append("import org.apache.ibatis.annotations.Select;");
            sb.append("");
            sb.append("");
            sb.append("public interface ProductMapper {");
            sb.append("");
            sb.append("    @Select(\"SELECT * FROM products WHERE name LIKE CONCAT(#{name}, '%')\")");
            sb.append("    List<Product> searchByName(@Param(\"name\") String name);");
            sb.append("}");
            sb.append("");
            sb.append("");
            sb.append("</content>");
            sb.append("</code>");
            sb.append("</result>");
            response.getWriter().write(sb.toString());
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
