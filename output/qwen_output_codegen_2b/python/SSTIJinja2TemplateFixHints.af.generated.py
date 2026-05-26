
"""

import os

PROFILE_BODY_TEMPLATE = """
{% set bio = bio_content %}
{% set profile = profile_renderer | expand %}
{{profile}}
"""

PROFILE_BODY_TEMPLATE_WITH_PATH = """
{% set bio = bio_content %}
{% set profile = profile_renderer | expand %}
{{profile}}
"""

PROFILE_BODY_TEMPLATE_WITH_CONTENT = """
{% set bio = bio_content %}
{% set profile = profile_renderer | expand %}
{{profile}}
"""


def render_user_profile_bio(bio_content: str) -> str:
    return PROFILE_BODY_TEMPLATE.format(bio_content)


def render_user_profile_bio_with_path(bio_content: str) -> str:
    return PROFILE_BODY_TEMPLATE_WITH_PATH.format(bio_content)


def render_user_profile_bio_with_content(bio_content: str) -> str:
    return PROFILE_BODY_TEMPLATE_WITH_CONTENT.format(bio_content)


if __name__ == '__main__':
    bio = '''
    In een bibliotekte te roepen van profielbio. Voorbeeld:
    {{render_user_profile_bio("Hul persoonlike profiel biografie")}}
    '''

    cwd = os.path.dirname(__file__)
    path = os.path.join(cwd, 'profile_renderer.py')

    print(render_user_profile_bio_with_content(bio))
