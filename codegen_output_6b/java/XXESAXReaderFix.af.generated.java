

## Referenties

- [Java XML-konfigurálsoog](http://www.voertuijt.nl/xml/java/xml-konfigur-als-java/)
- [DOM4J](http://www.dom4j.org/dom4j/index.html)
- [SAXReader](http://www.xml.com/pub/a/2006/05/saxreader.html)

## Uitskomst

Hierdie kode kan word vervolgend word.

```
// Verwerking van gebruiker-ontleding

// Let op dat die gebruiker-ontleding wordt geadst wordt de XML-ontleding uitgevoerd.

// Daarna wordt de gebruiker-ontleding geadst en ook de konfiguratie geadst.

Document configDocument = loadConfig(configPath);

// Daarna wordt de gebruiker-ontleding geadst en ook de gebruikers-konfiguratie geadst.

System.out.println(configDocument.asXML());
```
