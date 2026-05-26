// public void insert(Product product) {
// SqlSession session = sqlSessionFactory.openSession();
// session.getMapper(ProductMapper.class).insert(product);
// session.close();
// }
// public void update(Product product) {
// SqlSession session = sqlSessionFactory.openSession();
// session.getMapper(ProductMapper.class).update(product);
// session.close();
// }
// public void delete(@Param("name") String name) {
// SqlSession session = sqlSessionFactory.openSession();
// session.getMapper(ProductMapper.class).delete(name);
// session.close();
// }
// public List<Product> select(@Param("name") String name) {
// SqlSession session = sqlSessionFactory.openSession();
// List<Product> result = session.getMapper(ProductMapper.class).select(name);
// session.close();
// return result;
// }
// }
// ```
// ## Problem
// In case of a SQL injection vulnerability, the following code snippet is the best way to implement
// the code required to solve this problem:
// ```java
// /**
// * Represents a product entity.
// */
// public class Product {
// private Integer id;
// private String name;
// @Override
// public String toString() {
// return "Product{" +
// "id=" + id +
// ", name='" + name + '\'' +
// '}';
// }
// }
// ```
// The following code snippet shows how to implement the `update` method with the injection vulnerability
// handled:
// ```java
// /**
// * Represents a product entity.
// */
// public class Product {
// private Integer id;
// private String name;
// @Override
// public String toString() {
// return "Product{" +
// "id=" + id +
// ", name='" + name + '\'' +
// '}';
// }
// public void update(@Param("name") String name) {
// // Update product name
// this.name = name;
// }
// }
// ```
// ## Solution
// - Implement the `update(@Param("name") String name)` method with the injection logic implemented.
// - Make the @Update annotation required on the `@Mapper` method that implements `update(@Param("name") String name)`.
// - Make the @Insert annotation required on the `@Mapper` method that implements `insert(@Param("name") String name)`.
// ```java
// package com.example.dao;
// import com.example.model.Product;
// import org.apache.ibatis.annotations.Insert;
// import org.apache.ibatis.annotations.Mapper;
// import org.apache.ibatis.annotations.Param;
// import org.apache.ibatis.annotations.Update;
// import org.apache.ibatis.mapping.StatementType;
// import org.apache.ibatis.mapping.MappedStatement;
// import org.apache.ibatis.mapping.ResultMap;
// import org.apache.ibatis.mapping.ResultMapping;
// import org.apache.ibatis.mapping.ResultSetType;
// import org.apache.ibatis.scripting.xmltemplate.SimpleCallExpression;
// import org.apache.ibatis.scripting.xmltemplate.XMLMapperEntityResolver;
// import org.apache.ibatis.scripting.xmltemplate.XMLScriptEngineFactory;
// import org.apache.ibatis.session.SqlSession;
// import org.apache.ibatis.session.SqlSessionFactory;
// import org.apache.ibatis.session.SqlSessionFactoryBuilder;
// import org.apache.ibatis.session.SqlSession;
// import java.io.InputStream;
// import java.util.List;
// import java.util.Map;
// public class ProductMapper {
//    @Mapper
//    public interface ProductMapper {
//       @Update("update products set name = #{name} where id = #{id}")
//       void update(@Param("name") String name);
//       @Insert("insert into products (name) values (?)")
//       void insert(@Param