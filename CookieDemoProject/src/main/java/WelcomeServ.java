import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/WelcomeServ")
public class WelcomeServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");

        //get cookies
        Cookie[] cookies= req.getCookies();
      boolean f=false;
      String name="";
      if(cookies==null){
          out.println("<h1> you are new user </h1>");
      }
      else {
          for(Cookie c:cookies){
              String tname= c.getName();
              if(tname.equals("user_email")){
                  f=true;
                  name=c.getValue();
              }
          }
      }
if(f)
        out.println("<h1>Welcome Back to my Website "+name+" </h1>");
        out.println("<h1><a href=LogoutServ>Logout</a> </h1>");



    }
}
