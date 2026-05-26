```xml
<result>
    <code>
        <path>
            src/profile_renderer/profile_renderer.py
        </path>
        <content>
            <![CDATA[
from jinja2 import Template

def render_user_profile_bio(bio_content: str) -> str:
    template = Template("<div class='bio'>{{ bio }}</div>")
    return template.render(bio=bio_content)
            ]]>
        </content>
    </code>
</result>
```