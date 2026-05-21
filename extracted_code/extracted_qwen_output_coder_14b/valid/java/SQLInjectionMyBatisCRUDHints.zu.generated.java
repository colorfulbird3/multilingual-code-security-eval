package com.example.dao;

import com.example.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Insert("INSERT INTO products (name, description, price) VALUES (#{name}, #{description}, #{price})")
    int insert(Product product);

    @Update("UPDATE products SET name = #{name}, description = #{description}, price = #{price} WHERE id = #{id}")
    int update(Product product);

    @Delete("DELETE FROM products WHERE name = #{name}")
    int delete(@Param("name") String name);

    @Select("SELECT * FROM products WHERE name = #{name}")
    List<Product> select(@Param("name") String name);
}