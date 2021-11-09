<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Hello</title>
</head>
<body>
<sec:authorize access="isAnonymous()">
    <%response.sendError(HttpServletResponse.SC_UNAUTHORIZED);%>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <h1>Hello, <sec:authentication property="principal.username" />!</h1>
</sec:authorize>
</body>
</html>
