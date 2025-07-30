package Mypackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/clearCart")
public class ClearCartServlet extends HttpServlet {

    private static final String CART_COOKIE_NAME = "cartItems";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie cartCookie = new Cookie(CART_COOKIE_NAME, "");
        cartCookie.setMaxAge(0); // delete cookie
        cartCookie.setPath("/");
        response.addCookie(cartCookie);

        response.sendRedirect("itemsSelection.html");
    }
}
