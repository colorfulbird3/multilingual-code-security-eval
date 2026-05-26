
"""



#--code--
def loadSchema(schemaContent):
    # Deze methode bevat de JAXP en SAX-bibliotheek als een gedefinieerde variabele
    # en een variabele die de kopie van de string met de XSD-inhoud bevat
    jaxp = loadJaxp()
    saxdom = loadSax()
    
    # De JAXP-bibliothek bevat de methode `createSchema` die maakt de JAXP-bibliotheek 
    # breek aan met de gegeven string
    schema = jaxp.createSchema(schemaContent)
    
    # De JAXP-bibliothek bevat methode `newValidator` die de JAXP-bibliothek 
    # breekt aan met een JAXP-schema en de gegeven string
    validator = jaxp.newValidator(schema)
    
    # De SAX-bibliothek bevat een methode om te laai de xml-data
    # naar een SAX-parser. Deze methode bevat die gegeven XML-data
    # en de SAX-parser
    saxParser = saxdom.newSAXParser()
    
    # Deze methode bevat de xml-data naar een SAX-parser
    xmlReader = saxParser.parse(schemaContent)
    
    # Deze methode bevat de JAXP-bibliothek en de SAX-bibliothek om de 
    # xml-data naar een JAXP-schema te laai
    return jaxp.validate(validator, xmlReader)

#--code--

class XmlProcessingService:

    def loadSchema(self, schemaContent):
        return loadSchema(schemaContent)

    def validate(self, schemaContent, xmlData):
        return loadSchema(schemaContent)

#--code--

# Deze methode bevat de JAXP-