<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Failed</title>
</head>
<body>
    <h2>Login Failed</h2>
    <p style="color:red;">
      <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "Unknown error" %>
    </p>
    <p><a href="login.jsp">Back to Login</a></p>
</body>
</html>
