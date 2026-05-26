path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Uitvoering:
// * klas: `com.example.service.ExpressionService`
// * metamodel: `org.springframework.context.annotation.Configuration`
// * method: `evaluateUserExpression`
// * method parameter: `String expression`
// * result: `Object`
// * result type: `Collection<Object>`
// * code: `src/main/java/com/example/service/ExpressionService.java`
// * result type: `Collection<String>`
// * code: `src/main/java/com/example/service/ExpressionService.java`
package com.example.service;

// Java:
// import com.example.service.ExpressionService;

// Spring configuration:
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExpressionService {

    private static final String TEST = "test";

    public String evaluateUserExpression(String expression) {
        return TEST;
    }
}
