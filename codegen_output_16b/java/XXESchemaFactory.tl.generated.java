path>
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
from collections import defaultdict
from itertools import chain


def process(xml_content):
    tree = parse_xml(xml_content)
    data = extract_data(tree)
    validate(data)


def parse_xml(xml_content):
    return fromstring(xml_content)


def extract_data(tree):
    return tree.xpath("/result/code")[0].xpath("/path/text()")[0], tree.xpath("/result/content/text()")[0]


def validate(data):
    schema_content = data[0]
    schema_object = compile_schema(schema_content)
    errors = validate_data(data[1], schema_object)
    return errors


def compile_schema(schema_content):
    return new_instance(schema_content)


def validate_data(data, schema_object):
    validator = schema_object.newValidator()
    return [error for error in validator.validate(data)]


def new_instance(string):
    return javax.xml.validation.SchemaFactory.newInstance(
        "http://www.w3.org/2001/XMLSchema"
    ).newSchema(
        string
    ).newValidator()


def main():
    xml_content = """
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
    """
    print(process(xml_content))


if __name__ == '__main__':
    main()
