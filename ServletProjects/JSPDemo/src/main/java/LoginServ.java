import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

        String name=req.getParameter("uname");
        if(name.equals("sujan")){
            out.print("Hello Sujan");
        }
        else{
            out.print("Where's Sujan ? ");

        }
        out.println("<a href='index.jsp'>Back</a>");
    }
}
