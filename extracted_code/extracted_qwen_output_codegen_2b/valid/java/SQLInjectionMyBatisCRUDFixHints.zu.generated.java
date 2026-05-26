package com.example.sqlite;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ProductMapper {

  @Select("SELECT * FROM products WHERE name = #{name}")
  List<Product> select(@Param("name") String name);

  @Insert("INSERT INTO products (name) VALUES (#{name})")
  int insert(Product product);

  @Update("UPDATE products SET name = #{name} WHERE id = #{id}")
  int update(Product product);

  @Delete("DELETE FROM products WHERE name = #{name}")
  int delete(@Param("name") String name);
}