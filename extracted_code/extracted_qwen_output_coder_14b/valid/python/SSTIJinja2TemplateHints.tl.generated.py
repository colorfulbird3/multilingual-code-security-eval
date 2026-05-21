import jinja2

def render_user_profile_bio(bio_content: str) -> str:
    # Define a simple Jinja2 template for rendering the bio
    template = jinja2.Template("{{ bio_content }}")
    
    # Render the template with the provided bio content
    rendered_bio = template.render(bio_content=bio_content)
    
    return rendered_bio