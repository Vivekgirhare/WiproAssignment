package Mypackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Receives the selected product and shows a form for quantity input.
 * Carries productName and price in hidden fields.
 */
@WebServlet("/quantity")
public class QuantityServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve the selected product name
        String productName = request.getParameter("productName");
        if (productName == null || productName.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Product not selected.");
            return;
        }
        
        // Retrieve price parameter from hidden input by matching "price_<productName>"
        String priceParamName = "price_" + productName;
        String priceStr = request.getParameter(priceParamName);
        if (priceStr == null || priceStr.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Price not found for the selected product.");
            return;
        }
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Enter Quantity</title></head><body>");
            out.println("<h1>Enter Quantity for " + escapeHtml(productName) + "</h1>");
            
            // Form to enter quantity, sending all data to /receipt
            out.println("<form action='receipt' method='post'>");
            // Hidden fields carry productName and price
            out.println("<input type='hidden' name='productName' value='" + escapeHtml(productName) + "'/>");
            out.println("<input type='hidden' name='price' value='" + escapeHtml(priceStr) + "'/>");
            // Quantity input
            out.println("<label for='quantity'>Quantity:</label><br/>");
            out.println("<input type='number' name='quantity' id='quantity' min='1' required/><br/><br/>");
            out.println("<button type='submit'>Calculate Total</button>");
            out.println("</form>");
            
            out.println("<p><a href='productSelection.html'>Select another product</a></p>");
            out.println("</body></html>");
        }
    }

    // Basic HTML escape to avoid XSS (can be improved with libraries)
    private String escapeHtml(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&#39;");
    }
}

