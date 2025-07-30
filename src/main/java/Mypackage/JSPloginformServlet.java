package Mypackage;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class JSPloginformServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String profession = request.getParameter("profession");
        String married = request.getParameter("married");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head><title>Registration Result</title></head><body>");
            out.println("<h2>Registration Details</h2>");
            out.println("<p><b>Full Name:</b> " + fullName + "</p>");
            out.println("<p><b>Email:</b> " + email + "</p>");
            out.println("<p><b>Birthday:</b> " + birthday + "</p>");
            out.println("<p><b>Gender:</b> " + gender + "</p>");
            out.println("<p><b>Profession:</b> " + profession + "</p>");
            out.println("<p><b>Married:</b> " + (married != null ? "Yes" : "No") + "</p>");
            out.println("<p><a href='login.jsp'>← Back to registration</a></p>");
            out.println("</body></html>");
        }
    }
}

