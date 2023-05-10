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

@WebServlet("/AdminHomeServ")
public class AdminHomeServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = Connectivity.connection();
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        HttpSession session = req.getSession(false);
        ResultSet rs;
        PreparedStatement ps;
        if (session == null) {
            resp.sendRedirect("login.html"); // or display an error message
            return;
        }
        String email = (String) session.getAttribute("sname");
        String password = (String) session.getAttribute("spwd");

        if(email.equals("admin@gmail.com") && password.equals("admin"))
        {
        try (
               PreparedStatement ps1=conn.prepareStatement("select * from Userdb");
             ResultSet rs1 = ps1.executeQuery()) {
            // Printing the table headers
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>DOB</th><th>Address</th><th>PhoneNo</th><th>imagename</th></tr>");

            while (rs1.next()) {

                String email1 = rs1.getString(3);
                out.println("<tr>");

                out.println("<td>" + rs1.getInt(1) + "</td>");
                out.println("<td>" + rs1.getString(2) + "</td>");
                out.println("<td>" + rs1.getString(3) + "</td>");
                out.println("<td>" + rs1.getString(4) + "</td>");
                out.println("<td>" + rs1.getString(5) + "</td>");
                out.println("<td>" + rs1.getString(6) + "</td>");
                out.println("<td>" + rs1.getString(7) + "</td>");
                out.println("<td><img src='images/"+rs1.getString(8)+"' width='200' height='200'></td>");

                out.println("<td> <a href='EditServ?email1="+email1+"'> Edit</td>");
                out.println("<td> <a href='DeleteServ?email1="+email1+"'> Delete</td>");
                out.println("</tr>");
                out.println("<h3><a href='DeletedUsers'>DeletedUsers</a></h3>");
            }
            out.println("</table>");
        } catch (SQLException e) {
            throw new RuntimeException("Error executing query", e);
        }
        }
        else {
            String selectUser = "select * from userdb where uemail=?";

            try {
                ps = conn.prepareStatement(selectUser);
                ps.setString(1, email);

                rs = ps.executeQuery();

                out.println("<table border='1'>");
                out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>DOB</th><th>Address</th><th>PhoneNo</th><th>User Type</th></tr>");

                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getInt(1) + "</td>");
                    out.println("<td>" + rs.getString(2) + "</td>");
                    out.println("<td>" + rs.getString(3) + "</td>");
                    out.println("<td>" + rs.getString(5) + "</td>");
                    out.println("<td>" + rs.getString(6) + "</td>");
                    out.println("<td>" + rs.getString(7) + "</td>");
                    out.println("<td><img src='images/"+rs.getString(8)+"' width='200' height='200'></td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        out.println(" <h3><a href='login.html'>Back</a></h3>");
        out.println(" <h3><a href=LogoutServ>Logout</a></h3>");
        }
    }
