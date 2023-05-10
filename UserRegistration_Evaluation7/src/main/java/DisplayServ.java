import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet("/DisplayServ")
public class DisplayServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");
        HttpSession session= req.getSession(false);
        if(session ==null) {
            RequestDispatcher rd= req.getRequestDispatcher("login.html");
            rd.forward(req,resp);
        }else{
            out.println("<h2> <a href=HomeServ> Profile </a> </h2>");
            out.println("<h2> <a href=login.html> Back </a> </h2>");
            out.println("<h2> <a href=LogoutServ> Logout </a> </h2>");
        }

        }



}
