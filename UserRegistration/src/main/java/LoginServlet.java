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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            PrintWriter out=resp.getWriter();
            resp.setContentType("text.html");
            Connection conn=Connectivity.connection();
        String uemail=req.getParameter("email1");
        String upassword=req.getParameter("password");
        HttpSession session = req.getSession();
        int count=0;


        try {
            Statement stmt=conn.createStatement();
            ResultSet rs= stmt.executeQuery("select email,password,firstname from registration where email='"+uemail+"'and password ='"+upassword+"'");
            String name="";
            if(rs.next()){
                String useremail=rs.getString(1);
                String userpwd=rs.getString(2);
                out.println("helloooo");


                    name=rs.getString(3);
                    count++;

            }

            if(count==1){
                session.setAttribute("name",name);
                resp.sendRedirect("WelcomeOption");
            }
            else{
                out.println("<h4 style='color: red '>Try Again Invalid Deatils "+"</h4>");
                RequestDispatcher requestDispatcher= req.getRequestDispatcher("index.html");
                requestDispatcher.include(req,resp);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    }