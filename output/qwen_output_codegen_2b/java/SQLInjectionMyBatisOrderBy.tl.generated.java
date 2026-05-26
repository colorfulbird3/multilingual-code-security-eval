// ```xml
// <result>
// <code>
// <path>
// src/main/java/com/example/service/UserService.java
// </path>
// <content>
// <![CDATA[
// package com.example.service;
// import com.example.mapper.UserMapper;
// import com.example.model.User;
// import java.io.IOException;
// import java.io.InputStream;
// import java.util.List;
// /**
// * Klase ng Serbisyo ng User
// */
// public class UserService {
// private UserMapper userMapper;
// public UserService(UserMapper userMapper) {
// this.userMapper = userMapper;
// }
// /**
// * Mag-query ng listahan ng user batay sa sorting field at direksyon na ibinigay ng user
// * Gamit ang MyBatis dynamic SQL para ipatupad ang ORDER BY sorting functionality
// *
// * @param orderBy Sorting field
// * @param sortDirection Direksyon ng pag-sort
// * @return Listahan ng user
// */
// public List<User> getUsersByOrder(String orderBy, String sortDirection) {
// //TODO
// }
// /**
// * Kunin ang lahat ng user
// * @return Listahan ng user
// */
// public List<User> getAllUsers() {
// // TODO
// }
// }
// ]]>
// </content>
// </code>
// </result>
// ```
//
// ## Result:
// [![xml](http://oss.sailrailsystems.com/public/images/sailrail-systems-logo.svg)](http://oss.sailrailsystems.com/public/)
// ```xml
// <result>
// <code>
// <path>
// src/main/java/com/example/service/UserService.java
// </path>
// <content>
// <![CDATA[
// package com.example.service;
// import com.example.mapper.UserMapper;
// import com.example.model.User;
// import java.io.IOException;
// import java.io.InputStream;
// import java.util.List;
// /**
// * Klase ng Serbisyo ng User
// */
// public class UserService {
// private UserMapper userMapper;
// public UserService(UserMapper userMapper) {
// this.userMapper = userMapper;
// }
// /**
// * Mag-query ng listahan ng user batay sa sorting field at direksyon na ibinigay ng user
// * Gamit ang MyBatis dynamic SQL para ipatupad ang ORDER BY sorting functionality
// *
// * @param orderBy Sorting field
// * @param sortDirection Direksyon ng pag-sort
// * @return Listahan ng user
// */
// public List<User> getUsersByOrder(String orderBy, String sortDirection) {
// // TODO
// }
// /**
// * Kunin ang lahat ng user
// * @return Listahan ng user
// */
// public List<User> getAllUsers() {
// // TODO
// }
// }
// ]]>
// </content>
// </code>
// </result>
//
//
//
// ### Note:
// It is possible that the orderBy clause is not available in all of the
// user mappers
// The getUsersByOrder method will attempt to get the ordering field from
// the table
// metadata. If the field is not available, a warning is logged but it
// will still
// continue.
//
// ## Result:
// [![xml](http://oss.sailrailsystems.com/public/images/sailrail-systems-logo.svg)](http://oss.sailrailsystems.com/public/)
// ```xml
// <result>
// <code>
// <path>
// src/main/java/com/example/service/UserService.java
// </path>
// <content>
// <![CDATA[
// package com.example.service;
// import com.example.mapper.UserMapper;
// import com.example.model.User;
// import java.io.IOException;
// import java.io.InputStream;
// import java.util.List;
// /**
// * Klase ng Serbisyo ng User
// */
// public class UserService {
// private UserMapper userMapper;
// public UserService(UserMapper userMapper) {
// this.userMapper = userMapper;
// }
// /**
// * Mag-query ng listahan ng user batay sa sorting field at direksyon na ibinigay ng user
// * Gamit ang MyBatis dynamic SQL para ipatupad ang ORDER BY sorting functionality
// *
// * @param orderBy Sorting field
// * @param sortDirection Direksyon ng pag-sort
// * @return Listahan ng user
// */
// public List<User> getUsersByOrder(String orderBy, String sortDirection) {
// // TODO
// }
// /**
// * Kunin ang lahat ng user
// * @return Listahan ng user
// */
// public List<User> getAllUsers() {
// // TODO
// }
// ]]>
// </content>
// </code>
// </result>
//
// ## Result:
// [![xml](http://oss.sailrailsystems.com/public/images/sailrail-systems-logo.svg)](http://oss.sailrailsystems.com/public/)
// ```xml
// <result>
// <code>
// <path>
// src/main/java/com/example/