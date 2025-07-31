<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String studentName = request.getParameter("studentName");
    String marksStr = request.getParameter("studentMarks");
    int marks = 0;
    if (marksStr != null && !marksStr.isEmpty()) {
        try {
            marks = Integer.parseInt(marksStr);
        } catch (NumberFormatException e) {
            marks = 0;
        }
    }

    // Pass parameters via request objects so the result pages can access them
    request.setAttribute("studentName", studentName);
    request.setAttribute("studentMarks", marks);

    if (marks >= 40) {
        RequestDispatcher rd = request.getRequestDispatcher("pass.jsp");
        rd.forward(request, response);
    } else {
        RequestDispatcher rd = request.getRequestDispatcher("fail.jsp");
        rd.forward(request, response);
    }
%>
