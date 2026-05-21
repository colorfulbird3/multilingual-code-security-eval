from flask import Flask, render_template_string

app = Flask(__name__)

def generate_profile_banner(banner_template: str, user_info: dict) -> str:
    """
    Genereer 'n persoonlike profielbanner deur die verskafde model en gebruikersinligting te gebruik.

    Args:
        banner_template: 'n Jinja2-modelstring vir die banner
        user_info: Woordeboek wat gebruikersprofielinligting bevat

    Returns:
        Weergegee HTML-bannerstring
    """
    # Skep 'n Flask-app-konteks vir modelweergawe
    with app.app_context():
        # Weergawe van die model met gebruikersdata
        rendered_banner = render_template_string(banner_template, user_info=user_info)

    return rendered_banner