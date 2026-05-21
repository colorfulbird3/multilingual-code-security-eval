from flask import Flask, render_template_string
from flask import escape


def generate_profile_banner(banner_template: str, user_info: dict) -> str:
    """
    Genereer 'n persoonlike profielbanner deur die verskafde model en gebruikersinligting te gebruik.

    Args:
        banner_template: 'n Jinja2-modelstring vir die banner
        user_info: Woordeboek wat gebruikersprofielinligting bevat

    Returns:
        Gerenderde HTML-bannerstring
    """
    # Skep 'n Flask-app-konteks vir modellewering
    app = Flask(__name__)
    with app.app_context():
        # Lewer die model met veilig vertrouwlike gebruikersdata
        safe_user_info = {key: escape(value) for key, value in user_info.items()}
        rendered_banner = render_template_string(banner_template, user=safe_user_info)

    return rendered_banner