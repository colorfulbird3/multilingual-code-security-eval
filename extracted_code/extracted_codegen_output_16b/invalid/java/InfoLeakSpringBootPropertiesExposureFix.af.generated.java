import random
import string

from lxml import etree

from.api import Api
from.rest import Rest
from.spring import Spring
from.wsgi import Wsgi

# http://lxml.de/tutorial.html

class Configure(object):
    def __init__(self, source):
        self.source = source

    def configure(self):
        source = source
        code = etree.fromstring(source)
        result = etree.Element("result")
        code.insert(0, result)
        print(etree.tostring(code, pretty_print=True))
        # result.text = "Hello World"


class SystemInfoService(object):
    def __init__(self, port):
        self.port = port

    def __call__(self):
        method = Rest('/')
        method()
        method = Rest('/')
        method()
        method = Wsgi()
        method()
        method = Api()
        method()


if __name__ == "__main__":
    random.seed(0)
    while True:
        key = ''.join(random.choice(string.ascii_uppercase + string.digits) for _ in range(8))
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)
        print(key)