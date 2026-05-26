 description VARCHAR(255) NOT NULL);
// ```
// ## Okuqukethwe Akudingekayo Okukhona
// - src/main/resources/mybatis-config.xml
// ```xml
// <mapper package="com.example.dao" type="java">
//   <table name="products">
//     <column name="id" type="integer"/>
//     <column name="name" type="varchar(255)" size="255"/>
//     <column name="description" type="varchar(255)" size="255"/>
//   </table>
//   <sql id="findProductById" resultType="product" select="product">
//     SELECT *
//     FROM products WHERE id = ${id}
//   </sql>
// </mapper>
// ```
// - src/main/java/com/example/dao/ProductMapper.java
// ```java
// package com.example.dao;
// import org.apache.ibatis.session.SqlSession;
// import org.apache.ibatis.session.SqlSessionFactory;
// import org.apache.ibatis.session.SqlSessionFactoryBuilder;
// import java.io.Reader;
// import java.util.List;
// import com.example.model.Product;
// public class ProductMapper {
// private SqlSessionFactory sqlSessionFactory;
// public ProductMapper() {
// try {
// // Build SqlSessionFactory from mybatis-config.xml file
// Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
// this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
// /**
// * Fuzzy search for products by product name
// * @param name The product name to search for
// * @return List of matching products
// */
// public List<Product> searchByName(String name) {
// // Open a SqlSession
// // Use try-with-resources to ensure SqlSession is automatically closed after use
// try (SqlSession session = sqlSessionFactory.openSession()) {
// // Get ProductMapper instance
// ProductMapper productMapper = session.getMapper(ProductMapper.class);
// // Call Mapper interface method to execute query
// return productMapper.searchByName(name);
// }
// }
// }
// ```
// ## Okuqukethwe Akudingekayo Okukhona
// - src/main/resources/mybatis-config.xml
// ```xml
// <mapper package="com.example.dao" type="java">
//   <table name="products">
//     <column name="id" type="integer"/>
//     <column name="name" type="varchar(255)" size="255"/>
//     <column name="description" type="varchar(255)" size="255"/>
//   </table>
//   <sql id="findProductById" resultType="product" select="product">
//     SELECT *
//     FROM products WHERE id = ${id}
//   </sql>
// </mapper>
// ```
// - src/main/java/com/example/dao/ProductMapper.java
// ```java
// package com.example.dao;
// import org.apache.ibatis.session.SqlSession;
// import org.apache.ibatis.session.SqlSessionFactory;
// import org.apache.ibatis.session.SqlSessionFactoryBuilder;
// import java.io.Reader;
// import java.util.List;
// import com.example.model.Product;
// public class ProductMapper {
// private SqlSessionFactory sqlSessionFactory;
// public ProductMapper() {
// try {
// // Build SqlSessionFactory from mybatis-config.xml file
// Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
// this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
// /**
// * Fuzzy search for products by product name
// * @param name The product name to search for
// *