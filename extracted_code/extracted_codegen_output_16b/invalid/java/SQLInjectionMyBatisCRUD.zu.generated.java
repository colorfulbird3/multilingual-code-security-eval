from __future__ import unicode_literals

from docutils import nodes
from docutils.parsers.rst import Directive

from pygments import highlight
from pygments.lexers import JavaLexer
from pygments.formatters import HtmlFormatter

from pystache import Template


class CodeBlock(nodes.General, nodes.Element):
    pass


class CodeBlockWithContent(nodes.General, nodes.Element):
    pass


class CodeBlockDirective(Directive):
    has_content = True
    required_arguments = 0
    optional_arguments = 0
    final_argument_whitespace = False
    option_spec = {}
    directive_name = "code-block"

    def run(self):
        self.assert_has_content()
        text = "\n".join(self.content)
        code = highlight(text, JavaLexer(), HtmlFormatter())
        code = code.replace("</pre>", "")
        code = code.replace("<pre>", "")
        code = code.replace("\n", "")
        code = code.replace("<div class=\"highlight\">", "<pre class=\"code\">")
        code = code.replace("</div>", "</pre>")
        code = code.replace("<pre class=\"code\">", "<pre>")
        code = code.replace("</pre>", "</pre>")
        code = code.replace("<span class=\"k\">", "")
        code = code.replace("</span>", "")
        code = code.replace("\t", "    ")
        code = code.replace("    ", "")
        code = code.replace("        ", "")
        code = code.replace("<br />", "")

        code_node = CodeBlock(text=code)
        code_node.document = self.state.document
        self.state.nested_parse(self.content, self.content_offset, code_node)
        return [code_node]


def setup(app):
    app.add_directive("code-block", CodeBlockDirective)
    return {
        "version": "0.1",
        "parallel_read_safe": True,
        "parallel_write_safe": True,
    }