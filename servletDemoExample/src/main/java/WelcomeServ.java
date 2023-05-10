import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WelcomeServlet", urlPatterns = {"/WelcomeServ"}, description = "Servlet for welcoming users")
public class WelcomeServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out= resp.getWriter();
resp.setContentType("text/html");
String name=req.getParameter("uname");
        String password=req.getParameter("password");

        out.println("Welcome " + name);
        out.println("<h3> <a href='HiiUser'>Next</a></h3>");

    }
}
