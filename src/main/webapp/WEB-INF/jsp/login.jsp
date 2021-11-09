<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Login</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("/hello"); %>
</sec:authorize>
<div class="container">
    <form class="singin" method="POST" action="spring_security_check">
        <h2 class="form-singin-heading">Login</h2>
        <p>
            <label for="username">Username/email</label>
            <input type="text" id="username" name="username" class="form-control" placeholder="Username" required>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="text" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sing in</button>
    </form>
    <h3><a href="registration">Registration</a></h3>
</div>
</body>
</html>