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