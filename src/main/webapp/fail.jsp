<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Result: FAIL</title></head>
<body>
    <h2>Sorry, <%= request.getAttribute("studentName") %>!</h2>
    <p>Your marks: <%= request.getAttribute("studentMarks") %></p>
    <p style="color:red;"><b>You have FAILED.</b></p>
    
    <%@ include file="footer.jsp" %>
</body>
</html>
