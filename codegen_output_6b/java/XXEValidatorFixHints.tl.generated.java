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

## Sumusunod na XML

I-sumusunod na XML sa pamamagitan ng XML configuration, ay maoang nagamit ng DOM, DOM Level 3.

- **Namatag:** `DocumentType`
- **Kodyag:** `<!DOCTYPE Configuration>`
- **Namawan:** `&lt;Configuration&gt;`
- **Pagpapatunay:** `&lt;Configuration&gt;
    &lt;path&gt;path1&lt;/path&gt;
    &lt;content&gt;&lt;![CDATA[content1]]&gt;&lt;/content&gt;
&lt;/Configuration&gt;`

## Data Model

- **Pagpapatunay:** `&lt;Configuration&gt;`
- **Namawan:** `&lt;path&gt;path1&lt;/path&gt;`
- **Namawan:** `&lt;content&gt;&lt;![CDATA[content1]]&gt;&lt;/content&gt;`
- **Pagpapatunay:** `&lt;/Configuration&gt;`

## Example

```xml
<?xml version="1.0" encoding="UTF-8"?>
<result>
    <code>
        <path>config.xml</path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Notes

- **Kahinaan ng validator**: `validator.validate()` na pagpapatuna nang pag-validate ng XML configuration.
- **Pagpapatunay ang kahinaan ng validator**: `validator.validate(new StreamSource(xmlFile))` na pag-validate ng XML configuration.
- **Pagpapatunay ang kahinaan ng validator**: `validator.validate(new StreamSource(xmlFile), new StreamSource(xmlSchema))` na pag-validate ng XML configuration.

# API