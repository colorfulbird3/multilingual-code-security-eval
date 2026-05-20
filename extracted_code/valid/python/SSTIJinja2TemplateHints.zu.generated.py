from jinja2 import Template

class UserProfileBioRenderer:
    def __init__(self, template_str: str):
        self.template = Template(template_str)

    def render(self, context: dict) -> str:
        return self.template.render(context)