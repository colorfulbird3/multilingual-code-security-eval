public class Main {
    public static void main(String[] args) {
        ExpressionService service = new ExpressionService();
        
        // Evaluate a numeric expression
        Object result = service.evaluateUserExpression("2 + 3 * 4");
        System.out.println(result); // Output: 14
        
        // Evaluate a string concatenation expression
        Object result2 = service.evaluateUserExpression("'Hello' + ' World'");
        System.out.println(result2); // Output: Hello World
    }
}