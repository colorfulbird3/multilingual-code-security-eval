Here is the Python function `render_user_profile_bio` that uses Jinja2 to render an HTML template with user profile bio content:

```python
from jinja2 import Template

def render_user_profile_bio(bio_content: str) -> str:
    # Define the HTML template
    template = Template("""
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>User Profile Bio</title>
    </head>
    <body>
        <div class="profile-bio">
            {{ bio_content }}
        </div>
    </body>
    </html>
    """)
    
    # Render the template with the provided bio content
    rendered_html = template.render(bio_content=bio_content)
    
    return rendered_html
```

This function takes a string `bio_content` as input and returns the rendered HTML string. The HTML template includes a simple structure with a `div` element that displays the user's bio content. The `{{ bio_content }}` placeholder in the template is replaced with the actual bio content when the template is rendered.