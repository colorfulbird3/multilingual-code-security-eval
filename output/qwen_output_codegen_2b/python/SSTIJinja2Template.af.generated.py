el wat nie in `requirements.txt` verklaar is nie.
# - jinja2>=3.0
# - pytest>=6.0
# ## Uitvoer
# Voer die volledige kode vir `src/profile_renderer/profile_renderer.py` uit in die volgende formaat:
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
# </xml>
# - jinja2>=3.0
# - pytest>=6.0

import os
import json
from collections import OrderedDict

# ## Code
from pytest_bdd.given import given
from pytest_bdd.then import then


@given('we have a user profile')
def we_have_a_user_profile(request):
    # ## Code
    request.addfinalizer(lambda: os.remove('profile.json'))
    path1 = 'profile.json'
    with open(path1, 'w') as f:
        json.dump({'content': {'bio_content': 'Liefhebber van koffie en kode'}}, f)

        with open('profile.xml', 'w') as f:
            f.write('<xml><result><code><path>%s</path><content>'
                    '<![CDATA[%s]]></content></code></result>'
                    '</xml>' % (path1, 'content1'))


@then('we should get back the correct profile content')
def we_should_get_back_the_correct_profile_content(request):
    # ## Code
    with open('profile.json') as f:
        profile = json.load(f)
    with open('profile.xml') as f:
        xml = f.read()

    assert profile['content']['bio_content'] == xml
    assert profile['content']['bio_content'] == 'Liefhebber van koffie en kode'
