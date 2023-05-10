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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");
        Connection conn= Connectivity.connection();
        PreparedStatement ps;
        ResultSet rs;
        HttpSession session= req.getSession();
        String uemail= req.getParameter("email");
        String upassword= req.getParameter("password");

        try {
            ps= conn.prepareStatement("select * from evaluation7 where email=? and password=?");
            ps.setString(1, uemail);
            ps.setString(2,upassword);
             rs=ps.executeQuery();

             if(rs.next()){
                 out.println("<h2 style='color:green'> Login Successful</h2>");
                 RequestDispatcher rd= req.getRequestDispatcher("DashboardServ");
                 rd.forward(req,resp);
             }
             else{
                 out.println("<h2 style='color:red'> Invalid Details </h2>");
                 RequestDispatcher rd= req.getRequestDispatcher("login.html");
                 rd.forward(req,resp);
             }
                   

                

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
