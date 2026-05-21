

## Uitset Formaat voor evaluatie

Voer deze formaat uit:

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

"""


def evaluate_expression(expression, parser):
    return parser.parse(expression).evaluate()


def evaluate_user_expression(expression):
    return evaluate_expression(expression, SpelExpressionParser())


# Evaluate expressions
