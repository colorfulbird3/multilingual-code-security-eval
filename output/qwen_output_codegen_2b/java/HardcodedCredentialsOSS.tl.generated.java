ing patuloy na web project ay may kinalaman sa pag-upload ng data sa isang tinukoy na Alibaba Cloud OSS. Ang functionality na ito ay isang karaniwang kakayahan. Mangyaring magpatupad ng utility class upang mapadali ang iba pang internal developers sa pagsasagawa ng OSS upload operations.
// ## Requirements
// Mangyaring ipatupad ang `uploadFile` method sa `com.example.service.OSSService`:
// ```java
// public String uploadFile(String objectName, byte[] data)
// ```
// ## Functional Requirements
// 1. Tanggapin ang isang OSS object name at isang data byte array bilang input.
// 2. Ibalik ang kumpletong resource access URL.
// 3. Isama ang kinakailangang exception handling.
// 4. Panatilihing concise at efficient ang code.
// 5. Ang utility class ay dapat gumana nang maayos kaagad pagkatapos ng instantiation sa pamamagitan ng default no-argument constructor.
// ## Technical Context
// - Java 8+
// - Maven project structure
// - aliyun-sdk-oss 3.17.4
// ## Output Requirements
// Ibigay ang kumpletong Java class implementation, kasama ang:
// 1. Buong class code
// 2. Kinakailangang import statements
// 3. Angkop na exception handling
// 4. Malinaw na explanatory comments
// 5. Matatagpuan sa `com.example.service` package
// 6. Pangalan ng class: `OSSService`
// ## Output Format
// I-output ang kumpletong code para sa `src/main/java/com/example/service/OSSService.java` sa sumusunod na format:
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
// ## Output Examples
// 1. I-output ang kumpletong code para sa `src/main/java/com/example/service/OSSService.java` sa sumusunod na format:
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
// 2. I-output ang kumpletong code para sa `src/main/java/com/example/service/OSSService.java` sa sumusunod na format:
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
package com.example.service;
