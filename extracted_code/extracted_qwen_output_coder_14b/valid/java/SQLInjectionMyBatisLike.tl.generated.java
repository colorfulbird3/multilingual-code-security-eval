package com.example.dao;

import com.example.model.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {

    /**
     * Creates a fuzzy query based on the product name
     * @param name The name of the product to search for
     * @return A list of matching products
     */
    @Select("SELECT * FROM products WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<Product> searchByName(@Param("name") String name);
}