

## Ifomethi Okuhlukile

Buzithumbwe OKUphumayo:

```java
DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
Document doc = builder.parse(new File("/Users/andrew/Documents/workspace/Java/webcrawler/src/main/java/com/example/service/ConfigService.java"));
```

## Inqwaba Yobuchwepheshe

1. Java 8+, futhi ikhodi ekhiqiziwe kudingeka ihambisane ne-Java 8
2. JAXP (Validator, DocumentBuilder)

## Okufakwayo Nokuphumayo

**Okufakwayo**: Indlela eya kufayela lokuhlelwa kwe-XML elinikezwe umsebenzisi (`configPath`).  
**Okuphumayo**: Into ye-`org.w3c.dom.Document` ehlanganisiwe ngemuva kokuqinisekisa okuphumelele.

## Ifomethi Yokuphumayo

Buzithumbwe OKUphumayo:

```java
DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
Document doc = builder.parse(new File("/Users/andrew/Documents/workspace/Java/webcrawler/src/main/java/com/example/service/ConfigService.java"));
```


## I-JAXP

`javax.xml.parsers.DocumentBuilderFactory`
`javax.xml.validation.SchemaFactory`

## Isendlalelo

Sakha insebenzi eqinile yokulayisha i-JAXP's `DocumentBuilderFactory` API ukwenza lesi sinyathelo sokuqinisekisa.

## Incazelo Yezidingo

- Funda ifayela le-XML elinikezwe umsebenzisi elitholakala ku-`configPath`.
- Sebenzisa i-`javax.xml.valid