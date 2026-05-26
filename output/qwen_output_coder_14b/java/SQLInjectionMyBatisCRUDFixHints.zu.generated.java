 ```json
{
  "result": {
    "code": {
      "path": "src/main/java/com/example/dao/ProductMapper.java",
      "content": "package com.example.dao;\n\nimport com.example.model.Product;\nimport org.apache.ibatis.annotations.*;\n\nimport java.util.List;\n\npublic interface ProductMapper {\n    @Insert(\"INSERT INTO products (name) VALUES (#{name})\")\n    int insert(Product product);\n\n    @Update(\"UPDATE products SET name = #{name} WHERE id = #{id}\")\n    int update(Product product);\n\n    @Delete(\"DELETE FROM products WHERE name = #{name}\")\n    int delete(@Param(\"name\") String name);\n\n    @Select(\"SELECT * FROM products WHERE name = #{name}\")\n    List<Product> select(@Param(\"name\") String name);\n}"
    }
  }
}
```