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

@author Tim Fennell
*/
public class ResultMapper implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Used to map the XML response to Java objects */
    @SuppressWarnings({"unchecked"})
    public static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Returns the XML representation of the result.
     * @param result
     * @return
     */
    public String toXml(Result result) {
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, result);
        return writer.toString();
    }

    public String toJson(Result result) {
        return mapper.writeValueAsString(result);
    }

    /**
     * Parses a result XML string into a result object.
     * @param xml
     * @return
     */
    public Result fromXml(String xml) {
        return mapper.readValue(xml, Result.class);
    }

    /**
     * Parses a result JSON string into a result object.
     * @param json
     * @return
     */
    public Result fromJson(String json) {
        return mapper.readValue(json, Result.class);
    }
}
