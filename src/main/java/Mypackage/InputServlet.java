package Mypackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;

/**
 * Receives name and marks, then forwards to GradeServlet.
 */
@WebServlet(name="InputServlet", urlPatterns="/input")
public class InputServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Fetch form parameters
        String name = request.getParameter("name");
        String marksStr = request.getParameter("marks");

        // Basic input validation
        if (name == null || name.isEmpty() || marksStr == null || marksStr.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Name and marks must be provided.");
            return;
        }

        int marks;
        try {
            marks = Integer.parseInt(marksStr);
            if (marks < 0 || marks > 100) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Marks must be between 0 and 100.");
                return;
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid marks entered.");
            return;
        }

        // Set attributes to pass to next servlet
        request.setAttribute("name", name);
        request.setAttribute("marks", marks);

        // Forward the request to GradeServlet at /grade URL
        RequestDispatcher dispatcher = request.getRequestDispatcher("/grade");
        dispatcher.forward(request, response);
    }
}

