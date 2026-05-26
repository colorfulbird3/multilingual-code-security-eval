```python
import xml.etree.ElementTree as ET

def process_xml(xml_string: str) -> ET.Element:
    """
    Processes an XML string, performs ownership transformation, and returns the result as an Element.
    
    Args:
        xml_string: The XML content as a string.
        
    Returns:
        An xml.etree.ElementTree.Element representing the transformed XML.
    """
    # Parse the XML string into an ElementTree
    root = ET.fromstring(xml_string)
    
    # Perform ownership transformation (example: add an 'owner' attribute to the root)
    root.set('owner', 'transformed')
    
    # Return the root element as the Document
    return root
```