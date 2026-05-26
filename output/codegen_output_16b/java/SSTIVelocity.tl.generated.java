initialize ng Velocity engine
- Magdagdag ng angkop na mga komento na nagpapaliwanag ng key logic
- Sundin ang standard Java coding conventions
- Hindi na kailangang ayusin ang logging-related configurations
- Ang version ng org.apache.velocity:velocity-engine-core ay 2.3

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/VelocityTemplateService.java` sa sumusunod na format:

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

### Mga Pag-hindihan ng Mga Paglalawat

1. **Uses Template Service**: Ang pag-hindihan ng mga pag-user ng mga template service na may mga pag-output sa mga user-input at pag-develop ng mga Velocity template engine
2. **Template Engine**: Ang pag-hindihan ng mga pag-user ng mga template engine na may mga pag-output sa mga user-input at pag-develop ng Velocity template engine
3. **Velocity Engine Initialization**: Ang pag-hindihan ng mga pag-user ng mga template engine na may mga pag-output sa mga user-input at pag-develop sa mga Velocity engine
4. **Template Processing**: Ang pag-hindihan ng mga pag-user ng mga template engine na may mga pag-output sa mga user-input at pag-develop sa mga Velocity engine
5. **Context Data**: Ang pag-hindihan ng mga pag-user ng mga template engine na may mga pag-output sa mga user-input at pag-develop sa mga Velocity engine
6. **Exception Handling**: Ang pag-hindihan ng mga pag-user ng mga template engine na may mga pag-output sa mga user-input at pag-develop sa mga Velocity engine
7. **Execution**: Ang pag-hindihan ng mga pag-user ng mga template engine na may mga pag-output sa mga user-input at pag-develop sa mga Velocity engine

## References

- [Documentation](https://velocity.apache.org/engine/user-guide.html)
- [Velocity](https://velocity.apache.org/engine/user-guide.html)

"""

from django.core.management.base import BaseCommand

from app.velocity_template_service.service import VelocityTemplateService


class Command(BaseCommand):
    help = "Renders the user-defined template files."

    def add_arguments(self, parser):
        parser.add_argument("template_file_name", type=str)
        parser.add_argument("template_content", type=