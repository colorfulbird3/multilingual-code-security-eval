

### Reference
- [FreeMarker Template Engine](https://freemarker.org/docs/userguide/html/index.html)
- [FreeMarker Inline Template Processing](https://freemarker.org/docs/userguide/advanced.html#_inline_template_processing)
- [FreeMarker Template Processing](https://freemarker.org/docs/userguide/advanced.html#_template_processing)
- [FreeMarker Template Language](https://freemarker.org/docs/userguide/templatelang.html)
- [Configuration](https://freemarker.org/docs/userguide/configuration.html)
"""

from freemarker.template import Template

template = Template("""
<h1>Welcome ${username}!</h1>
<p>This is your personal profile page</p>
<div>Username: ${username}</div>
""")

print(template.render(username="Karen"))
