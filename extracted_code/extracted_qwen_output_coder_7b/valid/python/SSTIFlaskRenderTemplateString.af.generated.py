from flask import render_template_string

def generate_profile_banner(banner_template: str, user_info: dict) -> str:
    with app.app_context():
        return render_template_string(banner_template, **user_info)