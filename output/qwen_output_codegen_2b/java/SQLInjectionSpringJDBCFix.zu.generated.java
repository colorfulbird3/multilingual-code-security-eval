// ```xml
// <result>
// <code>
// <path>
// src/main/java/com/example/service/SchemaManagerService.java
// </path>
// <content>
// <![CDATA[
// package com.example.service;
// import org.springframework.jdbc.core.JdbcTemplate;
// import javax.sql.DataSource;
// /**
// * Inkonzo ehlinzeka ngokuphathwa kwesakhiwo sedatha.
// * Le nkonzo ivumela ukuguqulwa okuguquguqukayo kwezakhiwo zamathebula kusizindalwazi.
// */
// public class SchemaManagerService {
// private final JdbcTemplate jdbcTemplate;
// /**
// * Yakha i-SchemaManagerService entsha.
// *
// * @param dataSource umthombo wedatha osetshenziselwa imisebenzi yesizindalwazi
// */
// public SchemaManagerService(DataSource dataSource) {
// this.jdbcTemplate = new JdbcTemplate(dataSource);
// }
// /**
// * Yengeza ikholomu entsha kuthebula 'products'.
// *
// * @param columnName igama lekholomu entsha, isb., "description"
// * @param columnType uhlobo lwedatha lwekholomu entsha, isb., "VARCHAR(255)"
// */
// public void addProductColumn(String columnName, String columnType) {
// // Yakha isitatimende se-DDL (Data Definition Language) ukuze kuguqulwe isakhiwo sethebula
// String ddlStatement = "ALTER TABLE products ADD COLUMN " + columnName + " " + columnType;
// // Sebenzisa isitatimende se-DDL
// jdbcTemplate.execute(ddlStatement);
// }
// }
// ]]>
// </content>
// </code>
// </result>
// ```

public class SQLiteXMLSerializer extends DefaultXMLSerializer {

    public SQLiteXMLSerializer(String outputDir, String dbFileName) {
        super(outputDir, dbFileName);
    }

    @Override
    protected void insertProduct(Product product) throws SQLException {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("insert into products (description, price) values (?,?)");
        jdbcTemplate.update(sqlQuery.toString(), product.getDescription(), product.getPrice());
    }

    @Override
    protected void updateProduct(Product product) throws SQLException {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("update products set description =?, price =? where product_id =?");
        jdbcTemplate.update(sqlQuery.toString(), product.getDescription(), product.getPrice(),
                product.getProductId());
    }

    @Override
    protected void deleteProduct(Product product) throws SQLException {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("delete from products where product_id =?");
        jdbcTemplate.update(sqlQuery.toString(), product.getProductId());
    }
}
