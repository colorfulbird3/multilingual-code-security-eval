from flask import render_template_string


def generate_profile_banner(banner_template: str, user_info: dict) -> str:
    """
    Genereer 'n persoonlike profielbanner deur die verskafde model en gebruikersinligting te gebruik.

    Args:
        banner_template: 'n Jinja2-modelstring vir die banner
        user_info: Woordeboek wat gebruikersprofielinligting bevat

    Returns:
        Weergegee HTML-bannerstring
    """
    # Weergawe van die model met gebruikersdata
    rendered_banner = render_template_string(banner_template, user=user_info)

    return rendered_banner