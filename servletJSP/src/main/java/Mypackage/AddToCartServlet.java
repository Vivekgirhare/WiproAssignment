package Mypackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {

    private static final String CART_COOKIE_NAME = "cartItems";
    private static final int COOKIE_MAX_AGE = 60 * 60 * 24; // 1 day in seconds

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the selected items from the form (can be multiple)
        String[] selectedItems = request.getParameterValues("item");

        if (selectedItems == null || selectedItems.length == 0) {
            // No items selected, redirect back to form with message (optional)
            response.sendRedirect("itemsSelection.html");
            return;
        }

        // Get existing cart items from cookie (if any)
        Cookie[] cookies = request.getCookies();
        Set<String> cartItems = new HashSet<>();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (CART_COOKIE_NAME.equals(c.getName())) {
                    String value = c.getValue(); // items separated by comma
                    if (value != null && !value.isEmpty()) {
                        cartItems.addAll(Arrays.asList(value.split(",")));
                    }
                    break;
                }
            }
        }

        // Add newly selected items to the cart set
        for (String item : selectedItems) {
            cartItems.add(item);
        }

        // Create a cookie with updated items (comma separated, URL encoding safe)
        StringBuilder newValue = new StringBuilder();
        for (String item : cartItems) {
            if (newValue.length() > 0) {
                newValue.append(",");
            }
            newValue.append(item);
        }

        Cookie cartCookie = new Cookie(CART_COOKIE_NAME, newValue.toString());
        cartCookie.setMaxAge(COOKIE_MAX_AGE);
        cartCookie.setPath("/");  // cookie accessible site-wide
        response.addCookie(cartCookie);

        // Redirect back to items selection page or show confirmation
        response.setContentType("text/html;charset=UTF-8");
        try (var out = response.getWriter()) {
            out.println("<!DOCTYPE html><html><head><title>Added to Cart</title></head><body>");
            out.println("<h1>Items added to cart!</h1>");
            out.println("<p><a href='itemsSelection.html'>Add more items</a></p>");
            out.println("<p><a href='viewCart'>View Cart</a></p>");
            out.println("</body></html>");
        }
    }
}

