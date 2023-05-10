import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet("/DashboardServ")
public class DashboardServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");

        out.println("<h2> <a href=home.html> Home </a> </h2>");
        out.println("<h2> <a href=ProfileServ> Profile </a> </h2>");
        out.println("<h2> <a href=login.html> Back </a> </h2>");
        out.println("<h2> <a href=LogoutServ> Logout </a> </h2>");

    }
}
