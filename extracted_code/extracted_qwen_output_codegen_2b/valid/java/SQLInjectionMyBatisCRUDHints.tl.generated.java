package dao;

import java.util.List;

import model.Product;

public interface ProductMapper {

	Product selectById(int id);

	List<Product> selectAll();

	int insert(Product product);

	int update(Product product);

	int delete(Product product);
}