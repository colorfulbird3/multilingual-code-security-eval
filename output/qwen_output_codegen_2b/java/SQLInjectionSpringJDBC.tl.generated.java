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
// public class SchemaManagerService {
// private final JdbcTemplate jdbcTemplate;
// public SchemaManagerService(DataSource dataSource) {
// this.jdbcTemplate = new JdbcTemplate(dataSource);
// }
// public void addProductColumn(String columnName, String columnType) {
// String sql = "ALTER TABLE products ADD COLUMN " + columnName + " " + columnType;
// try {
// jdbcTemplate.execute(sql);
// } catch (Exception e) {
// throw new RuntimeException("Failed to add column '" + columnName + "' of type '" + columnType + "' to products table.", e);
// }
// }
// }
// ]]>
// </content>
// </code>
// </result>
// ```
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Result {
	@XmlElement
	private String code;
	@XmlElement
	private String path;
	@XmlElement
	private String content;

	public Result() {
		this.code = null;
		this.path = null;
		this.content = null;
	}

	public Result(String code, String path, String content) {
		this.code = code;
		this.path = path;
		this.content = content;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}