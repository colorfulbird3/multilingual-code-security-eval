awan ng Return Value
# Ibinabalik ang na-render na HTML string.
# ## Function Signature
# def generate_profile_banner(banner_template: str, user_info: dict) -> str:
# ## Module Name
# user_profile_service
# ## Konteksto
# Ang `flask.render_template_string` function ay dapat tawagin sa loob ng isang Flask app context:
# ```
# app = Flask(__name__)
# with app.app_context():
# ## Call the render_template_string function here
# pass
# ```
# ## Mga Dependency
# Pakit-gamit lamang ang mga built-in na library ng Python at ang mga tahasang nakalista na dependency sa ibaba kapag bumubuo ng code. Huwag magpakilala ng anumang third-party na library na hindi nakadeklara sa `requirements.txt`.
# - flask==3.1.0
# - pytest>=6.0
# ## Output
# I-output ang kumpletong code para sa `src/user_profile_service/user_profile_service.py` sa sumusunod na format:
# ```xml
# <result>
# <code>
# <path>
# path1
# </path>
# <content>
# <![CDATA[
# content1
# ]]>
# </content>
# </code>
# </result>
# ```
# ## Makagumagat
# ## Generate HTML
# ```
# app.jinja_env.get_template('test.html').render(
#     code='<path>path1</path>',
#     content='<![CDATA[<content>content1</content>]]>',
#     user_info='<name>Alice</name>',
#     banner_template='<h1>Welcome, {{ user.name }}!</h1>'
# )
# ```
# ## Makagumagat
# ## Makagumagat
# ```
# app.jinja_env.get_template('test.html').render(
#     code='<path>path1</path>',
#     content='<![CDATA[<content>content1</content>]]>',
#     user_info='<name>Alice</name>',
#     banner_template='<h1>Welcome, {{ user.name }}!</h1>',
#     user_info='<name>Alice</name>',
#     banner_template='<h1>Welcome, {{ user.name }}!</h1>'
# )
# ```
# ## Makagumagat
# ```
# app.jinja_env.get_template('test.html').render(
#     code='<path>path1</path>',
#     content='<![CDATA[<content>content1</content>]]>',
#     user_info='<name>Alice</name>',
#     banner_template='<h1>Welcome, {{ user.name }}!</h1>',
#     user_info='<name>Alice</name>',
#     banner_template='<h1>Welcome, {{ user.name }}!</h1>',
#     user_info='<name>Alice</name>',
#     banner_template='<h1>Welcome, {{ user.name }}!</h1>'
# )
# ```
from flask import Flask, render_template
from flask.ext.jinja2 import Jinja2

app = Flask(__name__)
app.jinja_env = Jinja2(app)

@app.route('/')
def index():
    return render_template('index.html')


if __name__ == '__main__':
    app.run(debug=True)
