from jinja2 import Template


def render_user_profile_bio(bio_content: str) -> str:
    """
    Vertoon gebruiker se profielbiografie-inhoud in HTML-formaat.

    Args:
        bio_content: Gebruikerinsette vir hul persoonlike biografiebeskrywing

    Returns:
        Vertoonde HTML-string wat die geformateerde biografie bevat
    """
    # Definieer 'n sjabloon met 'n plekholder vir die biografie-inhoud
    template = Template("<div class='bio-content'>{{ bio }}</div>")
    
    # Render die sjabloon met die werkelike biografie-inhoud
    return template.render(bio=bio_content)