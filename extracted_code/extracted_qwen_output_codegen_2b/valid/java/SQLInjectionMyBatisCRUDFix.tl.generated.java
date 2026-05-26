package com.example.service;

import com.example.mapper.ProductMapper;
import com.example.model.Product;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ProductService {
    private SqlSessionFactory sqlSessionFactory;

    public ProductService() {
        String mappingFile = "examples/mapper/mapper.xml";
        try {
            Reader reader = Resources.getResourceAsReader(mappingFile);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Product product) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.getMapper(ProductMapper.class).insert(product);
        } finally {
            session.close();
        }
    }

    public List<Product> getAll() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return session.getMapper(ProductMapper.class).select();
        } finally {
            session.close();
        }
    }
}