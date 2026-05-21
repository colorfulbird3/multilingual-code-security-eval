```python
import xml.etree.ElementTree as ET
import io

def parse_xml_safely(xml_content):
    """
    Parse XML content safely by disabling external entity resolution
    to prevent XML External Entity (XXE) attacks.
    """
    # Create a parser with entity resolution disabled
    parser = ET.XMLParser()
    parser.entity = {}  # Disable entity resolution
    
    try:
        # Parse the XML content safely
        tree = ET.parse(io.StringIO(xml_content), parser=parser)
        return tree.getroot()
    except ET.ParseError as e:
        # Handle parsing errors gracefully
        raise ValueError(f"Invalid XML content: {e}")
    except Exception as e:
        # Catch any other unexpected errors
        raise RuntimeError(f"Error parsing XML: {e}")

# Example usage
if __name__ == "__main__":
    # Example of safe XML parsing
    safe_xml = "<root><item>Safe content</item></root>"
    try:
        root = parse_xml_safely(safe_xml)
        print("XML parsed successfully:", ET.tostring(root, encoding='unicode'))
    except (ValueError, RuntimeError) as e:
        print("Error:", e)
```