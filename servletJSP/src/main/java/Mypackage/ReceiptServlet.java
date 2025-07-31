package Mypackage;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Calculates total price and displays receipt.
 */
@WebServlet("/receipt")
public class ReceiptServlet extends HttpServlet {
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
        
        String productName = request.getParameter("productName");
        String priceStr = request.getParameter("price");
        String quantityStr = request.getParameter("quantity");

        if (productName == null || priceStr == null || quantityStr == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters.");
            return;
        }
        
        double price;
        int quantity;

        try {
            price = Double.parseDouble(priceStr);
            quantity = Integer.parseInt(quantityStr);
            if (quantity < 1) {
                throw new NumberFormatException("Quantity must be positive.");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid price or quantity.");
            return;
        }
        
        double total = price * quantity;
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Receipt</title></head><body>");
            out.println("<h1>Receipt</h1>");
            out.println("<table border='1' cellpadding='5'>");
            out.println("<tr><th>Product</th><td>" + escapeHtml(productName) + "</td></tr>");
            out.println("<tr><th>Price (per item)</th><td>$" + String.format("%.2f", price) + "</td></tr>");
            out.println("<tr><th>Quantity</th><td>" + quantity + "</td></tr>");
            out.println("<tr><th>Total</th><td><strong>$" + String.format("%.2f", total) + "</strong></td></tr>");
            out.println("</table>");
            
            out.println("<p><a href='productSelection.html'>Return to Product Selection</a></p>");
            out.println("</body></html>");
        }
    }
    
    private String escapeHtml(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&#39;");
    }
}
