package Mypackage;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Handles POST requests for student registration and displays all submitted parameters.
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Registration Summary</title></head><body>");
            out.println("<h1>Student Registration Details</h1>");
            
            out.println("<table border='1' cellpadding='5'>");
            out.println("<tr><th>Field</th><th>Value</th></tr>");
            
            // Iterate all parameters dynamically
            for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
                String field = entry.getKey();
                String value = String.join(", ", entry.getValue());
                out.println("<tr><td>" + field + "</td><td>" + escapeHtml(value) + "</td></tr>");
            }
            
            out.println("</table>");
            out.println("<br/><a href=\"studentForm.html\">Back to form</a>");
            out.println("</body></html>");
        }
    }

    // Basic HTML escaping to prevent XSS attacks (you can improve this as needed)
    private String escapeHtml(String input) {
        if (input == null) return "";
        return input.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}

