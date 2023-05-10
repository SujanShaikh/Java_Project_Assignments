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
 @WebServlet("/Check_User")
public class Check_User extends HttpServlet {


     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out =resp.getWriter();
        resp.setContentType("text/html");
        Connection connection=ConnectDB.connection();
        String uname=req.getParameter("uname");
        String pass=req.getParameter("upassword");


        try{
            String sql="select * from users where username=? and password=?";
            PreparedStatement ps=connection.prepareStatement(sql);

            ps.setString(1,uname);
            ps.setString(2,pass);

            ResultSet rs=ps.executeQuery();

            String U,P;
            if(rs.next()){
                U=rs.getString(1);
                P=rs.getString(2);

                if(uname.equals(U) && pass.equals(P)){
                    HttpSession session= req.getSession();
                    session.setAttribute("username",U);
                    RequestDispatcher rd= req.getRequestDispatcher("Profile");
                    rd.forward(req,resp);
                }
            }
            else{
                out.println("<center> <h3> style='color :red;'> Sorry Username Password Doesn't Match </h3></center>");
                RequestDispatcher rd= req.getRequestDispatcher("login.html");
                rd.forward(req,resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
