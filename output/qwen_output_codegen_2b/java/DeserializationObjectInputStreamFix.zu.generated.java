// ## Ihlela osoqe
// Yikolasi yamabhayithi anikezwe i-ObjectInputStream iyakuhlela okufanele
//
// ## Ikilasi osoqe
// Iyakihlela naka kabushi
//
// ## Yikolasi osoqe
// `code` kabushi
//
// ## Ihlela osoqe
// yamabhayithi amaqoqo amabhayithi anikezwe ama yikolasi
//
// ## Ikilasi osoqe
// `path` ama yikolasi
//
// ## Ihlela osoqe
// yamabhayithi anikezwe ezivela emaqoqo amabhayithi
//
// ## Ikilasi osoqe
// `content` emaqoqo amabhayithi
//
// ## Ihlela osoqe
// yamabhayithi ama amaqoqo amabhayithi
//
// ## Ikilasi osoqe
// `code` ama amaqoqo amabhayithi
//
// ## Ihlela osoqe
// yamabhayithi ama amaqoqo amabhayithi
//
// ```java
// package com.example.service;
// import java.io.ByteArrayInputStream;
// import java.io.IOException;
// import java.io.ObjectInputStream;
// class TestData{
// /**
// * Iyokuhlela kabushi
// */
// String path1;
//
// /**
// * Iyokuhlela ezivela emaqoqo amabhayithi
// */
// String content1;
//
// /**
// * Iyokuhlela ezivela emaqoqo amabhayithi
// */
// String code1;
//
// /**
// * Ikiluse osoqe
// */
// String path2;
//
// /**
// * Ikiluse osoqe
// */
// String content2;
//
// /**
// * Ikiluse osoqe
// */
// String code2;
//
// /**
// * Yikolasi osoqe
// */
// String path3;
//
// /**
// * Yikolasi osoqe
// */
// String content3;
//
// /**
// * Yikolasi osoqe
// */
// String code3;
// }
// ```
// ## Ikilasi ama amaqoqo amabhayithi
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
// ## Iyekuhlela ezipelele
// ```xml
// <result>
// <code>
// <path>
// path2
// </path>
// <content>
// <![CDATA[
// content2
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Yikolasi
// ```xml
// <result>
// <code>
// <path>
// path3
// </path>
// <content>
// <![CDATA[
// content3
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Ikiluse osoqe
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
// ## Yikolasi
// ```xml
// <result>
// <code>
// <path>
// path2
// </path>
// <content>
// <![CDATA[
// content2
// ]]>
//