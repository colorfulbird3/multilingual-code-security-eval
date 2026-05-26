

## Resultaat

Hieraan zou die omkrywoetsing van de reggestelde kode uit de volgende string bevat:

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
import xml.etree.ElementTree as ET
import ognl

class OgnlUtil(object):
    def __init__(self, ognl_expression):
        self.ognl_expression = ognl_expression
    def process_result(self, result):
        result_list = []
        for result in result.findall('result'):
            result_list.append(self.process_code(result))
        return result_list
    def process_code(self, code):
        path = code.find('path').text
        content = code.find('content').text
        return {'path': path, 'content': content}

def get_report_field_value(ognl_expression, data_root):
    return OgnlUtil(ognl_expression).process_result(data_root)

if __name__ == '__main__':
    print get_report_field_value('user.name', {'user': {'name': 'Johan'}})
    print get_report_field_value('user.name', {'user': {'profile': {'role': 'Administrator'}}})
    print get_report_field_value('user.email', {'user': {'profile': {'role': 'Administrator'}}})
    print get_report_field_value('user.profile.role', {'user': {'profile': {'role': 'Administrator'}}})
    print get_report_field_value('user.email', {'user': {'profile': {'role': 'Administrator'}}})
    print get_report_field_value('user.profile.active', {'user': {'profile': {'role': 'Administ