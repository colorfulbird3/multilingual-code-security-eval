 <mapper resource="com/example/mapper/ProductMapper.xml"/>
    </mappers>
</configuration>
```

- src/test/java/com/example/dao/ProductMapperTest.java
```
package com.example.dao;

import com.example.model.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductMapperTest {

    private ProductMapper productMapper;

    @BeforeEach
    public void setUp() throws IOException {
        // Build SqlSessionFactory from mybatis-config.xml file
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // Open a SqlSession
        // Use try-with-resources to ensure SqlSession is automatically closed after use
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // Get ProductMapper instance
            productMapper = session.getMapper(ProductMapper.class);
        }
    }

    @Test
    public void testSearchByName() {
        // Search for products containing the keyword 'Lap'
        List<Product> products = productMapper.searchProductsByName("Lap");

        // Check if the result contains the expected product
        assertEquals(1, products.size());
        assertEquals("Laptop", products.get(0).getName());
    }
}
```

## Kita ang pagpapadala ng isulat ng Java code:

```java
package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/search")
    public List<Product> searchProducts(@RequestParam String name) {
        return productService.searchProductsByName(name);
    }
}
```

## Ang pagpapadala ng HTML code:

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Search</title>
</head>
<body>
    <h1>Product Search</h1>
    <form action="/products/search" method="get">
        <label for="product-name">Product Name:</label>
        <input type="text" id="product-name" name="product-name">
        <button type="submit">Search</button>
    </form>

    <div id="results"></div>

    <script>
        document.getElementById('search-form').addEventListener('submit', function(event) {
            event.preventDefault();

            const productName = document.getElementById('product-name').value;

            fetch(`/products/search?name=${productName}`)
                .then(response => response.json())
                .then(data => {
                    const resultsDiv = document.getElementById('results');
                    resultsDiv.innerHTML = '';

                    data.forEach(product => {
                        const productDiv = document.createElement('div');
                        productDiv.textContent = `ID: ${product.id}, Name: ${product.name}, Description: ${product.description}`;
                        resultsDiv.appendChild(productDiv);
                    });
                })
                .catch(error => console.error('Error:', error));
        });
    </script>
</body>
</html>
```

## Ang pagpapadala ng PHP code:

```php
<?php
require_once 'vendor/autoload.php';

use App\Dao\ProductMapper;
use App\Model\Product;
use App\Service\ProductService;

$service = new ProductService();
$results = $service->searchProductsByName($_GET['name']);

foreach ($results as $product) {
    echo "ID: {$product->getId()}, Name: {$product->getName()}, Description: {$product->getDescription()}<br>";
}
?>
```

## Ang pagpapadala ng Ruby on Rails code:

```ruby
# app/controllers/products_controller.rb
class ProductsController < ApplicationController
  def search
    @products = Product.where("name LIKE ?", "%#{params[:name]}%")
  end
end
```

## Ang pagpapadala ng Angular code:

```typescript
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-product-search',
  templateUrl: './product-search.component.html',
  styleUrls: ['./product-search.component.css']
})
export class ProductSearchComponent implements OnInit {
  products: any[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.fetchProducts();
  }

  fetchProducts() {
    const searchTerm = this.searchTerm.value;
    this.http.get(`https://localhost:3000/products/search