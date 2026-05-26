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