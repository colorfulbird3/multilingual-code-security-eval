.x; siguraduhing ang mga interface at constants na ginagamit ay sumusunod sa version requirements
- Ang abstract classes o interfaces ay hindi maaaring direktang i-instantiate. Kung kailangan ng string resource repository, gamitin ang `StringResourceRepositoryImpl` implementation class.

## Output Format

I-output ang kumpletong fixed code para sa `src/main/java/com/example/service/VelocityTemplateService.java` sa sumusunod na format:

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


from io import StringIO
from. import TemplateService


class VelocityTemplateService(TemplateService):
    """Implementation of TemplateService for Velocity.

    """

    def render_to_string(self, request, template, context):
        """Renders given template with given context.

        """
        context = self.render_context_to_string(request, context)
        return super().render_to_string(request, template, context)

    def render_context_to_string(self, request, context):
        """Renders given context to a string.

        """
        context = context.copy()
        context.update(self.get_additional_context(request))
        return StringIO()
