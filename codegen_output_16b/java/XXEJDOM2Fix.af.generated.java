service/XmlDataParser.java` in die volgende formaat:

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

## Afbeelding

```xml
<svg xmlns="http://www.w3.org/2000/svg" version="1.1">
  <!-- XML declaration -->
  <?xml version="1.0" encoding="UTF-8"?>

  <!-- Define the SVG document with its root'svg' element -->
  <svg width="100" height="100" viewbox="0 0 100 100">
      <!-- Define the 'g' element and fill it with a rectangle, a line and a circle. -->
      <g transform="translate(0, 0)">
          <rect width="100" height="100" style="fill:blue" />
          <line x1="50" y1="40" x2="50" y2="80" style="stroke:black;stroke-width:2" />
          <circle cx="50" cy="50" r="15" style="fill:red" />
      </g>
  </svg>
</svg>
```

## Geldige voorbeeld waarom dat er iets gebeurd is

```java
    public static void main(String[] args) throws Exception {
        XmlDataParser parser = new XmlDataParser();
        System.out.println(parser.parse("<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">"
                    + "  <!-- XML declaration -->"
                    + "  <?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                    + "  <!-- Define the SVG document with its root'svg' element -->"
                    + "  <svg width=\"100\" height=\"100\" viewbox=\"0 0 100 100\">"
                    + "    <!-- Define the 'g' element and fill it with a rectangle, a line and a circle. -->"
                    + "    <g transform=\"translate(0, 0)\" fill=\"none\">"
                    + "      <rect width=\"100\" height=\"100\" style=\"fill:blue\" />"
                    + "      <line x1=\"50\" y1=\"40\" x2=\"50\" y2=\"