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
// * Isang serbisyo na nagbibigay ng pamamahala sa schema ng database.
// * Ang serbisyong ito ay nagpapahintulot ng dinamikong pagbabago ng mga istruktura ng talahanayan sa database.
// */
// public class SchemaManagerService {
// private final JdbcTemplate jdbcTemplate;
// /**
// * Bumubuo ng bagong instance ng SchemaManagerService.
// *
// * @param dataSource ang data source na ginagamit para sa mga operasyon sa database
// */
// public SchemaManagerService(DataSource dataSource) {
// this.jdbcTemplate = new JdbcTemplate(dataSource);
// }
// /**
// * Nagdaragdag ng bagong column sa talahanayan na 'products'.
// *
// * @param columnName ang pangalan ng bagong column, halimbawa: "description"
// * @param columnType ang uri ng datos ng bagong column, halimbawa: "VARCHAR(255)"
// */
// public void addProductColumn(String columnName, String columnType) {
// // Bumuo ng DDL (Data Definition Language) statement para baguhin ang istruktura ng talahanayan
// String ddlStatement = "ALTER TABLE products ADD COLUMN " + columnName + " " + columnType;
// // Isagawa ang DDL statement
// jdbcTemplate.execute(ddlStatement);
// }
// }
// ]]>
// </content>
// </code>
// </result>
// ```
//
// @author Wonho Lim
// @since 1.0.0
// @param <C> the type of an entity class
// @param <K> the type of a primary key
// @see org.springframework.data.jpa.repository.JpaRepository
public interface JpaRepository<C, K> extends Repository<C, K> {

    @Override
    <T> Page<T> findAll(Specification<T> spec, Pageable pageable);

    @Override
    <T> List<T> findAll(Specification<T> spec);

    @Override
    <T> Iterable<T> findAll(Iterable<K> ids);

    @Override
    <T> T findOne(Specification<T> spec);

    @Override
    <T> T findOne(K id);

    @Override
    <T> T getOne(Specification<T> spec, Object id);

    @Override
    <T> T merge(T t);

    @Override
    <T> T save(T t);

    @Override
    void delete(K id);

    @Override
    void delete(Specification<T> spec);

    @Override
    void delete(Specification<T> spec, Object id);

}
