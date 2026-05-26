[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Sample XML Data
// - `path` : `/users/{id}`
// - `content` : `<name>name</name>`
// - `id` : `12`
// data:
// ```xml
// <users>
// <user>
// <name>name</name>
// <email>name@gmail.com</email>
// <id>12</id>
// </user>
// </users>
// ```
//
// ## Sample User Profile
// ```java
// package com.example.datamodel.model;
// import javax.xml.bind.annotation.XmlElement;
// import javax.xml.bind.annotation.XmlRootElement;
// /**
// * Represents a user profile data model.
// * This class is used for marshalling and unmarshalling user data from XML.
// */
// @XmlRootElement(name = "userProfile")
// public class UserProfile {
// private String name;
// private String email;
// private long userId;
// @XmlElement
// public String getName() {
// return name;
// }
// public void setName(String name) {
// this.name = name;
// }
// @XmlElement
// public String getEmail() {
// return email;
// }
// public void setEmail(String email) {
// this.email = email;
// }
// @XmlElement
// public long getUserId() {
// return userId;
// }
// public void setUserId(long userId) {
// this.userId = userId;
// }
// @Override
// public String toString() {
// return "UserProfile{" +
// "name='" + name + '\'' +
// ", email='" + email + '\'' +
// ", userId=" + userId +
// '}';
// }
// }
// ```
// ## Sample User Profile Data
// ```xml
// <users>
// <user>
// <name>name</name>
// <email>name@gmail.com</email>
// <id>12</id>
// </user>
// </users>
// ```
// ## Sample User Profile Data
// ```xml
// <users>
// <user>
// <name>name</name>
// <email>name@gmail.com</email>
// <id>12</id>
// </user>
// </users>
// ```
// ## Sample User Profile Data
// ```xml
// <users>
// <user>
// <name>name</name>
// <email>name@gmail.com</email>
// <id>12</id>
// </user>
// <user>
// <name>name</name>
// <email>name@gmail.com</email>
// <id>13</id>
// </user>
// </users>
// ```
//
// ## Sample User Profile Data
// ```xml
// <users>
// <user>
// <name>name</name>
// <email>name@gmail.com</email>
// <id>12</id>
// </user>
// <user>
// <name>name</name>
// <email>name@gmail.com</email>
// <id>13</id>
// </user>
// </users>
// ```
//
// ## Sample User Profile Data
// ```xml
// <users>
// <user>
// <name>name</name>
// <email>name@gmail.com</email>
// <id>12</id>
// </user>
// <user>
// <name>name</name>
// <email>name@gmail.com</email>
// <id>13</id>
// </user>
// </users>
// ```
// ## Sample User Profile Data
// ```xml
// <users>
// <user>
// <name>name</name>
// <email>name@gmail.com</email>
// <id>12</id>
// </user>
// <user>
// <name>name</name>
// <email>name@gmail.com</email>
// <id>13</id>
// </user>
// </users