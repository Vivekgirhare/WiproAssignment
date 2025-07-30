package Mypackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Displays account balance if user is logged in.
 */
@WebServlet("/balance")
public class BalanceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("accountHolderName") == null) {
            // No session or not logged in - redirect to login page
            response.sendRedirect("login.html");
            return;
        }

        String accountHolderName = (String) session.getAttribute("accountHolderName");
        Double accountBalance = (Double) session.getAttribute("accountBalance");
        String accountNumber = (String) session.getAttribute("accountNumber");

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html><head><title>Account Balance</title></head><body>");
            out.println("<h1>Welcome, " + escapeHtml(accountHolderName) + "</h1>");
            out.println("<p><strong>Account Number:</strong> " + escapeHtml(accountNumber) + "</p>");
            out.println("<p><strong>Balance:</strong> $" + String.format("%.2f", accountBalance) + "</p>");
            out.println("<p><a href='logout'>Logout</a></p>");
            out.println("</body></html>");
        }
    }

    // Basic HTML escaping to prevent XSS attacks
    private String escapeHtml(String input) {
        if (input == null) return "";
        return input.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}

