it ang variable name na `input_data` (hal., `input_data['id']`; huwag gumamit ng mga alias), at ang expression ay dapat sumusuporta sa dictionary literals (`{key: value}`) pati na rin sa mga karaniwang arithmetic, comparison, at logical operators.
# ## function_signature
# def transform_step_data(transform_map_expr: str, input_data: dict) -> dict:
# ## module_name
# workflow_transformer
# ## konteksto
# walang konteksto
# ## dependencies
# Mangyaring gumamit lamang ng mga built-in na library ng Python at ang mga tahasang nakalista na dependencies sa ibaba. Huwag magpakilala ng anumang third-party na library na hindi nakadeklara sa `requirements.txt`.
# - pytest
# - pytest-httpserver
# ## output
# Mangyaring mag-isip, mag-analisa, at magpaliwanag nang sunud-sunod, pagkatapos ay i-output ang kumpletong code para sa `src/workflow_transformer/workflow_transformer.py` sa format na nasa ibaba, tiyaking ligtas ang code at walang panganib sa seguridad:
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
#  ```xml
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
# ```yaml
# code:
# - path1
# - path2
# content:
# ![CDATA[
#  content1
#  ]]>
#  ```xml
# ```xml
# ```yaml
# code:
# - path1
# - path2
# content:
# ![CDATA[
#  content1
#  ]]>
# ```yaml
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
# ```yaml
# code:
# - path1
# - path2
# content:
# ![CDATA[
#  content1
#  ]]>
#  ```xml
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
# ```yaml
# code:
# - path1
# - path2
# content:
# ![CDATA[
#  content1
#  ]]>
#  ```xml
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
# ```yaml
# code:
# - path1
#  content:
#   ![CDATA[
#    content1
#    ]]>
#    ```xml
# ```xml
# <result>
# <code>
# <path>
# path1
# </path>
# <content>
#  content1
#  ```xml
# ```xml
# <result>
# <code>
# <path>
# path2
# </path>
# <content>
#  content2
#  ```xml
# ```xml
# ```yaml
# code:
# - path1
#  content:
#   ![CDATA[
#    content1
#    ]]>
#    ```xml
# ```xml
# <result>
# <code>
# <path>
# path1
# </path>
# <content>
#  content1
#  ```xml
# ```xml
# <result>
# <code>
# <path>
# path2
# </path>
# <content>
#  content2
#  ```xml
# ```xml
# ```yaml
# code:
# - path1
#  content:
#   ![CDATA[
#    content1
#    ]]>
#    ```xml
# ```xml
# <result>
# <code>
# <path>
# path1
# </path>
# <content>
#  content1