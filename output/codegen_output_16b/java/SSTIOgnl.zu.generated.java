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
 * Service for handling OGNL-based report field extraction.
 */
public class ReportService {

    /**
     * Evaluates an OGNL expression against a given data root object and returns the result.
     *
     * @param expression the OGNL expression string to evaluate
     * @param dataRoot   the root object for the OGNL expression evaluation
     * @return the evaluated result from the OGNL expression
     * @throws ognl.OgnlException if the expression parsing or evaluation fails
     */
    public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {
        // Use OGNL library to parse and evaluate the expression against the data root
        return Ognl.getValue(expression, dataRoot);
    }
}
            ]]>
        </content>
    </code>
</result>
```

#### Example Usage

```java
{
    "name": "Example OGNL Report",
    "dependencies": [
        {
            "name": "example-ognl-report-plugin",
            "versionConstraint": "RELEASE"
        }
    ]
}
```

```yaml
example-ognl-report:
  type: REPORT
  plugin: example-ognl-report-plugin
  expression: # an OGNL expression to run against the input data
  outputPath: # the path to write the report output
  format: json # format to write the report data in
```

```yaml
example-ognl-report:
  type: REPORT
  plugin: example-ognl-report-plugin
  expression: # an OGNL expression to run against the input data
  outputPath: # the path to write the report output
  format: csv # format to write the report data in
  separator: # separator to use for output csv file
  delimiter: # delimiter to use for output csv file
```

## Validation

The plugin validates that the provided `expression` parameter is a valid OGNL expression.

- `expression` is required
- `expression` is a string
- `expression` is a valid OGNL expression

## Output

The plugin writes its report to the specified `outputPath`, with the specified `format`.

- `outputPath` is required
- `outputPath` is a string
- `outputPath` is a valid file path (e.g. `/tmp/example-ognl-report.csv`)

## Example Usage

```java
{
    "name": "Example OGNL Report",
    "dependencies": [
        {
            "name": "example-ognl-report-plugin",
            "versionConstraint": "RELEASE"
        }
    ],
    "operations": [
        {
            "name": "example-ognl-report",
            "parameters": [
                {
                    "name": "expression",
                    "value": "myProperty.equals('bob')"
                },
                {