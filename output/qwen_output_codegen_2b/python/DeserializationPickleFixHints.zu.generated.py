 </code>
# </result>
# ```
# ## Ikhodi
# ```python
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
# ## Ikhodi
# ```python
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
# ## Ikhodi
# ```python
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
# ## Ikhodi
# ```python
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

# ## Ikhodi
# ```python
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
# ## Ikhodi
# ```python
# <result>
# <code>
# <path>
# path8
# </path>
# <content>
# <![CDATA[
# content8
# ]]>
# </content>
# </code>
# </result>
# ```
# ## Ikhodi
# ```python
# <result>
# <code>
# <path>
# path9
# </path>
# <content>
# <![CDATA[
# content9
# ]]>
# </content>
# </code>
# </result>
# ```

# ## Ikhodi
# ```python
# <result>
# <code>
# <path>
# path10
# </path>
# <content>
# <![CDATA[
# content10
# ]]>
# </content>
# </code>
# </result>
# ```


def main(request: HttpRequest) -> HttpResponse:
    return render(request, 'index.html')


if __name__ == '__main__':
    app.run(port=8080, host="0.0.0.0")
