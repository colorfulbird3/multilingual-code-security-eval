
```


`<code><path>path1</path><content><![CDATA[
        content1
    ]]></content>
</code>`
"""


def test_readme_md_to_xml(readme_md_file):
    """
    Read the README.md file and convert it to XML.
    """

    file_contents = read_file(readme_md_file)
    # print(file_contents)
    return file_contents
