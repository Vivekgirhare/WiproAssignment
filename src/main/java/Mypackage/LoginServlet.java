package Mypackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Validates credentials and creates session storing account info.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // For demonstration: hardcoded valid accounts (in real apps, query DB)
    private static final String[][] ACCOUNTS = {
        {"123456", "pass123", "Mr hola", "1500.75"},
        {"234567", "mypassword", "Titu mama", "2420.00"},
        {"345678", "secret", "Sameer", "980.23"}
    };

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        String password = request.getParameter("password");

        if (accountNumber == null || password == null || accountNumber.isEmpty() || password.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Account number and password required.");
            return;
        }

        // Validate credentials
        boolean validUser = false;
        String accountHolderName = null;
        double balance = 0.0;

        for (String[] account : ACCOUNTS) {
            if (account[0].equals(accountNumber) && account[1].equals(password)) {
                validUser = true;
                accountHolderName = account[2];
                balance = Double.parseDouble(account[3]);
                break;
            }
        }

        if (validUser) {
            // Create session and store attributes
            HttpSession session = request.getSession(true);
            session.setAttribute("accountHolderName", accountHolderName);
            session.setAttribute("accountBalance", balance);
            session.setAttribute("accountNumber", accountNumber);

            // Redirect to balance page
            response.sendRedirect("balance");
        } else {
            // Invalid login - send error message with link back to login
            response.setContentType("text/html;charset=UTF-8");
            try (var out = response.getWriter()) {
                out.println("<!DOCTYPE html><html><head><title>Login Failed</title></head><body>");
                out.println("<h1>Login Failed</h1>");
                out.println("<p>Invalid account number or password.</p>");
                out.println("<p><a href='login.html'>Try again</a></p>");
                out.println("</body></html>");
            }
        }
    }
}

