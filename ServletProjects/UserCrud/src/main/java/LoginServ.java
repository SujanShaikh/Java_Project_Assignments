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
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        Connection conn = Connectivity.connection();
        HttpSession session = req.getSession();
        PreparedStatement ps1, ps;
        ResultSet rs = null;

         {
            String email = req.getParameter("uemail");
            String password = req.getParameter("password");


            try {
                String userCheckdata = "select uemail,upassword from userCheck where uemail=? and upassword=?";
                ps1 = conn.prepareStatement(userCheckdata);
                ps1.setString(1, email);
                ps1.setString(2, password);
                rs = ps1.executeQuery();
                if(rs.next()){
                    out.println("<h2 style='color:green'> Login Successful</h2>");
                    session.setAttribute("sname",email);
                    session.setAttribute("spwd",password);

                    RequestDispatcher rd= req.getRequestDispatcher("AdminHomeServ");
                    rd.forward(req,resp);
                }
                else{
                    out.println("<h2 style='color:red'> Invalid Details </h2>");
                    RequestDispatcher rd= req.getRequestDispatcher("login.html");
                    rd.include(req,resp);
                }



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }}}


