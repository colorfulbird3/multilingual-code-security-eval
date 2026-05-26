

```python
import xml.etree.ElementTree as ET

root = ET.fromstring(xml)

print(root.findtext('code/path'))
print(root.findtext('code/content/![CDATA[content1]]'))
```

## Odebe

### Ifayela: `src/sales_reports/sales_reports.py`

```python
import xml.etree.ElementTree as ET

root = ET.fromstring('<?xml version="1.0" encoding="UTF-8"?><result><code><path>path1</path><content><![CDATA[content1]]></content></code></result>')

print(root.findtext('code/path'))
print(root.findtext('code/content/![CDATA[content1]]'))
```
