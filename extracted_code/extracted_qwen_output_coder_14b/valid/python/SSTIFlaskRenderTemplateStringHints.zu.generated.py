import flask
from flask import render_template_string

def generate_profile_banner(banner_template: str, user_info: dict) -> str:
    app = flask.Flask(__name__)
    with app.app_context():
        rendered_template = render_template_string(banner_template, user=user_info)
        return rendered_template