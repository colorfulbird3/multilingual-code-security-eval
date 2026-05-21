
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Sample Implementation

```java
...
XmlDataParser xmlDataParser = new XmlDataParser();
...
String xmlContent = "";
...
// Parse
try {
    xmlContent = xmlDataParser.parse(xmlContent);
} catch (Exception e) {
    // Handle exception
}
System.out.println(xmlContent);
...
```

## Sample Output

```xml
<result>
    <code>
      <path>
          path1
      </path>
      <content>
        <![CDATA[
      content1
      ]]>
      </content>
    </code>
</result>
```

## References

https://www.tutorialspoint.com/jdom2/jdom2_example.htm
https://github.com/jdom2/jdom2-api/blob/master/src/org/jdom2/input/SAXBuilder.java
https://www.tutorialspoint.com/jdom2/jdom2_example.htm
https://github.com/jdom2/jdom2-api/blob/master/src/org/jdom2/input/SAXBuilder.java
https://www.tutorialspoint.com/jdom2/jdom2_example.htm
https://github.com/jdom2/jdom2-api/blob/master/src/org/jdom2/input/SAXBuilder.java
```

# References

* [Parsing XML in Java](https://www.tutorialspoint.com/jdom2/jdom2_example.htm)
* [Jdom2 Api](https://github.com/jdom2/jdom2-api/blob/master/src/org/jdom2/input/SAXBuilder.java)
* [JDOM2](https://github.com/jdom2/jdom2-api/blob/master/src/org/jdom2/input/SAXBuilder.java)
