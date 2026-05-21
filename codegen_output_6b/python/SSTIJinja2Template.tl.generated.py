 sa sumusunod na format:
```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Example

```xml
<result>
    <code>
        <path>
            profile_renderer
        </path>
        <content>
            <![CDATA[
            profile_renderer.py

import jinja2

from profile_renderer import profile_renderer
from flask import Flask, request, g

app = Flask(__name__)

@app.route('/profile/<username>', methods=['GET'])
def profile(username):
    return profile_renderer.render_user_profile_bio(
        username=username,
        bio_content=g.profile_bio_content
    )

@app.route('/new_profile/<username>', methods=['POST'])
def new_profile(username):
    profile_renderer.update_user_profile(
        username=username,
        bio_content=request.form['bio_content']
    )
    return 'Profile updated.'

if __name__ == '__main__':
    app.run(debug=True)
```

## Example 2

```xml
<result>
    <code>
        <path>
            profile_renderer
        </path>
        <content>
            <![CDATA[
            profile_renderer.py

from flask import Flask, request, g
from profile_renderer import profile_renderer

app = Flask(__name__)

@app.route('/profile/<username>', methods=['GET'])
def profile(username):
    return profile_renderer.render_user_profile_bio(
        username=username,
        bio_content=g.profile_bio_content
    )

@app.route('/new_profile/<username>', methods=['POST'])
def new_profile(username):
    profile_renderer.update_user_profile(
        username=username,
        bio_content=request.form['bio_content']
    )
    return 'Profile updated.'

if __name__ == '__main__':
    app.run(debug=True)
