package com.mycompany.myapp.dao.ibatis2;

import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.apache.ibatis.config.Configuration;
import org.apache.ibatis.mapping.ConnectionFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * @author GavinK
 */
public class MyBatis2SqlSessionFactoryBuilder extends
		DefaultSqlSessionFactoryBuilder {

	private static final Logger LOG = LoggerFactory
			.getLogger(MyBatis2SqlSessionFactoryBuilder.class);

	protected SqlSessionFactory build(Reader reader,
			Configuration configuration) throws Exception {
		Preconditions.checkArgument(reader!= null, "reader shouldn't be null");
		Preconditions.checkArgument(configuration!= null,
				"configuration shouldn't be null");
		XMLMapperEntityResolver entityResolver = new XMLMapperEntityResolver();
		configuration.setEntityResolver(entityResolver);
		return doBuild(reader, configuration);
	}

	protected SqlSessionFactory build(Reader reader,
			Environment environment) throws Exception {
		Preconditions.checkArgument(reader!= null, "reader shouldn't be null");
		Preconditions.checkArgument(environment!= null,
				"environment shouldn't be null");
		return doBuild(reader, environment);
	}

	protected SqlSessionFactory doBuild(Reader reader,
			Configuration configuration) throws Exception {
		return new SqlSessionFactory(reader, configuration);
	}

	protected SqlSessionFactory doBuild(Reader reader,
			Environment environment) throws Exception {
		return new SqlSessionFactory(reader, environment);
	}

	protected SqlSessionFactory doBuild(Connection connection,
			Configuration configuration) throws Exception {
		return new SqlSessionFactory(connection, configuration);
	}

	protected SqlSessionFactory doBuild(Connection connection,
			Environment environment) throws Exception {
		return new SqlSessionFactory(connection, environment);
	}

	protected SqlSessionFactory doBuild(ConnectionFactory connectionFactory,
			Configuration configuration) throws Exception {
		return new SqlSessionFactory(connectionFactory, configuration);
	}

	protected SqlSessionFactory doBuild(ConnectionFactory connectionFactory,
			Environment environment) throws Exception {
		return new SqlSessionFactory(connectionFactory, environment);
	}

	@Override
	protected void initializeDefaults(Configuration configuration) {
		super.initializeDefaults(configuration);
		configuration.setUseGeneratedKeys(true);
		configuration.setUseColumnLabel(true);
		configuration.setLazyLoadingEnabled(false);
	}

	@Override
	protected void initializeBuilderContext(BuilderContext context) {
		context.addInput("daoConfig", new MyBatis2DaoConfig());
		context.addInput("sqlSessionFactory", new MyBatis2SqlSessionFactory());
	}

	@Override
	protected String getStatementId(ResultSet rs) throws SQLException {
		return rs.getStatementId();
	}

	@Override
	protected String getResultSetId(List<String> statements) {
		StringBuilder result = new StringBuilder();
		for (String statement : statements) {
			for (String line : statement.split("\n")) {
				String trimmed = line.trim();
				if (isComment(trimmed)) {
					continue;
				}
				result.append(line).append(',');
			}