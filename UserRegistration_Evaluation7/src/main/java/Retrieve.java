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

@WebServlet("/Retrieve")
public class Retrieve extends HttpServlet {
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

            PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM deletedInfo ");
             rs = ps1.executeQuery();

            // Insert the retrieved data into the original table
            PreparedStatement ps2 = conn.prepareStatement("INSERT INTO evaluation7 (id, name, email, city, phoneno) VALUES (?, ?, ?, ?, ?)");
            while (rs.next()) {
                ps2.setInt(1, rs.getInt(1));
                ps2.setString(2, rs.getString(2));
                ps2.setString(3, rs.getString(3));
                ps2.setString(4, rs.getString(4));
                ps2.setString(5, rs.getString(5));
                ps2.executeUpdate();
            }

            // Delete the retrieved data from the deleted table
            PreparedStatement ps3 = conn.prepareStatement("DELETE FROM deletedInfo ");
            ps3.executeUpdate();

            out.println("<h3>Deleted data has been successfully retrieved and added back to the original table!</h3>");
            out.println("<a href='WelcomeAdmin'><button>Back</button></a>");


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
/*
 * */