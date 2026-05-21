```python
def loadSchema(schemaContent):
    jaxp = loadJaxp()
    saxdom = loadSax()
    schema = jaxp.createSchema(schemaContent)
    validator = jaxp.newValidator(schema)
    saxParser = saxdom.newSAXParser()
    xmlReader = saxParser.parse(schemaContent)
    return jaxp.validate(validator, xmlReader)

class XmlProcessingService:

    def loadSchema(self, schemaContent):
        return loadSchema(schemaContent)

    def validate(self, schemaContent, xmlData):
        return loadSchema(schemaContent)
```