```java
@Update("UPDATE users SET name = #{name} WHERE id = #{id}")
void update(@Param("name") String name, @Param("id") Long id);

@Insert("INSERT INTO users(name) VALUES(#{name})")
void insert(@Param("name") String name);
```