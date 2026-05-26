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
// import org.apache.ibatis.annotations.*;
// import java.util.List;
// @Mapper
// public interface ProductMapper {
// @Insert("INSERT INTO products(name) VALUES(#{name})")
// int insert(Product product);
// @Update("UPDATE products SET name=#{name} WHERE id=#{id}")
// int update(Product product);
// @Delete("DELETE FROM products WHERE name=#{name}")
// int delete(@Param("name") String name);
// @Select("SELECT * FROM products WHERE name=#{name}")
// List<Product> select(@Param("name") String name);
// }
// ]]>
// </content>
// </code>
// </result>
// ```
//
// In the example above, `name` can be any string, and the code above will
// be compiled into the following Java code:
//
// ```java
// package com.example.dao;
// import org.apache.ibatis.annotations.Mapper;
// import org.apache.ibatis.annotations.Param;
// import org.apache.ibatis.annotations.ResultType;
// import org.apache.ibatis.annotations.Select;
// import org.apache.ibatis.annotations.Update;
// import org.apache.ibatis.annotations.ResultMap;
// import org.apache.ibatis.annotations.Results;
// import org.apache.ibatis.annotations.SelectKey;
// import com.example.model.Product;
// import com.example.model.ProductMapper;
// import java.io.InputStreamReader;
// import java.io.Reader;
// import java.sql.SQLException;
// import java.util.List;
// import java.util.Map;

// import static org.apache.ibatis.io.Resources.classPathPropertiesResolver;

public interface ProductMapper {
// @Update(keys = {"id"}, value = "name=#{name}")
// int update(@Param("name") String name);
//
// @Delete("DELETE FROM products WHERE name=#{name}")
// int delete(@Param("name") String name);
//
// @Select("SELECT * FROM products WHERE name=#{name}")
// List<Product> select(@Param("name") String name);
//
// @Insert("INSERT INTO products(name) VALUES(#{name})")
// int insert(Product product);

  @Mapper
  @SelectKey(statement = "SELECT COUNT(*) AS total FROM products", keyProperty = "name", resultType = ResultType.SCROLL_SENSITIVE)
  List<Product> selectAll();

  @Mapper
  @Select("SELECT * FROM products WHERE name=#{name}")
  Product select(@Param("name") String name);
}