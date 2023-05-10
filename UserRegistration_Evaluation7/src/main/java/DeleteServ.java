import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/DeleteServ")
public class DeleteServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        PreparedStatement ps,ps1,ps2;
        Connection conn;
        ResultSet rs;

        // get user parameters
        int id= Integer.parseInt(req.getParameter("id"));
        int id1=0 ;
        String name=null,email=null,pass=null,city=null,phone=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb", "root", "Sujan@123");
            ps1 = conn.prepareStatement("select * from evaluation7 where id=?");
            ps1.setInt(1,id);
            rs = ps1.executeQuery();

            while (rs.next()){
                id1=rs.getInt(1);
                name = rs.getString(2);
                email = rs.getString(3);
                pass = rs.getString(4);
                city = rs.getString(5);
                phone = rs.getString(6);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb", "root", "Sujan@123");
            ps2 = conn.prepareStatement("insert into deletedInfo values(?,?,?,?,?,?)");
            ps2.setInt(1,id1);
            ps2.setString(2,name);
            ps2.setString(3,email);
            ps2.setString(4,pass);
            ps2.setString(5,city);
            ps2.setString(6,phone);

            ps2.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb", "root", "Sujan@123");

            ps = conn.prepareStatement("delete from evaluation7 where id=?");
            ps.setInt(1, id);

            ps.executeUpdate();

            out.println("<h2 style='color:red'>You have Deleted the data successfully.</h2>");
            RequestDispatcher rd = req.getRequestDispatcher("HomeServ");
            rd.forward(req, resp);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
