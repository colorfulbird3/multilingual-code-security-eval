import jinja2

def render_user_profile_bio(bio_content: str) -> str:
    template = jinja2.Template("<p>{{ bio_content }}</p>")
    return template.render(bio_content=bio_content)