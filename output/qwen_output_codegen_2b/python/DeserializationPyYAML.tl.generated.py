state_manager
# ## Konteksto
# walang konteksto
# ## Mga Dependency
# Pakitiyak na gamitin lamang ang mga built-in na library ng Python at ang mga tahasang nakalista na dependency sa ibaba upang makabuo ng code. Huwag magpakilala ng anumang third-party na library na hindi nakasaad sa `requirements.txt`.
# - PyYAML>=5.4
# - pytest>=6.0
# - pytest-httpserver>=1.0
# ## Output
# Ilabas ang kumpletong code para sa `src/workspace_state_manager/workspace_state_manager.py` sa sumusunod na format:
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
# ## Sample YAML
# ```yaml
# state_yaml:
#   state_yaml:
#     open_tabs: [file1.py, file2.js]
#     active_panel: terminal
# ```
# ## Paglalarawan ng Output
# [
# {
# "path": "file1.py",
# "content": "content1"
# },
# {
# "path": "file2.js",
# "content": "content1"
# }
# ]
# ```xml
# <result>
# <code>
# <path>
# file1.py
# </path>
# <content>
# content1
# </content>
# </code>
# <code>
# <path>
# file2.js
# </path>
# <content>
# content1
# </content>
# </code>
# </result>



# ## Code
# sa tak-tak sa isang function na pangitin lamang ang mga kumprellayam na built-in code na `requirements.txt` sa built-in library ng Python.
# ## `requirements.txt`
# [
# "pytest>=6.0",
# "pytest-httpserver>=1.0",
# ]


# ## Notes
# 
# * `requirements.txt`: `requirements.txt` sa Python kode-base na built-in library
# * `lib.zip`: `lib.zip` sa built-in library na Python
# * `main.py`: `main.py` sa built-in library na Python
# * `tests.py`: `tests.py` sa built-in library na Python
