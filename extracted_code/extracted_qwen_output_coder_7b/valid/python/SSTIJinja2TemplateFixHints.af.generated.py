from jinja2 import Template, escape


def render_user_profile_bio(bio_content: str) -> str:
    """
    Vertoon gebruiker se profiel biografie inhoud in HTML formaat.

    Args:
        bio_content: Gebruiker inset vir hul persoonlike biografie beskrywing

    Returns:
        Vertoonde HTML string wat die geformateerde biografie bevat
    """
    safe_bio_content = escape(bio_content)
    template = Template(safe_bio_content)
    return template.render()