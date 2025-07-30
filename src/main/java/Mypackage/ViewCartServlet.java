package Mypackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/viewCart")
public class ViewCartServlet extends HttpServlet {

    private static final String CART_COOKIE_NAME = "cartItems";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cartValue = null;
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (CART_COOKIE_NAME.equals(c.getName())) {
                    cartValue = c.getValue();
                    break;
                }
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        try (var out = response.getWriter()) {
            out.println("<!DOCTYPE html><html><head><title>Your Cart</title></head><body>");
            out.println("<h1>Your Shopping Cart</h1>");

            if (cartValue == null || cartValue.trim().isEmpty()) {
                out.println("<p>Your cart is empty.</p>");
            } else {
                List<String> items = Arrays.asList(cartValue.split(","));
                out.println("<ul>");
                for (String item : items) {
                    out.println("<li>" + escapeHtml(item) + "</li>");
                }
                out.println("</ul>");
            }

            out.println("<p><a href='itemsSelection.html'>Continue Shopping</a></p>");
            out.println("</body></html>");
        }
    }

    private String escapeHtml(String input) {
        if (input == null) return "";
        return input.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}

