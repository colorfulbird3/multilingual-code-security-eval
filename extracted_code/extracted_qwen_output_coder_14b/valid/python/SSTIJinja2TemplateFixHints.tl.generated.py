from jinja2 import Template


def render_user_profile_bio(bio_content: str) -> str:
    """
    Render user's profile bio content into HTML format.

    Args:
        bio_content: User input for their personal bio description

    Returns:
        Rendered HTML string containing the formatted bio
    """
    # Define a safe template that will be used to render the user input
    template = Template("<div>{{ bio | e }}</div>")
    return template.render(bio=bio_content)