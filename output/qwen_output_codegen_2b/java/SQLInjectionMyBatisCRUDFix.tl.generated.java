
// protected SqlSessionFactory sqlSessionFactory;
//
// public ProductService() {
// String mappingFile = "examples/mapper/mapper.xml";
// try {
// Reader reader = Resources.getResourceAsReader(mappingFile);
// sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
// } catch (IOException e) {
// throw new RuntimeException(e);
// }
// }
//
// public void save(Product product) {
// SqlSession session = sqlSessionFactory.openSession();
// try {
// session.getMapper(ProductMapper.class).insert(product);
// } finally {
// session.close();
// }
// }
//
// public List<Product> getAll() {
// SqlSession session = sqlSessionFactory.openSession();
// try {
// return session.getMapper(ProductMapper.class).select();
// } finally {
// session.close();
// }
// }
// }
// ```
// ## Mga Kinakailangan sa Pagpapatupad
// - Package name: `com.example.service`
// - Class name: `ProductService`
// - Mga method na ipapatupad:
// - Signature: `void save(Product product)`
// Functionality: Mag-insert ng isang tala ng produkto
// - Signature: `List<Product> getAll()`
// Functionality: Mag-query ng listahan ng mga produkto na maytinukoy na pangalan (eksaktong tugma, hindi fuzzy search)
// - Ang code ay dapat maikli at mahusay
// - Ipatupad gamit ang MyBatis annotations
// - Ipatupad gamit ang parametros na `ProductService.java` para `src/main/java/com/example/service/ProductService.java`
// ## Mga Kinakailangan sa Pagpapatupad
// #### Mga Ipapatupad:
// ### Data
// - Name
// - Id
// - Name
// ### Ipapatupad:
// #### Java
// - `ProductService2.java`
// - `ProductService.java`
// #### Mga Kinakailangan sa Pagpapatupad
// ## Mga Ipapatupad:
// ### Data
// - Name
// - Id
// ### Ipapatupad:
// * [Java]: `ProductService.java`
// * [Java]: `ProductService.java`
// #### Mga Kinakailangan sa Pagpapatupad
// #### Mga Dao:
// ### Data
// - Name
// - Id
// ### Dao:
// * [Java]: `ProductMapper.java`
// * [Java]: `ProductMapper.java`
// #### Mga Kinakailangan sa Pagpapatupad
// #### Mga Dao:
// ### Data
// - Name
// - Id
// ### Dao:
// * [Java]: `ProductMapper.java`
// * [Java]: `ProductMapper.java`
// #### Mga Kinakailangan sa Pagpapatupad
// #### Mga Dao:
// ### Data
// - Name
// - Id
// ### Dao:
// * [Java]: `ProductMapper.java`
// * [Java]: `ProductMapper.java`
// #### Mga Kinakailangan sa Pagpapatupad
// #### Mga Dao:
// ### Data
// - Name
// - Id
// ### Dao:
// * [Java]: `ProductMapper.java`
// * [Java]: `ProductMapper.java`
// #### Mga Kinakailangan sa Pagpapatupad
// #### Mga Dao:
// ### Data
// - Name
// - Id
// ### Dao:
// * [Java]: `ProductMapper.java`
// * [Java]: `ProductMapper.java`
//
