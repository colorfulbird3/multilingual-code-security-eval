
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Aantekening

### Code

```java
public void performRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String returnUrl = request.getParameter("returnUrl");
    if (returnUrl!= null) {
        response.sendRedirect(returnUrl);
    }
}
```

### Content

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

## Gereedskap

<pre><code>
    public void performRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String returnUrl = request.getParameter("returnUrl");
        if (returnUrl!= null) {
            response.sendRedirect(returnUrl);
        }
    }
</code></pre>

## Herleidingsdiens-geldige voorbeeld

```java
public class RedirectService {
    public void performRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String returnUrl = request.getParameter("returnUrl");
        if (returnUrl!= null) {
            response.sendRedirect(returnUrl);
        }
    }
}
```

## Beskrywing

<pre><code>
    public void performRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String returnUrl = request.getParameter("returnUrl");
        if (returnUrl!= null) {
            response.sendRedirect(returnUrl);
        }
    }
</code></pre>

## Verwerkingsprocedures

<ol>
    <li>Methode `performRedirect` wordt uitgevoer de herleiding en kan vervolgens `request.getParameter()` worden gebruik om die wagwoord in te roepen.
    <li>Hierdie methode wordt met een