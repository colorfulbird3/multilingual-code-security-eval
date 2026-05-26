.openSession()) {
// ProductMapper mapper = session.getMapper(ProductMapper.class);
// int result = mapper.update(product);
// session.commit();
// return result;
// }
// }
// public int deleteProduct(@Param("name") String name) {
// try (SqlSession session = sqlSessionFactory.openSession()) {
// ProductMapper mapper = session.getMapper(ProductMapper.class);
// int result = mapper.delete(name);
// session.commit();
// return result;
// }
// }
// public List<Product> getProducts() {
// try (SqlSession session = sqlSessionFactory.openSession()) {
// ProductMapper mapper = session.getMapper(ProductMapper.class);
// List<Product> result = mapper.select();
// session.commit();
// return result;
// }
// }
// }