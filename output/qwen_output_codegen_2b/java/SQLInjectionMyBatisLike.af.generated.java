// ```xml
// <result>
// <code>
// <path>
// src/main/java/com/example/dao/ProductMapper.java
// </path>
// <content>
// <![CDATA[
// package com.example.dao;
// import com.example.model.Product;
// import org.apache.ibatis.annotations.Param;
// import org.apache.ibatis.annotations.Select;
// import java.util.List;
// public interface ProductMapper {
// /**
// * Voer 'n wasige soektog uit gebaseer op die produknaam (name)
// * @param name Die produknaam om na te soek
// * @return Lys van ooreenstemmende produkte
// */
// @Select("SELECT * FROM products WHERE name LIKE CONCAT('%', #{name}, '%')")
// List<Product> searchByName(@Param("name") String name);
// }
// ]]>
// </content>
// </code>
// </result>
// ```
//
// @author Michael Neale

public final class XmlRpcResponse {
    public int code;
    public String message;
    public List<Object> results;
    public String xml;

    private XmlRpcResponse() {}

    public static XmlRpcResponse create(int code, String message) {
        XmlRpcResponse r = new XmlRpcResponse();
        r.code = code;
        r.message = message;
        return r;
    }

    public static XmlRpcResponse create(int code, String message, Object result) {
        XmlRpcResponse r = new XmlRpcResponse();
        r.code = code;
        r.message = message;
        r.results = Lists.newArrayList();
        r.results.add(result);
        return r;
    }

    public static XmlRpcResponse create(int code, String message, List<Object> results) {
        XmlRpcResponse r = new XmlRpcResponse();
        r.code = code;
        r.message = message;
        r.results = results;
        return r;
    }

    public static XmlRpcResponse create(int code, String message, String xml) {
        XmlRpcResponse r = new XmlRpcResponse();
        r.code = code;
        r.message = message;
        r.xml = xml;
        return r;
    }

    public void add(Object o) {
        results.add(o);
    }
}
