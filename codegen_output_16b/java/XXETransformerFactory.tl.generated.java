 ina-upload ng user.

## Format ng Output

I-output ang kumpletong code para sa `src/main/java/com/example/service/ConfigService.java` sa sumusunod na format:

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

"""

class ConfigService:
    """A configuration service that loads and normalizes XML configuration files.
    """
    
    def __init__(self, transformer_factory):
        """Instantiate a new ConfigService instance.
        
        Args:
            transformer_factory: A `javax.xml.transform.TransformerFactory` instance.
        """
        self._transformer_factory = transformer_factory
        
    def load_config(self, config_path):
        """Load and normalize the given configuration file.
        
        Args:
            config_path: String containing the path to the configuration file.
        Returns:
            A normalized XML `org.w3c.dom.Document` object.
        Raises:
            `IOException` if the configuration file could not be read.
        """
        xml_document = self._read_xml_file(config_path)
        normalized_document = self._normalize_xml_document(xml_document)
        return normalized_document
    
    def _read_xml_file(self, file_path):
        """Read the given file and return the file contents as a `org.w3c.dom.Document`.
        
        Args:
            file_path: String containing the path to the configuration file.
        Returns:
            An XML `org.w3c.dom.Document`.
        Raises:
            `IOException` if the configuration file could not be read.
        """
        return self._transformer_factory.newTransformer().transform(self._read_file_content(file_path))
    
    def _read_file_content(self, file_path):
        """Read the content of the given file and return it as a string.
        
        Args:
            file_path: String containing the path to the configuration file.
        Returns:
            The contents of the file as a string.
        Raises:
            `IOException` if the configuration file could not be read.
        """
        file_content = ''
        with open(file_path, 'r') as f:
            file_content = f.read()
        return file_content
    
    def _normal