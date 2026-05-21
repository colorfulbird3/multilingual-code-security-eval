<%@ page language="java"%>

<%
    String userUrl = "http://localhost:8080/myApp/myUser";
    String userContent = fetchUrlContent(userUrl);
%>

hello world!
<%= userContent %>