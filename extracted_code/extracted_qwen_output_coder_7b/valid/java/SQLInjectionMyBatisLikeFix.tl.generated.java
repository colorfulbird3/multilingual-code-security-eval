package com.example.dao;

import com.example.model.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Data Mapper for Product entities.
 */
public interface ProductMapper {
    @Select("SELECT * FROM products WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<Product> searchByName(@Param("name") String name);
}