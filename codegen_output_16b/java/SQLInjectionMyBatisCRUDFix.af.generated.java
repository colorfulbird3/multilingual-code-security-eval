```  #{name} is replaced by the value of the parameter passed to the mapper.

3.

Suppose you have a `User` entity with an `addresses` relationship.
For the mapping file, create the `@MapTo` annotation on the relationship.

```xml
<result>
    <code>
        <path>
            src/main/java/com/example/dao/UserDao.java
        </path>
        <content>
            <![CDATA[
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
]]>
        </content>
    </code>
</result>

4.

Suppose you have a `User` entity with an `addresses` relationship.
For the mapping file, create the `@MapTo` annotation on the relationship.

```xml
<result>
    <code>
        <path>
            src/main/java/com/example/dao/UserDao.java
        </path>
        <content>
            <![CDATA[
package com.example.dao;

import com.example.model.User;
import org.apache.ibatis.annotations.*;

public interface UserDao {
