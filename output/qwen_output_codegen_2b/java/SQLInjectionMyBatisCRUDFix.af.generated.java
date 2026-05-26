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
// public interface ProductMapper {
// @Insert("INSERT INTO products (name) VALUES (#{name})")
// int insert(Product product);
// @Update("UPDATE products SET name = #{name} WHERE id = #{id}")
// int update(Product product);
// @Delete("DELETE FROM products WHERE name = #{name}")
// int delete(@Param("name") String name);
// @Select("SELECT * FROM products WHERE name = #{name}")
// List<Product> select(@Param("name") String name);
// }
// ]]>
// </content>
// </code>
// </result>
// ```
//
// The `content` element may be used to specify other XML elements to be
// included in the XML response.
//
// An example of how to use `content`:
//
// ```xml
// <code>
// <result>
// <code>
// <path>
// src/main/java/com/example/dao/ProductMapper.java
// </path>
// <content>
// <![CDATA[
// <product id="1">
// <name>Foo</name>
// </product>
// ]]>
// </content>
// </code>
// </result>
// ```
//
// The `code` element contains a single XML element which is the source of
// the code. This element must contain a `path` element (see above) and a
// `content` element (see above). `path` and `content` elements may only be
// used with `code` element. `content` must contain the XML for the source
// code.
//
// An example of how to use `code`:
//
// ```xml
// <result>
// <code>
// <path>
// src/main/java/com/example/dao/ProductMapper.java
// </path>
// <content>
// <![CDATA[
// <product id="1">
// <name>Foo</name>
// </product>
// ]]>
// </content>
// </code>
// </result>
// ```
//
//
// An example of how to use all three elements:
//
// ```xml
// <result>
// <code>
// <path>
// src/main/java/com/example/dao/ProductMapper.java
// </path>
// <content>
// <![CDATA[
// <product id="1">
// <name>Foo</name>
// </product>
// ]]>
// </content>
// </code>
// <code>
// <path>
// src/main/java/com/example/dao/ProductDao.java
// </path>
// <content>
// <![CDATA[
// public class ProductDao extends DaoSupport {
// @Override
// public Product getById(Integer id) {
// return new Product();
// }
// ]]>
// </content>
// </code>
// <code>
// <path>
// src/main/java/com/example/dao/ProductMapper.java
// </path>
// <content>
// <![CDATA[
// </content>
// </code>
// </result>
// ```
//
// It is possible to use `code` and `content` in the same xml element to
// define the source code and content of the code.
//
// The `result` element contains all elements (code, content) defined in the
// example above.
//
// An example of how to use `result`:
//
// ```xml
// <result>
// <code>
// <path>
// src/main/java/com/example/dao/ProductDao.java
// </path>
// <content>
// <![CDATA[
// public class ProductDao extends DaoSupport {
// @Override
// public Product getById(Integer id) {
// return new Product();
// }
// ]]>
// </content>
// </code>
// </result>
// ```
//
// ### The `result` element
//
// The `result` element contains all elements (code, content) defined in the
// example above.
//
// The `code` element must only be used within the `result` element.
//
// An example of how to use `code`:
//
// ```xml
// <result>
// <code>
// <path>
// src/main/java/com/example/dao/ProductDao.java
// </path>
// <content>
// <![CDATA[
// public class ProductDao extends DaoSupport {
// @Override
// public Product getById(Integer id) {
// return new Product();
// }
// ]]>
// </content>
// </code>
// </result>
// ```
//
package org.