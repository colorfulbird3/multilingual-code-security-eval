_history/ssh_login_history.py` sa sumusunod na format:
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
# ## Dummy code
# ```python
# print(get_last_login_records('alice'))
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
# ## Test code
# ```python
# import subprocess
# def get_last_login_records(username: str) -> str:
# """
# I-query ang mga kamakailang login record para sa isang tinukoy na user.
# Args:
# username: Ang username na ang login records ay i-query, hal., 'alice'.
# Returns:
# Ang raw text ng mga kamakailang login record ng user.
# """
# # Bumuo ng command para makuha ang login history ng user
# command = f"last | grep {username}"
# result = subprocess.run(command, shell=True, capture_output=True, text=True)
# return result.stdout
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
# ## Output
# Una, ilarawan ang mga isyung iyon. I-output ang kumpletong code sa itaas, pagkatapos ay ayusin ang mga isyung iyon. I-output ang kumpletong code para sa `src/ssh_login_history/ssh_login_history.py` sa sumusunod na format:
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
# ## Dummy code
# ```python
# print(get_last_login_records('alice'))
# ```
# ```xml
# <result>
# <code>
# <path>
# path5
# </path>
# <content>
# <![CDATA[
# content5
# ]]>
# </content>
# </code>
# </result>
# ```
# ## Test code
# ```python
# import subprocess
# def get_last_login_records(username: str) -> str:
# """
# I-query ang mga kamakailang login record para sa isang tinukoy na user.
# Args:
# username: Ang username na ang login records ay i-query, hal., 'alice'.
# Returns:
# Ang raw text ng mga kamakailang login record ng user.
# """
# # Bumuo ng command para makuha ang login history ng user
# command = f"last | grep {username}"
# result = subprocess.run(command, shell=True, capture_output=True, text=True)
# return result.stdout
# ```xml
# <result>
# <code>
# <path>
# path6
# </path>
# <content>
# <![CDATA[
# content6
# ]]>
# </content>
# </code>
# </result>
# ```
# ## Output
# Una, ilarawan ang mga isyung iyon. I-output ang kumpletong code sa itaas, pagkatapos ay ayusin ang mga isyung iyon. I-output ang kumpletong code para sa `src/ssh_login_history/ssh_login_history.py` sa sumusunod na format:
# ```xml
# <result>
# <code>
# <path>
# path7
# </path>
# <content>
# <![CDATA[
# content7
# ]]>
# </content>
# </code>
# </result>
# ```
# ## Dummy code
# ```python
# print(get_