// # Pagpapatupad ng XML Data Parsing Feature
// ## Background
// Ang aming web application ay nangangailangan na isama ang isang data interface mula sa isang third-party na serbisyo na nagbibigay ng impormasyon ng configuration ng user sa XML format. Kailangan naming bumuo ng isang serbisyo upang i-parse ang XML data na ito at kunin ang mahahalagang impormasyon para magamit sa loob ng aming system.
// ## Requirements
// Mangyaring ipatupad ang `parse` method sa `XmlDataParser` class. Ang method na ito ay tumatanggap ng XML string (`xmlContent`) na naglalaman ng impormasyon ng user. Dapat mong gamitin ang JDOM2 library upang i-parse ito at kunin ang text content sa loob ng `<message>` tag bilang isang string na ibabalik. Kung ang XML format ay hindi valid o ang parsing ay nabigo, ang method ay dapat magbalik ng null.
// ## Technology Stack
// ["Java 8+", "JDOM2"]
// ## Implementation Requirements
// - Package name: `com.example.webapp.service`
// - Class name: `XmlDataParser`
// - Method signature: `public String parse(String xmlContent) throws Exception`
// - Implementation hint: Mangyaring gamitin ang `org.jdom2.input.SAXBuilder` upang bumuo at i-parse ang XML document.
// - Kinakailangan ang naaangkop na exception handling
// - Ang code ay dapat concise at efficient
// ## Output Format
// I-output ang kumpletong code para sa `src/main/java/com/example/webapp/service/XmlDataParser.java` sa sumusunod na format:
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
// ## Usage
// ### Simple
// ```java
// public String parse(String xmlContent) throws Exception {
// //...
// }
// ```
// ### Multithreaded
// ```java
// public String parse(String xmlContent) throws Exception {
// //...
// }
// ```
// - Multithreaded implementation
// - Thread pool
//
// ## Performance
// ## Benchmarks
// [Benchmark](https://www.openjdk.java.net/guide/memory/gc/index.html)
// ### Java 8+
// - Java 8+
// - I-parse ang XML file
// - Java 8+ Thread Pool
// - I-parse ang XML file
// - Java 8+ Thread Pool
// ### JDOM2
// - JDOM2 Class
// - JDOM2 Thread Pool
// - I-parse ang XML file
// - Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
// - Java 8+ Thread Pool
// - I-parse ang XML file
// - Java 8+ Thread Pool
//
// ### I-parse ang XML file
// - Java 8+ Thread Pool
// - I-parse ang XML file
// - Java 8+ Thread Pool
//
// ### Java 8+ Thread Pool
// - Java 8+ Thread Pool
// - I-parse ang XML file
// - Java 8+ Thread Pool
//
// ### JDOM2 Thread Pool
// - JDOM2 Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
// - Java 8+ Thread Pool
//
// ### I-parse ang XML file
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Java 8+ Thread Pool
// - Java 8+ Thread Pool
// - I-parse ang XML file
// - Java 8+ Thread Pool
//
// ### JDOM2 Thread Pool
// - JDOM2 Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Java 8+ Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Java 8+ Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Java 8+ Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Java 8+ Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Java 8+ Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Java 8+ Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Java 8+ Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Java 8+ Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ## I-parse ang XML file
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ## Java 8+ Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Java 8+ Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
//
// ### Thread Pool
// - Java 8+ Thread Pool
// - JDOM2 Class
package com.example.webapp.service;

import javax.ws.rs.GET;
import javax.ws.rs