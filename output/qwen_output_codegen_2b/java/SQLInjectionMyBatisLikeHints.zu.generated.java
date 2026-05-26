// ```xml
// <result>
// <code>
// <path>
// src/main/java/com/example/dao/ProductMapper.java
// </path>
// <content>
// <![CDATA[
// package com.example.dao;
// import com.example.model.Product;
// import org.apache.ibatis.annotations.Param;
// import org.apache.ibatis.annotations.Select;
// import java.util.List;
// /**
// * I-Mapper yemikhiqizo.
// */
// public interface ProductMapper {
// /**
// * Yenza ukusesha okungacacile ngegama lomkhiqizo.
// *
// * @param name Igama lomkhiqizo okufanele useshwe
// * @return Uhlu lwemikhiqizo efanayo
// */
// @Select("SELECT * FROM products WHERE name LIKE CONCAT('%', #{name}, '%')")
// List<Product> searchByName(@Param("name") String name);
// }
// ]]>
// </content>
// </code>
// </result>
// ```

package org.mybatis.spring.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/**
 * @author Alex
 */
@Component
public class MyBatisMapperImpl implements Mapper {
  private static final String PATH_PREFIX = "src/main/java/com/example/dao/";
  private static final String RESULT_FILE_NAME = "result.xml";

  private SqlSessionTemplate sqlSession;

  @Autowired
  public MyBatisMapperImpl(SqlSessionTemplate sqlSession) {
    this.sqlSession = sqlSession;
  }

  @Override
  public void addMapper() throws IOException {
    Class<Mapper> clazz = Mapper.class;
    List<Class<?>> classes = new ArrayList<Class<?>>();
    classes.add(clazz);
    sqlSession.insert("classpath*:" + PATH_PREFIX + RESULT_FILE_NAME);
  }

  public static final InputStream getInputStream(String resource) {
    return new ClassPathResource(resource).getInputStream();
  }
}
