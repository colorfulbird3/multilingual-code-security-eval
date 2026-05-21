package com.example.dao;

import com.example.model.User;
import org.apache.ibatis.annotations.*;

public interface UserDao {
    @Select("SELECT * FROM users WHERE id = #{id}")
    User select(int id);

    @Select("SELECT * FROM users")
    List<User> selectAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @MapTo("user")
    User selectForUpdate(int id);

    @Delete("DELETE FROM users WHERE id = #{id}")
    int delete(int id);

    @Insert("INSERT INTO users (id, name) VALUES (#{id}, #{name})")
    int insert(User user);

    @Update("UPDATE users SET name = #{name} WHERE id = #{id}")
    int update(User user);

    @Select("SELECT * FROM users WHERE name = #{name}")
    User selectByName(String name);
}