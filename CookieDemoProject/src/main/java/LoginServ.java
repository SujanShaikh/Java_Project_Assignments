import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");

        String uname=req.getParameter("email");
        out.println("<h1>Welcome "+uname+"  </h1>");
        out.println("<h3><a href='urlServ?uname='"+uname+">urlServ </a> </h3>");

        out.println("<h3><a href='WelcomeServ'>Cookies </a> </h3>");

        //create cookie
        Cookie c=new Cookie("user_email",uname);
        resp.addCookie(c);

    }
}
