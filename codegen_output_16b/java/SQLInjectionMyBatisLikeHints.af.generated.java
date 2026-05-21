

@apiDefineParam(name = "name", type = "string", paramType = "path", required = true)
@apiParam(name = "name", type = "string", required = true)
@apiUse SiteParam
@apiUse RequestParam
@apiUse ResponseParam
@apiUse RestResponse
@apiUse Example
@apiUse Error

@api {get} /products/:name
@apiName GetProduct
@apiGroup Product
@apiDescription Get a product by name.
@apiParam {String} name The name of the product.
@apiExample {curl} Example usage:
  curl -i localhost:3000/products/my-product
  curl -i localhost:3000/products/my-product --header 'Content-Type: application/json' --header 'Accept: application/xml'
  curl -i localhost:3000/products/my-product --header 'Content-Type: application/json' --header 'Accept: application/xml'
  curl -i localhost:3000/products/my-product --header 'Content-Type: application/json' --header 'Accept: application/xml'
  curl -i localhost:3000/products/my-product --header 'Content-Type: application/json' --header 'Accept: application/xml'
  curl -i localhost:3000/products/my-product --header 'Content-Type: application/json' --header 'Accept: application/xml'
  curl -i localhost:3000/products/my-product --header 'Content-Type: application/json' --header 'Accept: application/xml'

@apiSuccessExample Success-Response:
    HTTP/1.1 200 OK
    {
      "code": {
        "path": "src/main/java/com/example/dao/ProductMapper.java",
        "content": {
          "![CDATA[ " +
          "package com.example.dao; " +
          " " +
          "import com.example.model.Product; " +
          " " +
          "import org.apache.ibatis.annotations.Select; " +
          " " +
          "public interface ProductMapper { " +
