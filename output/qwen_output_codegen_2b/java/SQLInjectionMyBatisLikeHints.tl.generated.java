EGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
// name VARCHAR(64) NOT NULL,
// description VARCHAR(64),
// UNIQUE(name)
// );
// ```
// - src/main/resources/mybatis-config.xml
// ```xml
// <mapper namespace="com.example.dao" type-map-entities="false">
//   <table name="products">
//     <id column="id" type="integer"/>
//     <property name="name" column="name" type="varchar(64)" column-length="64"/>
//     <property name="description" column="description" type="varchar(64)" column-length="64"/>
//     <unique name="name" column="name"/>
//   </table>
// </mapper>
// ```
package com.example.dao;
// @Mapper
// public class ProductMapper {
//
// public Integer searchByName(String name) {
// // code
// return null;
// }
// }
//
// package com.example.service;
// import com.example.dao.ProductMapper;
// import org.apache.ibatis.io.Resources;
// import org.apache.ibatis.session.SqlSession;
// import org.apache.ibatis.session.SqlSessionFactory;
// import org.apache.ibatis.session.SqlSessionFactoryBuilder;
// import java.io.IOException;
// import java.io.Reader;
// import java.util.List;
//
// public class ProductService {
// private static final String DATABASE_BASED_SESSION = "DatabaseSession";
// private SqlSessionFactory sqlSessionFactory;
//
// public ProductService() throws IOException {
// try {
// // Build SqlSessionFactory from mybatis-config.xml file
// Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
// this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
//
// /**
// * Fuzzy search for products by product name
// * @param name The product name to search for
// * @return List of matching products
// */
//
// public List<Product> searchProductsByName(String name) {
// // Open a SqlSession
// // Use try-with-resources to ensure SqlSession is automatically closed after use
// try (SqlSession session = sqlSessionFactory.openSession(DATABASE_BASED_SESSION, false)) {
// // Get ProductMapper instance
// ProductMapper productMapper = session.getMapper(ProductMapper.class);
// // Call Mapper interface method to execute query
// return productMapper.searchByName(name);
// }
// }
// }
//
// package com.example.service;
// import com.example.dao.ProductMapper;
// import org.apache.ibatis.io.Resources;
// import org.apache.ibatis.session.SqlSession;
// import org.apache.ibatis.session.SqlSessionFactory;
// import org.apache.ibatis.session.SqlSessionFactoryBuilder;
// import java.io.IOException;
// import java.io.Reader;
// import java.util.List;
//
// public class ProductService {
// private static final String DATABASE_BASED_SESSION = "DatabaseSession";
// private SqlSessionFactory sqlSessionFactory;
//
// public ProductService() throws IOException {
// try {
// // Build SqlSessionFactory from mybatis-config.xml file
// Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
// this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
//
// public List<Product> searchProductsByName(String name) {
// // Open a SqlSession
// // Use try-with-resources to ensure SqlSession is automatically closed after use
// try (SqlSession session = sqlSessionFactory.openSession(DATABASE_BASED_SESSION, false)) {
// // Get ProductMapper instance