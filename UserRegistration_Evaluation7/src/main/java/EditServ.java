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

@WebServlet("/EditServ")
public class EditServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        HttpSession session= req.getSession(false);
        PreparedStatement ps;
        Connection conn;
        ResultSet rs;

        // get user parameters
//        int id= Integer.parseInt(req.getParameter("id"));
        String uemail = (String) session.getAttribute("sname");
        String upassword = (String) session.getAttribute("spwd");

        String city= req.getParameter("city");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb", "root", "Sujan@123");

            ps = conn.prepareStatement("UPDATE evaluation7 SET city=? where email=? and password=?");
            ps.setString(1, city);
//           ps.setInt(2, id);
            ps.setString(2,uemail);
            ps.setString(3,upassword);

            ps.executeUpdate();

            out.println("<h2 style='color:green'>You have updated the data successfully.</h2>");
            RequestDispatcher rd = req.getRequestDispatcher("HomeServ");
            rd.forward(req, resp);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
/*
* */