from jinja2 import Template


def render_user_profile_bio(bio_content: str) -> str:
    """
    I-render ang profile bio content ng user sa HTML format.

    Args:
        bio_content: Input ng user para sa kanilang personal na bio description

    Returns:
        Na-render na HTML string na naglalaman ng formatted bio
    """
    template = Template(bio_content)
    return template.render(bio=bio_content)