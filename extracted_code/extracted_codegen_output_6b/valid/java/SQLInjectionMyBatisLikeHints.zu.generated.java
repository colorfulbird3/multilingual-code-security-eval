package com.example.dao;

import com.example.model.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * I-Mapper yemikhiqizo.
 */
public interface ProductMapper {

    /**
     * Yenza ukusesha okungacacile ngegama lomkhiqizo.
     *
     * @param name Igama lomkhiqizo okufanele useshwe
     * @return Uhlu lwemikhiqizo efanayo
     */
    @Select("SELECT * FROM products WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<Product> searchByName(@Param("name") String name);
}