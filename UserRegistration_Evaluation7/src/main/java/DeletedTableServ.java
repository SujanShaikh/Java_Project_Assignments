import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/DeletedTableServ")
public class DeletedTableServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb", "root", "Sujan@123");
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM deletedInfo");
             ResultSet rs = ps.executeQuery();
             PrintWriter out = resp.getWriter()) {

            out.println("<table border='solid'>" +
                    "<th>ID</th>" +
                    "<th>NAME</th>" +
                    "<th>EMAIL</th>" +
                    "<th>CITY</th>" +
                    "<th>PHONE</th>" +
                    "<th>ACTION</th>");

            while (rs.next()){
                out.println("<tr><td>"+rs.getString(1)+"</td>");
                out.println("<td>"+rs.getString(2)+"</td>");
                out.println("<td>"+rs.getString(3)+"</td>");
                out.println("<td>"+rs.getString(4)+"</td>");
                out.println("<td>"+rs.getString(5)+"</td>");
                out.println("<td><a href='Retrieve'>Retrieve</td></tr>");
            }

            out.println("</table>");
            out.println("<h1><a href='WelcomeAdmin'><button>Back</button></a></h1><br>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
