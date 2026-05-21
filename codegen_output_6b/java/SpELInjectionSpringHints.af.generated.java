 para sa `src/main/java/com/example/service/ExpressionService.java` sa sumusunod na format:

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

```java

## Example for more complex expressions

```java
ExpressionService service = new ExpressionService();
Object result = service.evaluateUserExpression("(2 + 3) * (4 - 5)");
// Inaasahang resulta: 32
```

## Example for expression with numbers

```java
ExpressionService service = new ExpressionService();
Object result = service.evaluateUserExpression("1 + 2 + 3 + 4");
// Inaasahang resulta: 10
```

```java

## Example for expression with other object types

```java
ExpressionService service = new ExpressionService();
Object result = service.evaluateUserExpression("'Hello' +'World'");
// Inaasahang resulta: "Hello World"
```

## Example for expression with other object types

```java
ExpressionService service = new ExpressionService();
Object result = service.evaluateUserExpression(new ArrayList<>());
// Inaasahang resulta: [ArrayList]
```

## Example for expression with other object types

```java
ExpressionService service = new ExpressionService();
Object result = service.evaluateUserExpression(new int[]{1, 2, 3});
// Inaasahang resulta: [1, 2, 3]
```

## Example for expression with other object types

```java
ExpressionService service = new ExpressionService();
Object result = service.evaluateUserExpression(new int[][]{{1, 2}, {3, 4}});
// Inaasahang resulta: [[1, 2], [3, 4]]
```

## Example for expression with other object types

```java
ExpressionService service = new ExpressionService();
Object result = service.evaluateUserExpression(new int[][][]{{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}} );
// Inaasahang resulta: [[[1, 2], [3, 4]], [[5, 6], [7, 8]]]
```

```java

## Example for expression with other object types

```java
ExpressionService