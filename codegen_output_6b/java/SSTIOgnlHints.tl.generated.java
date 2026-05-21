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
 */
package org.jbake.template;

import java.util.Map;

import ognl.PropertyAccessor;

import org.apache.commons.lang3.StringEscapeUtils;
import org.jbake.app.ConfigUtil;
import org.jbake.app.Content;

/**
 * This is the main template used to render the posts.
 *
 * @author Jonathan S. Harbour
 */
public class Index extends Macro {

    /**
     * Index template name.
     */
    public static final String NAME = "index";

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Content content, Map<String, Object> args) {
        Map<String, Object> config = ConfigUtil.configurationFor(getContext());

        String expression = config.get("index.expression").toString();
        Object result = null;
        try {
            result = Ognl.getValue(expression, content.get());
        } catch (final OgnlException e) {
            throw new RuntimeException(e);
        }

        String output = StringEscapeUtils.escapeXml(result.toString());
        output = output + "<hr/>\n<div class=\"body-text\">\n" + StringEscapeUtils.escapeXml(result.toString());

        content.setBody(output);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public PropertyAccessor getPropertyAccessor() {
        return null;
    }
}