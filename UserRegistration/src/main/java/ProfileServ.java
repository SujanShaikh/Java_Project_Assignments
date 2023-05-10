import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/ProfileServ")
public class ProfileServ extends HttpServlet {

    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = Connectivity.connection();

        HttpSession session = request.getSession();

        if (session.getAttribute("name") == null) {
            response.sendRedirect("index.html");
        } else {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            String name = (String) session.getAttribute("name");
            try {
                ps = conn.prepareStatement("select * from registration where firstname= ?");
                ps.setString(1, name);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String firstname = rs.getString(2);
                    String lastname = rs.getString(3);
                    String dob = String.valueOf(rs.getDate(4));
                    String email = rs.getString(5);
                    String imagepath = rs.getString(7);
                    String address = rs.getString(8);
                    String phoneno = rs.getString(9);

                    out.println("<h2>Welcome " + firstname + "</h2>");
                    out.println("Image :" + imagepath);
                    out.println("ID : " + id);
                    out.println("First Name :" + firstname);
                    out.println("Last Name :" + lastname);
                    out.println("Date of Birth  :" + dob);
                    out.println("Email :" + email);
                    out.println("Address :" + address);
                    out.println("Phone no :" + phoneno);

                    out.println("<a href='WelcomeOption'> Back </a>");

                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
