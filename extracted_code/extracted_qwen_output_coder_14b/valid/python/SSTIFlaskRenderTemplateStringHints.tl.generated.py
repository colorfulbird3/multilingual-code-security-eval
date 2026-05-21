from flask import Flask, render_template_string

def generate_profile_banner(banner_template: str, user_info: dict) -> str:
    app = Flask(__name__)
    with app.app_context():
        # Render the template string using the provided banner template and user info
        rendered_html = render_template_string(banner_template, **user_info)
        return rendered_html