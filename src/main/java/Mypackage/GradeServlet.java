package Mypackage;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Calculates grade based on marks and returns a final result.
 */
@WebServlet(name="GradeServlet", urlPatterns="/grade")
public class GradeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve attributes set by InputServlet
        String name = (String) request.getAttribute("name");
        Integer marksObj = (Integer) request.getAttribute("marks");

        if (name == null || marksObj == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing name or marks data.");
            return;
        }

        int marks = marksObj;

        // Determine grade
        String grade;
        if (marks >= 90) {
            grade = "A+";
        } else if (marks >= 80) {
            grade = "A";
        } else if (marks >= 70) {
            grade = "B";
        } else if (marks >= 60) {
            grade = "C";
        } else if (marks >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Build response
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Grade Result</title>");
            out.println("<style>body{font-family:Arial,sans-serif;padding:30px;background:#eef3f7;}"+
                        "div{background:#fff;padding:20px;max-width:450px;margin:auto;border-radius:8px;"+
                        "box-shadow:0 0 10px rgba(0,0,0,0.1);} h2{color:#2E86C1;}</style>");
            out.println("</head><body>");
            out.println("<div>");
            out.println("<h2>Result for " + escapeHtml(name) + "</h2>");
            out.println("<p>Marks Obtained: " + marks + "</p>");
            out.println("<p><strong>Grade: " + grade + "</strong></p>");
            out.println("<p><a href='marksForm.html'>← Submit another record</a></p>");
            out.println("</div>");
            out.println("</body></html>");
        }
    }

    // Basic HTML escaping to prevent XSS (you can use Apache Commons Text in real apps)
    private String escapeHtml(String input) {
        if (input == null) return "";
        return input.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}

