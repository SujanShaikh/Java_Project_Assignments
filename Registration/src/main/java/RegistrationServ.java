import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/RegistrationServ")
public class RegistrationServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");
       Connection conn=Connectivity.connection();
        PreparedStatement ps;

       //user data

        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String dob = req.getParameter("dob");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String imagepath = req.getParameter("image");
        String address = req.getParameter("address");
        String phoneno = req.getParameter("phoneno");


        // insert data
        try {
            ps= conn.prepareStatement("INSERT INTO registration(firstname, lastname, dob, email, password, imagepath, address, phoneno) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setDate(3, Date.valueOf(dob));
            ps.setString(4, email);
            ps.setString(5, password);
            ps.setString(6, imagepath);
            ps.setString(7, address);
            ps.setString(8, phoneno);

            ps.executeUpdate();

            RequestDispatcher rs= req.getRequestDispatcher("login.html");
            resp.getWriter().println("<h4 style='color: green'>Successful Registration " + firstname + "</h4>");
            rs.include(req,resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
