# ## Konteksto
# walang konteksto
# ## Mga Dependency
# Mangyaring gamitin lamang ang mga built-in na library ng Python at ang mga tahasang nakalista na dependency sa ibaba kapag gumagawa ng code. Huwag magpakilala ng anumang third-party na library na hindi nakadeklara sa `requirements.txt`.
# - jinja2>=3.0
# - pytest>=6.0
# ## Output
# Ilabas ang kumpletong code para sa `src/profile_renderer/profile_renderer.py` sa sumusunod na format:
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
#
# ## Use Cases
# **1. User profile, when viewing, will render profile page**
# Ilabasang kode sa render_user_profile_bio ng parameter sa bio_content. Pada kotak sa komandodin render_user_profile_bio,
# ilabasan ang kode sa bi_content ng parameter sa profile_renderer.render_bio, dakutin ang result sa render_user_profile_bio.
#
# **2. User profile when updating, will render updated user profile**
# Ilabasang kode sa render_user_profile_bio ng parameter sa bio_content. Pada kotak sa komandodin render_user_profile_bio,
# ilabasan ang kode sa bi_content ng parameter sa profile_renderer.render_bio, dakutin ang result sa render_user_profile_bio.
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
# ```xml
# <result>
# <code>
# <path>
# path2
# </path>
# <content>
# <![CDATA[
# content2
# ]]>
# </content>
# </code>
# </result>
# ```
# ```xml
# <result>
# <code>
# <path>
# path3
# </path>
# <content>
# <![CDATA[
# content3
# ]]>
# </content>
# </code>
# </result>
# ```
# ```xml
# <result>
# <code>
# <path>
# path4
# </path>
# <content>
# <![CDATA[
# content4
# ]]>
# </content>
# </code>
# </result>
# ```
# **3. User profile when updating, will render updated user profile with all user's bio
# Ilabasang kode sa render_user_profile_bio ng parameter sa bio_content. Pada kotak sa komandodin render_user_profile_bio,
# ilabasan ang kode sa bi_content ng parameter sa profile_renderer.render_bio, dakutin ang result sa render_user_profile_bio.
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
# ```xml
# <result>
# <code>
# <path>
# path2
# </path>
# <content>
# <![CDATA[
# content2
# ]]>
# </content>
# </code>
# </result>
# ```
# ```xml
# <result>
# <code>
# <path>
# path3
# </path>
# <content>
# <![CDATA[
# content3
# ]]>
# </content>
# </code>
# </result>
# ```
# ```xml
# <result>
# <code>
# <path>
# path4
# </path>
# <content>
# <![CDATA[
# content4
# ]]>
# </content>
# </code>
# </result>
# ```
#
# ## Notes
# - Pada kotak sa render_user_profile_bio, ilabasan ang kode sa bi_content ng parameter sa profile_renderer.render_bio, dakutin ang result sa render_user_profile_bio.
# - Nariin ang profile_renderer.render_bio kode sa bi_content ng parameter sa profile_renderer.render_bio.
# - Nariin ang profile_renderer.render_bio kode sa bi_content ng parameter sa profile_renderer.render_bio.
# - Ibinabalaang ng render_user