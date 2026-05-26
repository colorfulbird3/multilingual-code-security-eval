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
// /**
// * Data Mapper vir Produk-entiteite.
// */
// public interface ProductMapper {
// @Select("select * from products where name like '%${name}%'")
// List<Product> searchByName(@Param("name") String name);
// }
// ]]>
// </content>
// </code>
// </result>
// ```
//
// A more complex example of a query that uses XML-to-SQL-mapping
//
// ```xml
// <result>
// <code>
// <path>
// src/main/java/com/example/dao/PersonMapper.java
// </path>
// <content>
// <![CDATA[
// package com.example.dao;
// import com.example.model.Person;
// import org.apache.ibatis.annotations.Select;
// import org.apache.ibatis.annotations.ResultMap;
// import org.apache.ibatis.annotations.ResultMapping;
// import org.apache.ibatis.annotations.Results;
// import org.apache.ibatis.annotations.Param;
// import java.util.List;
//
// @Select("select * from people where name like '%${name}%'")
// @Results(value = {
// @ResultMap(
// name = "productResultMap",
// entities = {
// @Result(property = "id", column = "id"),
// @Result(property = "name", column = "name"),
// @Result(property = "description", column = "description")
// }),
// @Result(property = "products", column = "id", javaType = "com.example.dao.ProductMapper", resultSet = "productResultMap")
// })
// List<Person> searchByName(@Param("name") String name);
// ]]>
// </content>
// </code>
// </result>
// ```
//
// The above example is a case where the entity `Person` is defined in the
// code and that will be used to map into the XML. The XML will define a
// `Person` mapping which references the mapping defined in `ProductMapper`.
//
// ## References and References to other entities
//
// In order to map to XML, you must define any references to other entities in
// the XML. There are two types of references:
//
// * `<param` in the XML mapping section
// * `<result>` in the XML query.
//
// The first example defines a reference to the `Person` entity in the code.
//
// The second example defines a reference to the `Product` entity in the code.
//
// ### Reference types
//
// * `<param`: A reference parameter to another entity from the code.
// * `<result>`: A reference to an entity in the XML query.
//
// You can refer to the `Person` entity in the code by using the parameter
// `name`.
//
// ### `<result>` reference
//
// The `<result>` reference is used to specify the XML result which will be
// mapped to the `Person` entity in the XML query.
//
// The `<result>` reference can also map to an entity in the XML query.
//
//  ```xml
// <result>
// <code>
// <path>
// src/main/java/com/example/dao/PersonMapper.java
// </path>
// <content>
// <![CDATA[
// package com.example.dao;
// import com.example.model.Person;
// import org.apache.ibatis.annotations.Select;
// import org.apache.ibatis.annotations.ResultMap;
// import org.apache.ibatis.annotations.ResultMapping;
// import org.apache.ibatis.annotations.Results;
// import org.apache.ibatis.annotations.Param;
// import java.util.List;
//
// @Select("select * from people where name like :${name}")
// @Results(value = {
// @ResultMap(
// name = "productResultMap",
// entities = {
// @Result(property = "id", column = "id"),
// @Result(property = "name", column = "name"),
// @Result(property = "description", column = "description")
// }),
// @Result(property = "products", column = "id", javaType = "com.example.dao.ProductMapper", resultSet = "productResultMap")
// })
// List<Person> searchByName(@Param("name") String name);
// ]]>
// </content>
// </code>
// </result>
//
// For