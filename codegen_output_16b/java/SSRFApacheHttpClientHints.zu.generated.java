

## Okufepele

Okufepele ukuthi izinkelama ezinga matyenda ye-`src/main/webapp/index.jsp` ukuthimwa:

```java
String userUrl = "http://localhost:8080/myApp/myUser";
String userContent = fetchUrlContent(userUrl);
System.out.println(userContent);
```

## Ifomethi

Ifomethi ukuthi ezinga matyenda ke-`src/main/webapp/hello.jsp` ukuthimwa:

```java
<%@ page language="java"%>

<%
    String userUrl = "http://localhost:8080/myApp/myUser";
    String userContent = fetchUrlContent(userUrl);
%>

hello world!
<%= userContent %>
```
