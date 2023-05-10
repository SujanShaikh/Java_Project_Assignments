import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HiiUser")
public class HiiUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");
        String name=req.getParameter("uname");

        out.println("Hii "+name +"\n How are you ?");
        out.println("<h2> <a href='WelcomeServ'> Back </a></h2>");
        out.println("<h2> <a href='ByyUser'> Next</a></h2>");
    }
}
