package Mypackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet that connects to MySQL DB and displays vendor records.
 */
@WebServlet("/vendors")
public class VendorServlet extends HttpServlet {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String JDBC_USER = "root"; // Change as per your DB user
    private static final String JDBC_PASSWORD = "your_password"; // Change to your DB password

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head><title>Vendor List</title>");
            out.println("<style>table {border-collapse: collapse; width: 80%; margin: auto;} ");
            out.println("th, td {border: 1px solid #ddd; padding: 8px; text-align: left;} ");
            out.println("th {background-color: #4CAF50; color: white;}</style>");
            out.println("</head><body>");
            out.println("<h1 style='text-align:center;'>Vendor Records</h1>");

            // Load MySQL JDBC Driver (optional, the newer JDBC can auto load)
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                out.println("<p>Error loading MySQL JDBC Driver: " + e.getMessage() + "</p>");
                return;
            }

            // Connect to DB and query
            try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
                String query = "SELECT * FROM vendors";

                try (PreparedStatement stmt = conn.prepareStatement(query);
                     ResultSet rs = stmt.executeQuery()) {

                    out.println("<table>");
                    out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Phone</th></tr>");

                    boolean hasResults = false;
                    while (rs.next()) {
                        hasResults = true;
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String email = rs.getString("email");
                        String phone = rs.getString("phone");

                        out.println("<tr>");
                        out.println("<td>" + id + "</td>");
                        out.println("<td>" + escapeHtml(name) + "</td>");
                        out.println("<td>" + escapeHtml(email) + "</td>");
                        out.println("<td>" + escapeHtml(phone) + "</td>");
                        out.println("</tr>");
                    }

                    if (!hasResults) {
                        out.println("<tr><td colspan='4'>No vendor records found.</td></tr>");
                    }
                    out.println("</table>");
                }
            } catch (SQLException e) {
                out.println("<p>Error connecting to DB or executing query: " + e.getMessage() + "</p>");
            }

            out.println("</body></html>");
        }
    }

    // Simple method to prevent XSS in output
    private String escapeHtml(String input) {
        if (input == null) return "";
        return input.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}
