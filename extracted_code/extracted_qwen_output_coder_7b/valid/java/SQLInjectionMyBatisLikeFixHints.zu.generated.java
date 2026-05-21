package com.example.dao;

import com.example.model.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * I-Mapper Yedatha yezinhlaka ze-Product.
 */
public interface ProductMapper {
    @Select("select * from products where name like '%' || #{name} || '%'")
    List<Product> searchByName(@Param("name") String name);
}