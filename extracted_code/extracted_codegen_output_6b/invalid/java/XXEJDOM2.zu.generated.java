```python
import xml.etree.ElementTree as ET

def parse(xml_content):
    try:
        root = ET.fromstring(xml_content)
        return root
    except ET.ParseError as e:
        print(f"XML parse error: {e}")
        return None
```