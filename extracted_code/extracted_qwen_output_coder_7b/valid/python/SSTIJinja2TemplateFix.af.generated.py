from jinja2 import Template


def render_user_profile_bio(bio_content: str) -> str:
    """
    Vertoon gebruiker se profielbiografie-inhoud in HTML-formaat.

    Args:
        bio_content: Gebruikerinsette vir hul persoonlike biografiebeskrywing

    Returns:
        Vertoonde HTML-string wat die geformateerde biografie bevat
    """
    template = Template('<div class="profile-bio">{{ bio_content }}</div>')
    return template.render(bio_content=bio_content)