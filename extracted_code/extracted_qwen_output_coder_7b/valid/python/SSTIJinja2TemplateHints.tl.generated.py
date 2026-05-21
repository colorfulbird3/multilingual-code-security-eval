import jinja2

def render_user_profile_bio(bio_content: str) -> str:
    template = jinja2.Template(bio_content)
    return template.render()