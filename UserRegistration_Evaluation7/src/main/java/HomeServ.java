import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/HomeServ")
public class HomeServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        HttpSession session = req.getSession(false);

        PreparedStatement ps;
        Connection conn = null;
        ResultSet rs;

        if (session.getAttribute("sname") == null) {
            resp.sendRedirect("login.html");

        } else {
            String uemail = (String) session.getAttribute("sname");
            String upassword = (String) session.getAttribute("spwd");
            String adminemail = "admin@gmail.com";
            String adminpwd = "admin";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb", "root", "Sujan@123");

//            if (uemail == null || upassword == null) {
//                throw new NullPointerException("User email and/or password is null");
//            }
                if (uemail.equals(adminemail) && upassword.equals(adminpwd)) {
                    ps = conn.prepareStatement("SELECT * FROM evaluation7");
                    rs = ps.executeQuery();
                    out.println("<table border='solid'>");
                    out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>City</th><th>Phone</th></tr>");
                    while (rs.next()) {
                        out.println("<tr>");
                        out.println("<td>" + rs.getInt(1) + "</td>");
                        out.println("<td>" + rs.getString(2) + "</td>");
                        out.println("<td>" + rs.getString(4) + "</td>");
                        out.println("<td>" + rs.getString(5) + "</td>");
                        out.println("<td>" + rs.getString(6) + "</td>");
                        out.println("<td> <a href='EditAdmin.html'> Edit </a></td> \t");
                        out.println("<td> <a href='delete.html'> Delete </a></td>\t");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    out.println("<a href='Registration.html'> Add User </a>" + "\t");
                    out.println("<a href='DeletedTableServ'> Deleted users </a>" + "\t");

//                    out.println("<td> <a href='EditAdmin.html'> Edit </a></td> \t");
//                    out.println("<td> <a href='delete.html'> Delete </a></td>\t");
                } else {
                    ps = conn.prepareStatement("SELECT * FROM evaluation7 WHERE email=? AND password=?");
                    ps.setString(1, uemail);
                    ps.setString(2, upassword);
                    rs = ps.executeQuery();

                    out.println("<table border='solid'>");
                    out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>City</th><th>Phone</th><th>Action</th><th>Action</th></tr>");
                    while (rs.next()) {
                        out.println("<tr>");
                        out.println("<td>" + rs.getInt(1) + "</td>");
                        out.println("<td>" + rs.getString(2) + "</td>");
                        out.println("<td>" + rs.getString(4) + "</td>");
                        out.println("<td>" + rs.getString(5) + "</td>");
                        out.println("<td>" + rs.getString(6) + "</td>");
                        out.println("<td> <a href='edit.html'> Edit </a></td>");
                        out.println("<td> <a href='delete.html'> Delete </a></td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (NullPointerException e) {
                out.println("User email and/or passsword");
            }

            out.println("<a href=Home.html> Back </a>");
        }
    }
}
