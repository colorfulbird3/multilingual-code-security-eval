package com.example.dao;
import com.example.model.Person;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultMapping;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Select("select * from people where name like :${name}")
@Results(value = {
@ResultMap(
name = "productResultMap",
entities = {
@Result(property = "id", column = "id"),
@Result(property = "name", column = "name"),
@Result(property = "description", column = "description")
}),
@Result(property = "products", column = "id", javaType = "com.example.dao.ProductMapper", resultSet = "productResultMap")
})
List<Person> searchByName(@Param("name") String name);