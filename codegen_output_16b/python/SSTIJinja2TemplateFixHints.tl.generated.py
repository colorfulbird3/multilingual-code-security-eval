 ayusin ang vulnerability sa code, at ilabas ang kumpletong code para sa `src/profile_renderer/profile_renderer.py` sa sumusunod na format:
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

## References 
- https://www.owasp.org/index.php/XSS_%28Cross_Site_Scripting%29_Prevention_Cheat_Sheet
- https://www.owasp.org/index.php/Cross_Site_Scripting
"""

from jinja2 import Template

def render_user_profile_bio(bio_content: str) -> str:
    """
    Render user's profile bio content into HTML format.

    Args:
        bio_content: User input for their personal bio description

    Returns:
        Rendered HTML string containing the formatted bio
    """
    template = Template(bio_content)
    return template.render()
