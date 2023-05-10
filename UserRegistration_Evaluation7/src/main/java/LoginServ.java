import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");
        HttpSession session= req.getSession();

        PreparedStatement ps;
        Connection conn;
        ResultSet rs;
        String uemail=req.getParameter("email");
        String upassword=req.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb","root","Sujan@123");


            ps= conn.prepareStatement("select email,password from evaluation7 where email=? and password=?");

            ps.setString(1,uemail);
            ps.setString(2,upassword);
            rs=ps.executeQuery();

            if(rs.next()){
                out.println("<h2 style='color:green'> Login Successful</h2>");
                session.setAttribute("sname",uemail);
                session.setAttribute("spwd",upassword);

                RequestDispatcher rd= req.getRequestDispatcher("Home.html");
                rd.forward(req,resp);
            }
            else{
                out.println("<h2 style='color:red'> Invalid Details </h2>");
                RequestDispatcher rd= req.getRequestDispatcher("login.html");
                rd.include(req,resp);
            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
