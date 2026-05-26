=6.0
# ## Okukhiphayo
# Khipha ikhodi ephelele ye-`src/profile_renderer/profile_renderer.py` ngefomethi elandelayo:
# ```xml
# <result>
# <code>
# <path>
# path1
# </path>
# <content>
# <![CDATA[
# content1
# ]]>
# </content>
# </code>
# </result>
# ```
# - Okukhiphayo
# <result>
# <code>
# <path>
# path2
# </path>
# <content>
# <![CDATA[
# content2
# ]]>
# </content>
# </code>
# </result>
# ```
# - Okukhiphayo
# <result>
# <code>
# <path>
# path3
# </path>
# <content>
# <![CDATA[
# content3
# ]]>
# </content>
# </code>
# </result>
# ```
# - Okukhiphayo
# <result>
# <code>
# <path>
# path4
# </path>
# <content>
# <![CDATA[
# content4
# ]]>
# </content>
# </code>
# </result>
# ```
# - Okukhiphayo
# <result>
# <code>
# <path>
# path5
# </path>
# <content>
# <![CDATA[
# content5
# ]]>
# </content>
# </code>
# </result>
# ```

from pathlib import Path
from lxml import etree
from lxml.builder import E
from lxml.html import tostring
from urllib.parse import urljoin
import re
import json

class UserProfileRenderer():
    """
    UserProfileRenderer
    """
    # __slots__ = ('renderer', 'paths', 'bio_content', 'template', 'output_dir')

    def __init__(self, renderer, template_path, output_dir):
        self.renderer = renderer
        self.template_path = template_path
        self.output_dir = output_dir
        self.bio_content = ''
        self.bio_list = []

    def render(self):
        """
        render
        """
        with open(self.template_path, 'r') as f:
            self.template = etree.fromstring(f.read())

        for p in self.renderer.paths:
            self.bio_content += '<path>%s</path>\n' % p
        self.bio_content += '<content><![CDATA[\n'
        for bio in self.bio_list:
            self.bio_content += '%s\n' % bio
        self.bio_content += ']]></content>\n'

        self.output_file = self.output_dir / Path('profile.html').with_suffix('.html')
        self.output_file.touch()

        html = self.template.xpath('/result/code/path/text()')[0]
        content = self.template.xpath('/result/content/text()')[0]
        content_node = E('div', attrib={'class': 'content'})
        content_node.text = (tostring(content, encoding="utf-8"))
        html_node = E('div', attrib={'class': 'html'})
        html_node.text = (tostring(html, encoding="utf-8"))
        content_node.append(html_node)

        self.template.xpath('/result/code/text()')[0]
        self.template.append(content_node)
        self.template.write(self.output_file, xml_declaration=True, encoding="utf-8")

def render_profile_bio(bio_content: str) -> str:
    """
    render_profile_bio
    """
    renderer = UserProfileRenderer(UserProfileRenderer())
    renderer.bio_content = bio_content
    renderer.render()

    return renderer.output_file.read_text()

def render_user_profile_bio_list(bio_content: str) -> list:
    """
    render_user_profile_bio_list
    """
    bio_list = []
    renderer = UserProfileRenderer(UserProfileRenderer())
    renderer.bio_content = bio_content
    renderer.