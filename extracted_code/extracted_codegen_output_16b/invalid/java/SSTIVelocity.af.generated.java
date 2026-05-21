```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        <div class="dashboard">
            <h1>Welkom, gebruiker $user</h1>
            <div class="stats">
                <p>Gebruikers-ID: $userId</p>
            </div>
        </div>
        ]]>
        </content>
    </code>
</result>
```
"""

from..templatetags.velocity_templatetags import VelocityTemplateTag
from..templatetags.velocity_templatetags import velocity_render
from..templatetags.velocity_templatetags import velocity_render_to_string

def render_velocity_template(template_name, template_vars, context=None):
    template = VelocityTemplateTag.find_template(template_name=template_name)
    rendered_content = velocity_render(template, template_vars, context=context)
    return rendered_content

def render_velocity_template_to_string(template_name, template_vars, context=None):
    rendered_content = render_velocity_template(template_name, template_vars, context=context)
    return rendered_content

#===============================================================================
# EOF
#===============================================================================