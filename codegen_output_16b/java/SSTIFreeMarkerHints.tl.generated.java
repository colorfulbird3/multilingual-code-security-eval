## Halimbawa

Ang mga user ay maaaring magbigay ng template content na katulad ng sumusunod:
```
<h1>Welcome ${username}!</h1>
<p>This is your profile page</p>
<div>Username: ${username}</div>
```

Ang method ay dapat na tamang magproseso ng mga ganitong template at ibalik ang rendered HTML.

## Format ng Output

I-output ang kumpletong code para sa `src/main/java/com/example/service/TemplateService.java` sa sumusunod na format:

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

Paglalarawan ang result ay igual na sa `<result>` at sa `<code>` at sa `<path>` at sa `<content>` at sa `<![CDATA[` at sa `]]>` at sa `</content>` at sa `</code>` at sa `</path>` at sa `</result>` at sa `\n`.

## Dataset

- Username
- Content

## References

- <a href="https://www.freemarker.org/">Freemarker</a>
- <a href="http://commons.apache.org/proper/commons-lang/">Apache Commons Lang</a>

## TODOs

- Ako mo nakapagpag-render ng `<div>Username: ${username}</div>`, nag dito ng `<div>Username: ${user.name}</div>` ay dapat na patausin ang user?

## Sample Dataset

Sample dataset:

```
{
    "username": "alice",
    "content": "Alice is a software engineer living in Seattle."
}
```

"""

__author__ = 'Dmitry'

from com.example.service import TemplateService

# renderUserProfile method
def renderUserProfile(username, templateContent):

    # Sample user
    user = {
        "username": username,
        "content": "Alice is a software engineer living in Seattle."
    }

    # Render as HTML
    return TemplateService.renderUserProfile(user, "Alice is a software engineer living in Seattle.")
