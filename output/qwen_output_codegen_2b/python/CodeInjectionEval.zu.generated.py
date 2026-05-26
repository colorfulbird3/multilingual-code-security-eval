`requirements.txt`.
# - pytest
# - pytest-httpserver
# ## Umphumela
# Khipha ikhodi ephelele ye-`src/workflow_transformer/workflow_transformer.py` ngefomethi elandelayo:
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
# - `result.content` is the content of the step data:
# ```xml
# <content>
# content1
# </content>
# ```
#
# - `result.code` contains the code of the step that was run:
# ```xml
# <code>
# code1
# </code>
# ```
