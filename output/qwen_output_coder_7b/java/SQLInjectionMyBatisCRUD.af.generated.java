 ```json
{
  "path": "src/main/java/com/example/dao/ProductMapper.java",
  "content": {
    "package": "com.example.dao",
    "imports": [
      "com.example.model.Product",
      "org.apache.ibatis.annotations.*"
    ],
    "interface": "ProductMapper",
    "methods": [
      {
        "name": "insert",
        "description": "Voeg 'n nuwe produkrekord in.",
        "parameters": [
          {
            "name": "product",
            "type": "Product",
            "description": "die produk om in te voeg"
          }
        ],
        "returnType": "int",
        "sql": "INSERT INTO products (name) VALUES (#{name})"
      },
      {
        "name": "update",
        "description": "Werk die produknaam by op grond van die produk-ID.",
        "parameters": [
          {
            "name": "product",
            "type": "Product",
            "description": "die produk met die opgedateerde naam"
          }
        ],
        "returnType": "int",
        "sql": "UPDATE products SET name = #{name} WHERE id = #{id}"
      },
      {
        "name": "delete",
        "description": "Verwyder 'n produk volgens sy naam.",
        "parameters": [
          {
            "name": "name",
            "type": "String",
            "description": "die naam van die produk om te verwyder"
          }
        ],
        "returnType": "int",
        "sql": "DELETE FROM products WHERE name = #{name}"
      },
      {
        "name": "select",
        "description": "Soek 'n versameling produkte met die gespesifiseerde naam (presiese passing).",
        "parameters": [
          {
            "name": "name",
            "type": "String",
            "description": "die produknaam om te soek"
          }
        ],
        "returnType": "List<Product>",
        "sql": "SELECT * FROM products WHERE name = #{name}"
      }
    ]
  }
}
```