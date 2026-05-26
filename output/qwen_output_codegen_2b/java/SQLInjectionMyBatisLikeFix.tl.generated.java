 UNIQUE (name)
// );
// CREATE TABLE product_catelog (
// id INT PRIMARY KEY AUTO_INCREMENT,
// name VARCHAR(255) NOT NULL,
// description VARCHAR(255),
// UNIQUE (name)
// );
// ```
// - src/main/resources/test.sql
// ```create table products (
// id INT PRIMARY KEY AUTO_INCREMENT,
// name VARCHAR(255) NOT NULL,
// description VARCHAR(255),
// UNIQUE (name)
// );
// create table product_catelog (
// id INT PRIMARY KEY AUTO_INCREMENT,
// name VARCHAR(255) NOT NULL,
// description VARCHAR(255),
// UNIQUE (name)
// );```
//
// ## Datasource
// You can use the datasource to store all your data. It uses a single datasource which is available in the class.
// ```java
// package com.example.dao;
// import org.apache.ibatis.datasource.pooled.PooledDataSource;
// import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
// import org.apache.ibatis.datasource.pooled.PooledDataSource;
// import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
// import org.apache.ibatis.datasource.DataSourceFactory;
// import org.apache.ibatis.datasource.pooled.PooledDataSource;
// import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
// import org.apache.ibatis.datasource.DataSourceFactory;
// import org.apache.ibatis.datasource.pooled.PooledDataSource;
// import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
// import org.apache.ibatis.datasource.DataSourceFactory;
// ```
// - src/main/resources/mybatis-config.xml
// ```xml
// <!DOCTYPE sql PUBLIC "-//mybatis.org//DTD Sql//EN" "http://mybatis.org/dtd/mybatis-3-sql.dtd">
// <script type="text/x-sql">
// SELECT * FROM products WHERE name =? OR name LIKE?
// </script>
// ```
// - src/main/resources/mybatis-config-test.xml
// ```xml
// <!DOCTYPE sql PUBLIC "-//mybatis.org//DTD Sql//EN" "http://mybatis.org/dtd/mybatis-3-sql.dtd">
// <test id="test">
// <script type="text/x-sql">
// SELECT * FROM products WHERE name =? OR name LIKE?
// </script>
// </test>
// ```
//
// ## SqlSessionFactory
// - src/main/resources/mybatis-config-test.xml
// ```xml
// <test id="test">
// <script type="text/x-sql">
// SELECT * FROM products WHERE name =? OR name LIKE?
// </script>
// </test>
// ```
//
// ## SqlSessionFactory
// - src/main/resources/mybatis-config-test.xml
// ```xml
// <test id="test">
// <script type="text/x-sql">
// SELECT * FROM products WHERE name =? OR name LIKE?
// </script>
// </test>
// ```
//
// ## SqlSessionFactory
// - src/main/resources/mybatis-config-test.xml
// ```xml
// <test id="test">
// <script type="text/x-sql">
// SELECT * FROM products WHERE name =? OR name LIKE?
// </script>
// </test>
// ```
//
// ## SqlSessionFactory
// - src/main/resources/mybatis-config-test.xml
// ```xml
// <test id="test">
// <script type="text/x-sql">
// SELECT * FROM products WHERE name =? OR name LIKE?
// </script>
