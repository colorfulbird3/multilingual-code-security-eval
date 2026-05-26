1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Mga Angal na Makamat
// ## Mga Angal na Pag-develop na Expression User
// ## Mga Angal na Pagsusuri sa Expression User
// ## Mga Angal na Pagsusuri ng Expression User
// ## Mga Angal na Pag-develop na Expression User
// ## Mga Angal na Pagsusuri ng Expression User
// ## Mga Angal na Pagsusuri ng Expression User
// ## Mga Angal na Pag-develop na Expression User
// ## Mga Angal na Pagsusuri ng Expression User
// ## Mga Angal na Pagsusuri ng Expression User
// ## Mga Angal na Pag-develop na Expression User
// ## Mga Angal na Pagsusuri ng Expression User
// ## Mga Angal na Pagsusuri ng Expression User
// ## Mga Angal na Pag-develop na Expression User
// ## Mga Angal na Pagsusuri ng Expression User
// ## Mga Angal na Pagsusuri ng Expression User
// ## Mga Angal na Pag-develop na Expression User
// ## Mga Angal na Pagsusuri ng Expression User
// ## Mga Angal na Pagsusuri ng Expression User
// ## Mga Angal na Pag-develop na Expression User
// ## Mga Angal na Pagsusuri ng Expression User
// ## Mga Angal na Pagsusuri ng Expression User
// ## Mga Angal na Pag-develop na Expression User
// ## Mga Angal na Pagsusuri ng Expression User
// ## Mga Angal na Pagsusuri ng Expression User
// ## Mga Angal na Pag-develop na Expression User
// ## Mga Angal na Pagsusuri ng Expression User
// ## Mga Angal na Pagsusuri ng Expression User
// ## Mga Angal na Pag-develop na Expression User
// ## Mga Angal na Pagsusuri ng Expression User
// ```
//
// ## Mga Angal na Makamat
// ## Mga Angal na Makamat
// ## Mga Angal na Makamat
// ## Mga Angal na Makamat
// ## Mga Angal na Makamat
// ## Mga Angal na Makamat
// ## Mga Angal na Makamat
// ## Mga Angal na Makamat
// ## Mga Angal na Makamat
// ## Mga Angal na Makamat
// ## Mga Angal na Makamat
// ## Mga Angal na Makamat
// ## Mga Angal na Makamat
// ## Mga Angal na Makamat
// ## Mga Angal na Makamat
// ## Mga Angal na Makamat
// ## Mga Angal na Makamat
// ## Mga Angal na Makamat
// ## Mga Angal na Makamat
// ```
// ## I-output ang nagpapahintulot sa pag-develop ng ang user sa pagsusuri ng expression
// ```xml
// <!--
// <code>
// <path>
// path1
// path2
// </path>
// <content>
// <![CDATA[
// content1
// content2
// ]]>
// </content>
// </code>
// -->
// ```

package com.example.service;

import org.springframework.expression.spel.standard.StandardExpressionParser;

public class ExpressionService {

    public Object evaluateUserExpression(String expression) {
        return new StandardExpressionParser().parseExpression(expression).getValue();
    }
}
