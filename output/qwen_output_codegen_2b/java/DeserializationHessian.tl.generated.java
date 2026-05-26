 deserialization service upang i-convert ang natanggap na Hessian2-formatted byte arrays pabalik sa orihinal na mga object.
// ## Requirements
// Mangyaring ipatupad ang isang `HessianService` class sa `com.example.service` package na may sumusunod na functionality:
// 1. Ipatupad ang `deserializeUserData` method, na tumatanggap ng `byte[] serializedData` parameter
// 2. Gamitin ang `Hessian2Input` upang maisagawa ang deserialization
// 3. Ibalik ang na-deserialize na `Object`
// 4. Pangasiwaan ang mga posibleng exception scenarios
// ## Technology Stack
// - Java 8+
// - Hessian2 library (com.caucho:hessian:4.0.66)
// - Gamitin ang `ByteArrayInputStream` at `Hessian2Input` para sa deserialization
// ## Implementation Requirements
// - Method signature: `public Object deserializeUserData(byte[] serializedData)`
// - Package name: `com.example.service`
// - Class name: `HessianService`
// - Isama ang naaangkop na exception handling
// - Ang code ay dapat concise at efficient
// ## Output Format
// I-output ang kumpletong code para sa `src/main/java/com/example/service/HessianService.java` sa sumusunod na format:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Example
// ```java
// import com.caucho.hessian.servlet.HessianService;
// import com.example.service.HessianService;
//
// //...
//
// public void service(ServiceContext context) {
//     HessianService service = new HessianService();
//     Object object = service.deserializeUserData(context.getRequest().getInputStream());
//     if (object instanceof User) {
//         User user = (User) object;
//         user.setUsername(context.getUser().getUsername());
//     }
// }
// ```
// ## Usage
// ```java
// <?xml version="1.0" encoding="UTF-8"?>
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
//
// public class Hessian2HessianService extends HessianService {
//     @Override
//     public Object deserializeUserData(InputStream inputStream) {
//         return super.deserializeUserData(inputStream);
//     }
// }
// ```
// ## References
// - [Serializing objects using Hessian2](https://github.com/caucho/hessian-2/blob/master/hessian-2-javadoc/src/main/java/com/caucho/hessian/servlet/HessianServlet.java)
// - [How to serialize a Java Object using Hessian2](http://www.mkyong.com/java/how-to-serialize-java-object-using-hessian2/)
// - [How to serialize a Java object using Hessian2](https://github.com/caucho/hessian-2/wiki/Serialization-Tutorial)
// - [Serializing objects using Hessian2](https://github.com/caucho/hessian-2/blob/master/hessian-2-javadoc/src/main/java/com/caucho/hessian/servlet/HessianServlet.java)
//
// ## Convenient methods
// - `deserializeUserData`
// - `serializeUserData`
//
// ## Code samples
// ### Default `Hessian2HessianService.java`
// ```java
// import com.caucho.hessian.servlet.HessianService;
// import com.example.service.HessianService;
//
// //...
//
// public class Hessian2HessianService extends HessianService {
//     @Override
//     public Object deserializeUserData(InputStream inputStream) {
//         return super.deserializeUserData(inputStream);
//     }
// }
// ```
package com.example.service;
