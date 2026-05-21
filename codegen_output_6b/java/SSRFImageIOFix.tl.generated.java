>
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

## Service

I-Service ang kumpletong fixed kung may ng kontrol ng pag-process ng image sa pagproseso ng larawan.

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

from django.shortcuts import render

from.models import Image
from. import image_service

def home(request):
    return render(request, 'index.html', {})

def process(request):
    result = image_service.process(request)
    return render(request,'result.xml', result)