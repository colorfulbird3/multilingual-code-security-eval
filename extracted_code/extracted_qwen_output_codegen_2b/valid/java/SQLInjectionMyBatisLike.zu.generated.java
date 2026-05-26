package com.example.dao;
import com.example.model.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
/**
* I-Mapper yeMybatis yokwenza imibuzo efana negama lomkhiqizo.
*/
public interface ProductMapper {
/**
* Yenza umbuzo ofana negama lomkhiqizo.
*
* @param name Igama lomkhiqizo okufanele lihlolwe
* @return Uhlu lwemikhiqizo ehambisanayo
*/
@Select("SELECT * FROM products WHERE name LIKE CONCAT('%', #{name}, '%')")
List<Product> searchByName(@Param("name") String name);
}