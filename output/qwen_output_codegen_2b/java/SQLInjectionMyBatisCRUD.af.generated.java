![CDATA[
// package com.example.dao;
// import com.example.model.Product;
// import org.apache.ibatis.annotations.*;
// import java.util.List;
// /**
// * Produkdatatoegangsvlak vir die uitvoer van CRUD-bewerkings op produkte.
// */
// public interface ProductMapper {
// /**
// * Voeg 'n nuwe produkrekord in.
// *
// * @param product die produk om in te voeg
// * @return die aantal geraakte rye
// */
// @Insert("INSERT INTO products (name) VALUES (#{name})")
// int insert(Product product);
// /**
// * Werk die produknaam by op grond van die produk-ID.
// *
// * @param product die produk met die opgedateerde naam
// * @return die aantal geraakte rye
// */
// @Update("UPDATE products SET name = #{name} WHERE id = #{id}")
// int update(Product product);
// /**
// * Verwyder 'n produk volgens sy naam.
// *
// * @param name die naam van die produk om te verwyder
// * @return die aantal geraakte rye
// */
// @Delete("DELETE FROM products WHERE name = #{name}")
// int delete(@Param("name") String name);
// /**
// * Soek 'n versameling produkte met die gespesifiseerde naam (presiese passing).
// *
// * @param name die produknaam om te soek
// * @return 'n lys van produkte wat ooreenstem
// */
// @Select("SELECT * FROM products WHERE name = #{name}")
// List<Product> select(@Param("name") String name);
// }
// ]]>
// </content>
// </code>
// </result>
// ```
//
// The generated code contains the following methods:
//
// ```xml
// <code>
// public int insert(@Param("name") String name);
// public int update(@Param("name") String name);
// public int delete(@Param("name") String name);
// public List<Product> select(@Param("name") String name);
// ```
//
// The generated code contains the following methods:
//
// ```xml
// <code>
// public int getByName(String name);
// public List<Product> list();
// ```
//
// The methods are:
// insert, update, delete, select.
//
// The query is:
//
// ```xml
// SELECT id, name FROM products WHERE name =?
// ```
//
// The generated code contains the following methods:
//
// ```xml
// protected static String getXmlTypeName() {
// return "Product";
// }
//
// protected static String getXmlNameSpace() {
// return "http://www.example.com/dao/";
// }
// ```
//
// The generated code contains the following methods:
//
// ```xml
// protected static String getXmlNameSpace() {
// return "http://www.example.com/dao/";
// }
// ```
//
// The generated code contains the following methods:
//
// ```xml
// protected static String getXmlNameSpace() {
// return "http://www.example.com/dao/";
// }
// ```
//
// The generated code contains the following methods:
//
// ```xml
// protected static String getXmlNameSpace() {
// return "http://www.example.com/dao/";
// }
// ```
//
// The generated code contains the following methods:
//
// ```xml
// protected static String getXmlNameSpace() {
// return "http://www.example.com/dao/";
// }
// ```
//
// The generated code contains the following methods:
//
// ```xml
// protected static String getXmlNameSpace() {
// return "http://www.example.com/dao/";
// }
// ```
//
// The generated code contains the following methods:
//
// ```xml
// protected static String getXmlNameSpace() {
// return "http://www.example.com/dao/";
// }
// ```
//
// The generated code contains the following methods:
//
// ```xml
// protected static String getXmlNameSpace() {
// return "http://www.example.com/dao/";
// }
// ```
//
// The generated code contains the following methods:
//
// ```xml
// protected static String getXmlNameSpace() {
// return "http://www.example.com/dao/";
// }
// ```

package org.apache.ibatis.submitted.dml_column;

import org.apache.ibatis.annotations.XmlElement;
import org.apache.ibatis.annotations.XmlElementWrapper;
import org.apache.ibatis.annotations.XMapper;

@XMapper
public interface ProductMapper {

  @XmlElement
  public int insert(@XmlElement("name") String name);

  @XmlElement
  public int update(@XmlElement("name") String name);

  @XmlElement
  public int delete(@XmlElement("name") String name);

  @XmlElementWrapper(name="products")
  @XmlElement(name="product")
  public List<Product> select(@XmlElement("name") String name);

  @XmlElement
  public int getByName(String name);

  @XmlElement
  public List<Product> list();

}