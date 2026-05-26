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
// * I-Mapper Yedatha yezinhlaka ze-Product.
// */
// public interface ProductMapper {
// @Select("select * from products where name like '%' || #{name} || '%'")
// List<Product> searchByName(@Param("name") String name);
// }
// ]]>
// </content>
// </code>
// </result>
// ```
//
//
// ## Response
//
//
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
// import java.util.List;
//
//
// /**
// * I-Mapper Yedatha yezinhlaka ze-Product.
// */
// public interface ProductMapper {
// @Select("select * from products where name like '%' || #{name} || '%'")
// List<Product> searchByName(@Param("name") String name);
// }
// ]]>
// </content>
// </code>
// </result>
// ```
//
//
// ## Example
//
// ```xml
// <prefer xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
//     xsi:schemaLocation="http://www.ibatis.com/sqlmap-core sqlmap-core-2.0.xsd"
//     xmlns="http://www.ibatis.com/sql-map-dynamic">
//     <sqlMap name="productMapper">
//       <resultMap type="select">
//         <resultMap type="statement">
//           <sql>select * from products where name like '%' || #{name} || '%'</sql>
//           <parameterMap>
//             <parameterMap>
//               <parameter key="name"
//                 javaType="com.example.model.Product"
//                 classType="org.apache.ibatis.annotations.Param" />
//             </parameterMap>
//           </parameterMap>
//         </resultMap>
//         <resultMap type="insert" id="productMapper-insert">
//           <resultMap type="statement" id="productMapper-insert-statement">
//             <sql>insert into products (name) values (#{name})</sql>
//             <parameterMap>
//               <parameter key="name"
//                 javaType="com.example.model.Product"
//                 classType="org.apache.ibatis.annotations.Param" />
//             </parameterMap>
//           </resultMap>
//         </resultMap>
//         <resultMap type="delete" id="productMapper-delete">
//           <resultMap type="statement" id="productMapper-delete-statement">
//             <sql>delete from products where name like '%' || #{name} || '%'</sql>
//           </resultMap>
//         </resultMap>
//         <resultMap type="update" id="productMapper-update">
//           <resultMap type="statement" id="productMapper-update-statement">
//             <sql>update products set name = #{name} where name like '%' || #{name} || '%'</sql>
//           </resultMap>
//         </resultMap>
//         <resultMap type="query" id="productMapper-query">
//           <resultMap type="statement" id="productMapper-query-statement">
//             <sql>select * from products where name like '%' || #{name} || '%'</sql>
//           </resultMap>
//         </resultMap>
//       </sqlMap>
//     </sqlMap>
// </prefer>
// ```

package org.mybatis.dao.mapper;
