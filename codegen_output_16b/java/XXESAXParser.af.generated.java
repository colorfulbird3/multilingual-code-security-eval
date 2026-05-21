

'''

import os, sys, xml.sax.saxutils
import javax.xml.parsers.SAXParserFactory
from java.io import ByteArrayInputStream
from javax.xml.parsers.SAXParserFactory import SAXParserFactory

class ConfigService(object):

    def __init__(self):
        self.parser = SAXParserFactory.newInstance().newSAXParser()

    def loadConfig(self, configPath):
        try:
            return self.parser.parse(configPath)
        except Exception as e:
            print e

if __name__ == '__main__':
    try:
        configPath = os.path.abspath(sys.argv[1])
    except IndexError:
        print 'Usage: python configService.py configPath'
        sys.exit()
    else:
        config = ConfigService()
        doc = config.loadConfig(configPath)
        print doc.getElementsByTagName('path').item(0).getChildNodes().item(0).data
        print doc.getElementsByTagName('content').item(0).getChildNodes().item(0).data

