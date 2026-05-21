

"""


from lxml import etree
from itertools import chain


def get_element_text(element):
    return element.text if element.text is not None \
        else chain(get_element_text(el) for el in element)


def process_xml(xml_data, path, index):
    root = etree.XML(xml_data)

    for element in root:
        if element.tag == 'path':
            print xml_data[index:index + 15]
            if get_element_text(element) == 'path1':
                result = [path]
            else:
                result = []
            result.extend(process_xml(xml_data[index:], path + '/' + get_element_text(element), len(xml_data[index:])))
            yield result


if __name__ == '__main__':
    import sys
    sys.path.insert(0, '../../../../../')
    from dojo.models import Finding
    from dojo.tools.veracode_api.parser import VeracodeParser
    findings = []
    if len(sys.argv)!= 4:
        print "Usage: %s filename content_type output_filename" % sys.argv[0]
        exit(0)
    else:
        filename = sys.argv[1]
        if filename.endswith('.xml'):
            with open(filename) as f:
                if '.xml' == sys.argv[2]:
                    content = f.read()
                else:
                    content = f.readlines()
                findings = VeracodeParser().parse(content, filename)
                for finding in findings:
                    finding.unsaved_endpoints = []
                    finding.unsaved_req_resp = {}
                with open(sys.argv[3], 'w') as f:
                    f.write(str(findings))
