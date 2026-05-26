```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/ReportService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import ognl.Ognl;
import ognl.OgnlException;

/**
 * Service para sa pagkuha ng field value mula sa isang data object gamit ang OGNL expression.
 */
public class ReportService {

    /**
     * Kinukuha at sinusuri ang field value mula sa ibinigay na data object batay sa OGNL expression.
     *
     * @param expression Ang OGNL expression string na tutukoy sa field na kukunin.
     * @param dataRoot Ang root object na pagmumulan ng data.
     * @return Ang resulta ng pagsusuri ng expression.
     * @throws OgnlException Kung may error sa pag-parse o pagsusuri ng expression.
     */
    public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {
        return Ognl.getValue(expression, dataRoot);
    }
}
            ]]>
        </content>
    </code>
</result>
```

> **NOTE:** The code above is an example of using the W3C XML-based OGNL library.

## Response body

The response body is formatted as a `result` object, which contains the following fields:

| Field | Description |
|------|-------------|
| `code` | The result status code. |
| `path` | The path to the file that was used as the source of the script. |
| `content` | The content associated with the result. |

## Example response

> ```json
{
    "result": {
        "code": 200,
        "path": "src/main/java/com/example/service/ReportService.java",
        "content": "<![CDATA[\npackage com.example.service;\n\nimport ognl.OgnlException;\n\n/**\n * Service para sa pagkuha ng field value mula sa isang data object gamit ang OGNL expression.\n */\npublic class ReportService {\n\n    /**\n     * Kinukuha at sinusuri ang field value mula sa ibinigay na data object batay sa OGNL expression.\n     *\n     * @param expression Ang OGNL expression string na tutukoy sa field na kukunin.\n     * @param dataRoot Ang root object na pagmumulan ng data.\n     * @return Ang resulta ng pagsusuri ng expression.\n     * @throws OgnlException Kung may error sa pag-parse o pagsusuri ng expression.\n     */\n    public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {\n        return Ognl.getValue(expression, dataRoot);\n    }\n}\n]]>\n"}
```

## Error responses

If the response code is not 200, the response body may be formatted as a JSON object containing error details.
By default, the response body will be the exception message. This message can be overridden with the `message` parameter.

## Parameters

- `expression`: The OGNL expression string to use for the report.
- `dataRoot`: The root object for