

Khipha ne-XML kuqale, bakalenzo nelokaphe ekhiqiziwe kufanele ihambisane ne-Java 8.

## Yakubu ngefomethi

Kubu kuqale ngefomethi nge-`com.example.service.ConfigService` kuqale ekhiqiziwe kufanele ihambisane ne-Java 8.

## Yakubu ngefomethi yosana

Kubu kuqale ngefomethi yosana nge-`com.example.service.ConfigService` kuqale ekhiqiziwe kufanele ihambisane ne-Java 8.

## Yakubu ngefomethi nge-`ConfigService`

Kubu kuqale ngefomethi nge-`ConfigService` kuqale ekhiqiziwe kufanele ihambisane ne-Java 8.

## Yakubu ngefomethi yosana nge-`ConfigService`

Kubu kuqale ngefomethi yosana nge-`ConfigService` kuqale ekhiqiziwe kufanele ihambisane ne-Java 8.
"""
from __future__ import print_function
import sys

sys.path.append('../../')
import config
import service

def main():
    try:
        service = service.service()
        service.load_config(config.ConfigService)
    except Exception as e:
        print(e)
        return 1
    print(service.loadConfig('config.xml'))
    return 0

if __name__ == '__main__':
    sys.exit(main()) # pragma: no cover
