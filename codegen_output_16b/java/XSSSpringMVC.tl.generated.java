usunod na format:

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



## Sample Output


I-output ang kumpletong code para sa `src/main/java/com/example/controller/MessageController.java` sa sumusunod na format:

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

from datetime import datetime
from typing import Optional

from docx import Document
from docx import opendocx
from docx.shared import Pt
from docx.shared import RGBColor

DOCX_PATH = '/tmp/demo.docx'

def get_document():
    document = Document()
    document.styles.add_style('Heading 1', style_type='paragraph', name='Heading 1')
    document.styles['Heading 1'].font.size = Pt(24)
    document.styles['Heading 1'].font.color.rgb = RGBColor(0x00, 0x33, 0x33)
    document.styles['Heading 1'].alignment.wrap_text = True

    document.add_heading('This is a docx demo', 0)
    document.add_paragraph('I just want to demonstrate the use of the docx Python library to generate a docx file. To do that, this little piece of code will generate a file called demo.docx and put a heading into it. Enjoy the beauty of docx!').paragraph_format.alignment = document.styles['Heading 1']

    document.add_paragraph(f'Docx Python Library Version: {opendocx.__version__}', style_name='Heading 1')

    document.add_paragraph(f'Current date and time: {datetime.now()}')
    document.add_paragraph(f'This is a list: {[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]}')
    document.add_paragraph(f'This is some text: {f'This is some text. It is a {f'long' if f'long'