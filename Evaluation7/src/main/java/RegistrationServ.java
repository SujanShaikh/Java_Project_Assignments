import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/RegistrationServ")
public class RegistrationServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");
        Connection conn= Connectivity.connection();
        PreparedStatement ps;
        ResultSet rs;
         String name= req.getParameter("name");
        String password= req.getParameter("password");
        String email= req.getParameter("name");
        String city= req.getParameter("city");
        String phoneno= req.getParameter("phoneno");

        try {
            ps= conn.prepareStatement(" insert into evaluation7 (name,password,email,city,phoneno) values (?,?,?,?,?)");

            ps.setString(1,name);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.setString(4,city);
            ps.setString(5,phoneno);

            ps.executeUpdate();

            RequestDispatcher rd= req.getRequestDispatcher("login.html");
           resp.getWriter().print("<h3> Successful Registration "+name+" <h3>");
            rd.include(req,resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
