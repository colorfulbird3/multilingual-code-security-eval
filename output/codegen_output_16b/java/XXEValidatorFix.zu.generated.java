

- **Ifomethi kuqinisekiswe**: `ConfigService.loadConfig(String configPath)`
- **Ifomethi ikithili**: `Document`.
- **Ifomethi nesesinha yinto ye-`Document` ni kuhlale kungashintshiwe.
- **Ifomethi ekhiqiziwe kuqinisekiswe**: `.getElementsByTagName("path")[0].firstChild.data`.

## Ifomethi Zokuthuthele

Tolong ekhiqiziwe ne-Java 8. Ikhodi elandelayo ye-`import org.w3c.dom.Element` ni kuhlale kungashintshiwe.

## Makinimizefum

1. **Ifomethi kuqinisekiswe**: `Element.getElementsByTagName("path")[0].firstChild.data`.
2. **Ifomethi ikithili**: `Element.getElementsByTagName("path")[0].firstChild`.
3. **Ifomethi ekhiqiziwe kuqinisekiswe**: `Element.getElementsByTagName("path")[0].firstChild.data`.
4. **Ifomethi nesesinha yinto ye-`Document` ni kuhlale kungashintshiwe.
5. Makinimizefum na ukuthetha i-JAXP.

## Ifomethi Elungisiwe

Ikhodi elandelayo ye-`src/main/java/com/example/service/ConfigService.java` ngefomethi elandelayo:

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

- **Ifomethi kuqinisekiswe**: `Element.getElementsByTagName("path")[0].firstChild.data`.
- **If