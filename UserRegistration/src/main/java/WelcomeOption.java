import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/WelcomeOption")
public class WelcomeOption extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out= resp.getWriter();
        resp.setContentType("text/html");

        // Check if the user has an active session
        HttpSession session = req.getSession( );
        if (session.getAttribute("name")==null) {
            // User is logged in, so display links to fetch data or logout
            out.println("<h3><a href='ProfileServ'>  Fetch Data  </a></h3>");
            out.println();
            out.println("<h3><a href='LogoutServlet'> Logout </a> </h3>");
        } else {
            // User is not logged in, so display the login page
            resp.sendRedirect("index.html");

        }
    }
}
