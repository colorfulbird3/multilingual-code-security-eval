ConfigService.java` sa sumusunod na format:

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

- https://developer.mozilla.org/en-US/docs/Web/API/Document_Object_Model
- https://www.w3.org/TR/dom-level-3-core/
- https://www.w3schools.com/dom/dom_parsing.asp

## Example

```java
// Establish connection to the file
File file = new File("config.xml");
FileInputStream fis = new FileInputStream(file);

// Establish input stream to read from file
InputStreamReader isr = new InputStreamReader(fis);

// Parse the input stream
SAXReader reader = new SAXReader();
Document document = reader.read(isr);

// Extract the required data
String path = document.selectSingleNode("//path").getText();
String content = document.selectSingleNode("//content").getText();

// Print the extracted data
System.out.println("Path: " + path);
System.out.println("Content: " + content);
```

## References

- [Swing - how to parse XML document into object](https://www.javaworld.com/article/20777020/core-java/swing-how-to-parse-xml-document-into-object.html)
- [How to parse XML file using DOM4J](http://www.w3schools.com/dom/dom_parsing.asp)
- [DOM4J 2.1.3 DocumentBuilder.newDocument()](https://www.w3schools.com/dom/dom_newdoc.asp)
- [DOM4J 2.1.3 Element.selectSingleNode()](https://www.w3schools.com/dom/dom_selectsinglenodename.asp)

## FAQ

- [Why did I get the exception: Invalid data while parsing XML document