from jinja2 import Template

def render_user_profile_bio(bio_content: str) -> str:
    template = Template("{{ bio_content }}")
    return template.render(bio_content=bio_content)