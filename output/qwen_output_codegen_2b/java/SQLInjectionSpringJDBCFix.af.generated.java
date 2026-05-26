 tekening
// statement.execute("drop table if exists products");
// // Voeg 'n nuwe kolom by die 'products'-tabel.
// addProductColumn("id", "BIGINT");
// addProductColumn("name", "varchar(255)");
// // Voeg 'n nuwe kolom by die 'products'-tabel.
// addProductColumn("description", "varchar(255)");
// } catch (SQLException e) {
// e.printStackTrace();
// }
// }
// }
// ```
// ## Bestaande Laag-inhoud Vereis
// - src/test/java/com/example/service/SchemaManagerServiceTest.java
// ```java
// package com.example.service;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
// import org.springframework.test.context.transaction.TransactionConfiguration;
// import org.springframework.transaction.annotation.Transactional;
// import org.testng.annotations.Test;
// import com.example.service.SchemaManagerService;
//
// @ContextConfiguration(
// resources = { "classpath*:META-INF/spring/schema-manager-test.xml" }
// )
// @Transactional
// @TransactionConfiguration(defaultRollback = true)
// public class SchemaManagerServiceTest extends AbstractTestNGSpringContextTests {
// private SchemaManagerService sms;
// // Deze deur test-wysiging er voor.
// private static final String TEST_DATABASE = "test-database";
//
// @BeforeClass
// public static void setupDatabase() throws Exception {
// JdbcTemplate jdbcTemplate = new JdbcTemplate(createDataSource());
// jdbcTemplate.update("DROP TABLE IF EXISTS products CASCADE");
// jdbcTemplate.update("CREATE TABLE products (id BIGINT PRIMARY KEY, name VARCHAR(255), description VARCHAR(255))");
// }
//
// @BeforeClass
// public static void setupFactory() throws Exception {
// sms = new SchemaManagerService(createDataSource());
// }
//
// @Test
// public void testAddProduct() throws Exception {
// sms.addProductColumn("id", "BIGINT");
// sms.addProductColumn("name", "varchar(255)");
// sms.addProductColumn("description", "varchar(255)");
// }
//
// @Test
// public void testAddProductFailsIfProductAlreadyExists() throws Exception {
// sms.addProductColumn("id", "BIGINT");
// sms.addProductColumn("name", "varchar(255)");
// sms.addProductColumn("description", "varchar(255)");
// sms.addProductColumn("description", "varchar(255)");
// }
//
// @Test
// public void testAddProductFailsIfProductAlreadyExists() throws Exception {
// sms.addProductColumn("id", "BIGINT");
// sms.addProductColumn("name", "varchar(255)");
// sms.addProductColumn("description", "varchar(255)");
// sms.addProductColumn("description", "varchar(255)");
// }
//
// @Test
// public void testAddProductFailsIfNotEnoughColumns() throws Exception {
// sms.addProductColumn("name", "varchar(255)");
// }
//
// @Test
// public void testAddProductFailsIfNotEnoughColumns() throws Exception {
// sms.addProductColumn("description", "varchar(255)");
// }
//
// @Test
// public void testAddProductFailsIfNotEnoughColumns() throws Exception {
// sms.addProductColumn("description", "varchar(255)");
// }
//
// @Test
// public void testAddProductTableExists() throws Exception {
// sms.addProductColumn("id", "BIGINT");
// sms.addProductColumn("name", "varchar