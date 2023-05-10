import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/RegistrationServ")
public class RegistrationServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        PreparedStatement ps;
        Connection conn;
        ResultSet rs;

        // get user parameters
        String name= req.getParameter("name");
        String password= req.getParameter("password");
        String email= req.getParameter("email");
        String city= req.getParameter("city");
        String phoneno= req.getParameter("phoneno");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb", "root", "Sujan@123");

            ps= conn.prepareStatement(" insert into evaluation7 (name,password,email,city,phoneno) values (?,?,?,?,?)");

            ps.setString(1,name);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.setString(4,city);
            ps.setString(5,phoneno);

            ps.executeUpdate();


            out.println("<h2> "+name +" you have registered successfully </h2>");
            System.out.println("Message: " + "<h2 style='color:green'>" + name + " you have registered successfully </h2>");
            RequestDispatcher rd= req.getRequestDispatcher("login.html");
            rd.forward(req,resp);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
