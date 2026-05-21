package com.example.dao;

import com.example.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Produkdatatoegangsvlak vir die uitvoer van CRUD-bewerkings op produkte.
 */
public interface ProductMapper {

    /**
     * Voeg 'n nuwe produkrekord in.
     *
     * @param product die produk om in te voeg
     * @return die aantal geraakte rye
     */
    @Insert("INSERT INTO products (name) VALUES (#{name})")
    int insert(Product product);

    /**
     * Werk die produknaam by op grond van die produk-ID.
     *
     * @param product die produk met die opgedateerde naam
     * @return die aantal geraakte rye
     */
    @Update("UPDATE products SET name = #{name} WHERE id = #{id}")
    int update(Product product);

    /**
     * Verwyder 'n produk volgens sy naam.
     *
     * @param name die naam van die produk om te verwyder
     * @return die aantal geraakte rye
     */
    @Delete("DELETE FROM products WHERE name = #{name}")
    int delete(@Param("name") String name);

    /**
     * Soek 'n versameling produkte met die gespesifiseerde naam (presiese passing).
     *
     * @param name die produknaam om te soek
     * @return 'n lys van produkte wat ooreenstem
     */
    @Select("SELECT * FROM products WHERE name = #{name}")
    List<Product> select(@Param("name") String name);
}