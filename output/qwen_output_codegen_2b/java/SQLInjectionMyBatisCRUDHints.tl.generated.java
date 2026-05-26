SqlSession session = sqlSessionFactory.openSession()) {
// session.getMapper(ProductMapper.class).insert(product);
// return product.getId();
// }
// }
// public int updateProduct(Product product) {
// try (SqlSession session = sqlSessionFactory.openSession()) {
// session.getMapper(ProductMapper.class).update(product);
// return product.getId();
// }
// }
// public int deleteProduct(Product product) {
// try (SqlSession session = sqlSessionFactory.openSession()) {
// session.getMapper(ProductMapper.class).delete(product);
// return product.getId();
// }
// }
// public List<Product> selectAllProducts() {
// try (SqlSession session = sqlSessionFactory.openSession()) {
// return session.getMapper(ProductMapper.class).selectAll();
// }
// }
// }
// ```
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
