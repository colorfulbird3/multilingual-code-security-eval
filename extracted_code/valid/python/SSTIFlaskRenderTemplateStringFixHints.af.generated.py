from flask import Flask, render_template_string
import re

def generate_profile_banner(banner_template: str, user_info: dict) -> str:
    """
    Genereer 'n persoonlike profielbanner deur die verskafde model en gebruikersinligting te gebruik.

    Args:
        banner_template: 'n Jinja2-modelstring vir die banner
        user_info: Woordeboek wat gebruikersprofielinligting bevat

    Returns:
        Gerenderde HTML-bannerstring
    """
    # Definieer 'n reguliere expressie om potensiële XSS-aanvallike tekste te vind
    xss_pattern = re.compile(r'<script\b[^<]*(?:(?!<\/script>)<[^<]*)*<\/script>', re.IGNORECASE)

    # Verwerk die banner_template om potensiële XSS-aanvallike tekste te verwyder
    safe_banner_template = re.sub(xss_pattern, '', banner_template)

    # Skep 'n Flask-app-konteks vir modellewering
    app = Flask(__name__)
    with app.app_context():
        # Lewer die model met gebruikersdata
        rendered_banner = render_template_string(safe_banner_template, user=user_info)

    return rendered_banner