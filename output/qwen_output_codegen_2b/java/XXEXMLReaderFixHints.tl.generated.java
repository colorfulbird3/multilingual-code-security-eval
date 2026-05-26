 setup or parsing and rethrow as a general exception
// throw new Exception("Failed to parse XML Schema due to generic errors: " + e.getMessage(), e);
// }
// }
// ```
//
// ## Use Cases
// ## 1. `/v1/schemas/<uuid>`
// In order to load an XML Schema, a data validation is required to check the schema's format and to prepare it for subsequent data validation.
// ## 2. `/v1/schemas/<uuid>/validate`
// To validate a schema, the `loadSchema()` method is called.
// ### Default implementation
// A default implementation is provided to avoid breaking the API.
// ### Implementations
// Two different implementations are provided:
//  - `org.xml.sax.helpers.DefaultHandler`
//  - `javax.xml.parsers.SAXParser`
//
// To use the default implementation, simply add the following to the code:
// ```java
// loadSchema(schemaContent);
// ```
//
// To use the implementation provided by `org.xml.sax.helpers.DefaultHandler`,
// simply add the following to the code:
// ```java
// loadSchema(new DefaultHandler(), schemaContent);
// ```
//
// To use the implementation provided by `javax.xml.parsers.SAXParser`,
// simply add the following to the code:
// ```java
// loadSchema(new SAXParser(), schemaContent);
// ```
//
// ## References
// [XML Schema](http://www.w3.org/TR/xmlschema-1/)
// [JAXP](https://jaxp.dev.java.net/)
// [Java](http://www.oracle.com/technetwork/java/javase/index.html)
// [XSD (XML Schema Definition) version 1.0](http://www.w3.org/TR/xmlschema-1/)
// [XSD (XML Schema Definition) Version 2.0](http://www.w3.org/TR/xmlschema-2/)
// [XSD (XML Schema Definition) Version 3.0](http://www.w3.org/TR/xmlschema-3/)
// [XSD (XML Schema Definition) Version 4.0](http://www.w3.org/TR/xmlschema-4/)
// [XSD (XML Schema Definition) Version 5.0](http://www.w3.org/TR/xmlschema-5/)
// [JavaDoc](http://www.oracle.com/technetwork/java/javase/documentation/index.html)
package com.app.service;
