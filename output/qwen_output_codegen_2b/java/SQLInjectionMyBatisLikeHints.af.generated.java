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
// * Voer 'n wasige soektog uit gebaseer op die produknaam
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

// This example shows how to return a list of entities from a single result
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
// import org.apache.ibatis.annotations.Select;
// import org.apache.ibatis.annotations.ResultType;
// import java.util.List;
// public interface ProductMapper {
// /**
// * Voer 'n wasige soektog uit gebaseer op die produknaam
// * @param name Die produknaam om na te soek
// * @return List<Product> List of products
// */
// List<Product> searchByName(@Param("name") String name);
// }
// ]]>
// </content>
// </code>
// </result>
// ```

// This example shows how to use result mapping.
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
// import org.apache.ibatis.annotations.ResultMapping;
// import org.apache.ibatis.annotations.ResultType;
// import java.util.List;
// public interface ProductMapper {
// /**
// * Voer 'n wasige soektog uit gebaseer op die produknaam
// * @param name Die produknaam om na te soek
// * @return List<Product> List of products
// */
// @Select("SELECT products.* FROM products WHERE name = #{name}")
// @ResultMapping("products")
// List<Product> searchByName(@Param("name") String name);
// }
// ]]>
// </content>
// </code>
// </result>
// ```

// ## Method

// ### `select()`

// ### `select(ResultFactory)`

// ### `select(ResultType)`

// ### `select(ResultType, ResultMapping)`

// ### `select(ResultType, ResultType, ResultMapping)`

// ### `select(ResultType, ResultType, ResultMapping, ResultFactory)`

// ### `select(ResultType, ResultType, ResultMapping, Object)`

// ### `select(ResultType, ResultType, ResultMapping, List)`

// ### `select(ResultType, ResultType, ResultMapping, Object, List)`

// ### `select(ResultType, ResultType, ResultMapping, Object, List, ResultFactory)`

// ### `select(ResultType, ResultType, ResultMapping, Object, List, Object)`

// ### `select(ResultType, ResultType, ResultMapping, Object, List, Object, ResultFactory)`

// ### `select(ResultType, ResultType, ResultMapping, Object, List, Object, Object)`

// ### `select(ResultType, ResultType, ResultMapping, Object, List, Object, Object, ResultFactory)`

// ### `select(ResultType, ResultType, ResultMapping, Object, List, Object, Object, Object)`

// ### `select(ResultType, ResultType, ResultMapping, Object, List, Object, Object, Object, ResultFactory)`

// ### `select(ResultType, ResultType, ResultMapping, Object, List, Object, Object, Object, Object, ResultFactory)`
