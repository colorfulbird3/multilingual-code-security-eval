 sa sumusunod na format:
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

from jinja2 import Template

class Result:
    def __init__(self, code, content):
        self.code = code
        self.content = content

class ProfileRenderer:
    def __init__(self, bio_content=''):
        self.bio_content = bio_content

    def render(self):
        return Template(
            """
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
            """).render(profile_renderer=self)

def render_user_profile_bio():
    return Result('code', 'content')

if __name__ == '__main__':
    render_user_profile_bio()
