 = mapper.insert(product);
// session.commit();
// return result;
// }
// }
// public Product selectProduct(@Param("name") String name) {
// try (SqlSession session = sqlSessionFactory.openSession()) {
// ProductMapper mapper = session.getMapper(ProductMapper.class);
// return mapper.select(name);
// }
// }
// public List<Product> selectAllProducts() {
// try (SqlSession session = sqlSessionFactory.openSession()) {
// ProductMapper mapper = session.getMapper(ProductMapper.class);
// return mapper.selectAll();
// }
// }
// public void updateProduct(Product product) {
// try (SqlSession session = sqlSessionFactory.openSession()) {
// ProductMapper mapper = session.getMapper(ProductMapper.class);
// mapper.update(product);
// session.commit();
// }
// }
// public void deleteProduct(@Param("name") String name) {
// try (SqlSession session = sqlSessionFactory.openSession()) {
// ProductMapper mapper = session.getMapper(ProductMapper.class);
// mapper.delete(name);
// session.commit();
// }
// }
// }
// ```
// - src/main/resources/mybatis-config.xml
// ```xml
// <mybatis-configuration xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
// <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
// <property name="dataSource" ref="dataSource"/>
// <property name="mapperLocations" value="classpath:mybatis-config.xml"/>
// </bean>
// </mybatis-configuration>
// ```
// *
// * ## Boodschap
// *
// * ProductMapper mapper = sqlSessionFactory.getMapper(ProductMapper.class);
// * Product product = mapper.selectProduktByNaam("product");
// * mapper.update(product);
// *
// * ## Boodschap
// *
// * ProductMapper mapper = sqlSessionFactory.getMapper(ProductMapper.class);
// * Product product = mapper.selectProduktByNaam("product");
// * mapper.update(product);
// *
// * ## Boodschap
// *
// * ProductMapper mapper = sqlSessionFactory.getMapper(ProductMapper.class);
// * Product product = mapper.selectProduktByNaam("product");
// * mapper.delete(product);
// *
// * ## Boodschap
// *
// * ProductMapper mapper = sqlSessionFactory.getMapper(ProductMapper.class);
// * Product product = mapper.selectProduktByNaam("product");
// * mapper.delete(product);
// *
// * ## Boodschap
// *
// * ProductMapper mapper = sqlSessionFactory.getMapper(ProductMapper.class);
// * Product product = mapper.selectProduktByNaam("product");
// * mapper.update(product);
// *
// * ## Boodschap
// *
// * ProductMapper mapper = sqlSessionFactory.getMapper(ProductMapper.class);
// * Product product = mapper.selectProduktByNaam("product");
// * mapper.update(product);
// *
// * ## Boodschap
// *
// * ProductMapper mapper = sqlSessionFactory.getMapper(ProductMapper.class);
// * Product product = mapper.selectProduktByNaam("product");
// * mapper.update(product);
// *
// * ## Boodschap
// *
// * ProductMapper mapper = sqlSessionFactory.getMapper(ProductMapper.class);
// * Product product = mapper.selectProduktByNaam("product