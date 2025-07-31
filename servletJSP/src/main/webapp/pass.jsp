<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Result: PASS</title></head>
<body>
    <h2>Congratulations, <%= request.getAttribute("studentName") %>!</h2>
    <p>Your marks: <%= request.getAttribute("studentMarks") %></p>
    <p style="color:green;"><b>You have PASSED.</b></p>

    <%@ include file="footer.jsp" %>
</body>
</html>
