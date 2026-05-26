// ```xml
// <result>
// <code>
// <path>
// src/main/java/com/example/dao/ProductMapper.java
// </path>
// <content>
// <![CDATA[
// package com.example.dao;
// import com.example.model.Product;
// import org.apache.ibatis.annotations.Param;
// import org.apache.ibatis.annotations.Select;
// import java.util.List;
// public interface ProductMapper {
// /**
// * Magsagawa ng fuzzy query batay sa pangalan ng produkto (name)
// * @param name Ang pangalan ng produkto na hahanapin
// * @return Listahan ng mga produktong tugma
// */
// @Select("SELECT * FROM products WHERE name LIKE CONCAT('%', #{name}, '%')")
// List<Product> searchByName(@Param("name") String name);
// }
// ]]>
// </content>
// </code>
// </result>
// ```

// ## Examples
//
// * `$ mongo shell --eval "db.product.find().limit(1)" | grep "name"`
// * `$ mongo shell --eval "db.product.find().limit(1)" | awk '{print "$1"}'`
// * `$ mongo shell --eval "db.product.find().limit(1)" | fgrep "name"`
//

package com.example.dao.mappers;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.List;

public class ProductMapper {

    private final MongoDatabase mongoDatabase;

    public ProductMapper(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    public List<Product> getProducts(String name) {
        return mongoDatabase.getCollection("product").find(Bson.parse("name LIKE '" + name + "'")).limit(1).into(new ProductMapper.ListMapper());
    }

    public void insertProduct(Product product) {
        mongoDatabase.getCollection("product").insertOne(product.getProduct());
    }

    public void updateProduct(Product product) {
        mongoDatabase.getCollection("product").updateOne(
                Bson.parse("{_id: #}", ObjectId.class),
                Bson.parse("{$set: #}", product.getProduct())
        );
    }

    private class ListMapper implements MongoDatabase.ResultSetMapper<List<Product>> {

        @Override
        public List<Product> map(MongoDatabase.ResultSet rs) throws Exception {
            List<Product> products = rs.into(new ProductMapper.ProductMapper());
            return products;
        }
    }

    private class ProductMapper {

        private static final String NAME = "name";
        private static final String ID = "id";

        public ProductMapper(MongoDatabase mongoDatabase) {
            this.mongoDatabase = mongoDatabase;
        }
    }
}

