Hier is die volledige kode vir `src/user_profile_service/user_profile_service.py`:

```xml
<result>
    <code>
        <path>
            src/user_profile_service/user_profile_service.py
        </path>
        <content>
            <![CDATA[
import flask

def generate_profile_banner(banner_template: str, user_info: dict) -> str:
    app = flask.Flask(__name__)
    with app.app_context():
        rendered_html = flask.render_template_string(banner_template, **user_info)
    return rendered_html
            ]]>
        </content>
    </code>
</result>
```