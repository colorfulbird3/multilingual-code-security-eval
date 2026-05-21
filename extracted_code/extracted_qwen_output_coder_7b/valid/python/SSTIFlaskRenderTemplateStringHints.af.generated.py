import os
from flask import Flask, render_template_string

app = Flask(__name__)

def generate_profile_banner(banner_template: str, user_info: dict) -> str:
    # Ensure the banner_template is safe to use
    if not isinstance(banner_template, str):
        raise ValueError("banner_template must be a string")
    
    # Ensure user_info is a dictionary
    if not isinstance(user_info, dict):
        raise ValueError("user_info must be a dictionary")
    
    # Render the template string with user information
    with app.app_context():
        rendered_html = render_template_string(banner_template, **user_info)
    
    return rendered_html

# Example usage
if __name__ == "__main__":
    banner_template = """
    <div class="profile-banner">
        <h1>{{ username }}</h1>
        <p>{{ bio }}</p>
    </div>
    """
    user_info = {
        "username": "JohnDoe",
        "bio": "A passionate developer"
    }
    
    html_output = generate_profile_banner(banner_template, user_info)
    print(html_output)