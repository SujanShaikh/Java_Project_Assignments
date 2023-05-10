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

@WebServlet("/UserHomeServ")
public class UserHomeServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = Connectivity.connection();
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        HttpSession session = req.getSession(false);
        String email = (String) session.getAttribute("useremail");


        if (session != null && email != null) {

            PreparedStatement ps = null;
            ResultSet rs = null;
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
                    out.println("<td>" + rs.getString(8) + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            out.println("<h3>Please login first!</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req, resp);
        }
    }


}
