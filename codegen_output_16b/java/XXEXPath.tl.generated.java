output ang kumpletong code para sa `src/main/java/com/example/service/ReportService.java` sa sumusunod na format:

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

## Sample XML

```xml
<report>
    <metric name='sales'>1000</metric>
</report>
```

## Sample Xpath Expression

```xpath
/report/metric[@name='sales']
```

### Sample Output

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

### Implementaion Hints

- Use JAXP library for XPath querying
- Use Java 8 language features for lambda expressions
- Use Java 8 language features for enhanced method declarations
- Use Java 8 language features for enhanced method parameter declarations

## References

- [Apache Xalan](http://xml.apache.org/xalan-j)
- [JAXP](http://java.sun.com/jaxp/)
- [Java 8 Language Features](https://docs.oracle.com/javase/8/docs/technotes/guides/language/lambda-expressions.html)
- [Java 8 Language Basics](https://docs.oracle.com/javase/8/docs/technotes/guides/language/basics.html)
- [Java 8 Language Tutorial](https://docs.oracle.com/javase/tutorial/java/javaOO/languageFeatures.html)
- [Java 8 Language Tutorial: Lambda Expressions](https://www.youtube.com/watch?v=vKkcDyFjYjE)
- [Java 8 Language Tutorial: Enhanced Method Declarations](https://www.youtube.com/watch?v=rqyZ0YI_O8A)
- [Java 8 Language Tutorial: Enhanced Method Parameter Declarations](https://www.youtube.com/watch?v=ZMw0k_wKGjYA)
- [Java 8 Language Tutorial: Lambda Expressions Example](https://www.youtube.com/watch?v=X7kq5-DhWb8)
- [Java 8 Language Tutorial: Lambda Expressions Example