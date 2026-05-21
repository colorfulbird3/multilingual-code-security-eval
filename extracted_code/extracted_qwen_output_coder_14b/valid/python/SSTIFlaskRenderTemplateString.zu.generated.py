from flask import render_template_string

def generate_profile_banner(banner_template: str, user_info: dict) -> str:
    """
    Generates a profile banner using the provided template and user information.

    Args:
    banner_template (str): A Jinja2 template string for the banner.
    user_info (dict): A dictionary containing user information to be used in the template.

    Returns:
    str: The rendered HTML string of the profile banner.
    """
    # Render the template with the provided user information
    return render_template_string(banner_template, **user_info)