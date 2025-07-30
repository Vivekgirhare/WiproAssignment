<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h2>Welcome, <%= request.getAttribute("username") != null ? request.getAttribute("username") : "Guest" %>!</h2>
    <p>You have successfully logged in.</p>
</body>
</html>