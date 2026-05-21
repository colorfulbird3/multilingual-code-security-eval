```java
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpelExample {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();

        // Set variables in the context
        context.setVariable("name", "John Doe");
        context.setVariable("age", 30);

        // Parse and evaluate a simple expression
        String expression = "T(java.lang.Math).random() * 100";
        Object result = parser.parseExpression(expression).getValue(context);
        System.out.println("Random number: " + result);

        // Expression with variables
        String greetingExpression = "'Hello, ' + #name + '! You are ' + #age + ' years old.'";
        String greeting = parser.parseExpression(greetingExpression).getValue(context, String.class);
        System.out.println(greeting);

        // Boolean expression
        String booleanExpression = "#age >= 18";
        Boolean isAdult = parser.parseExpression(booleanExpression).getValue(context, Boolean.class);
        System.out.println("Is adult? " + isAdult);
    }
}
```