import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/WelcomeServ")
public class WelcomeServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter    out=resp.getWriter();
        resp.setContentType("text/html");

        HttpSession session= req.getSession();
        String sname= (String) session.getAttribute("sessionname");

        if(sname==null){
            resp.sendRedirect("login.html");
        }
        else{
        out.println("<h1>Welcome...."+sname+"</h1> ");
        out.println("<a href=LogoutServ> Logout </a>");

    }}
}
