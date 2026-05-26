letong code para sa `src/network_config.c` sa sumusunod na format:
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
from __future__ import absolute_import
from __future__ import division
from __future__ import print_function
from __future__ import unicode_literals

import json
import logging
import os
import re

from google.appengine.ext import ndb

import jinja2


def main():
    jinja_environment = jinja2.Environment(
        loader=jinja2.FileSystemLoader(os.path.dirname(__file__)))

    jinja_environment.filters['json'] = json.dumps
    jinja_environment.filters['to_json'] = json.dumps
    jinja_environment.filters['to_json_safe'] = json.dumps
    jinja_environment.filters['to_string'] = str
    jinja_environment.filters['escape_html'] = ndb_escape_html

    jinja_environment.globals['logging'] = logging
    jinja_environment.globals['ndb_escape_html'] = ndb_escape_html
    jinja_environment.globals['ndb_json_dumps'] = json.dumps

    jinja_environment.globals['os'] = os

    template = jinja_environment.get_template('index.html')
    with open('index_template.html') as index_template_file:
        index_template = index_template_file.read()

    index_template = index_template.decode('utf-8')
    index_template = re.sub(r'{{(.*?)}}', r'{{ \1 }}', index_template)

    configs = ndb.gql("select * from Configs order by modified desc limit 10")
    configs = [config.to_dict() for config in configs]

    index_template = template.render({
        'configs': configs,
    })

    with open('index.html', 'w') as index_file:
        index_file.write(index_template.encode('utf-8'))

    logging.info('Done!')


def ndb_escape_html(value):
    return jinja2.