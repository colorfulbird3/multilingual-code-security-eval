```python

__author__ = 'Michael Schwartz'

import os
import pytest
import json
import requests
from lxml import etree
from. import TEST_FILES_PATH
from.. import get_file_by_extension
from.. import get_file_content
from.. import get_file_content_by_extension
from.. import get_text_between
from.. import remove_tags
from.. import remove_tags_by_extension
from.. import remove_tags_by_regex
from.. import write_file
from.. import write_file_by_extension
from.. import write_xml_to_file
from.. import append_to_file
from.. import append_to_file_by_extension
from.. import append_to_xml_file
from.. import append_to_xml_file_by_extension
from.. import update_file
from.. import get_base_dir
from.. import get_base_dir_by_extension
from.. import get_dir_by_extension
from.. import get_dir_by_regex
from.. import get_files_by_extension
from.. import get_files_by_regex
from.. import get_file_by_regex
from.. import get_file_by_regex_and_extension
from.. import get_file_content_by_regex
from.. import get_file_content_by_regex_and_extension
from.. import get_file_content_by_regex_from_file
from.. import get_file_content_by_regex_from_file_and_extension
from.. import get_file_content_by_regex_from_file_by_extension
from.. import get_file_content_by_regex_from_file_by_regex
from.. import get_file_extension
from.. import get_file_name
from.. import get_file_name_by_extension
from.. import get_file_name_by_regex
from.. import get_file_names
from.. import get_file_names_by_extension
from.. import get_file_names_by_regex
from..