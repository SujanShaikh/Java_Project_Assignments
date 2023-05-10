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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");
        Connection conn= Connectivity.connection();
        HttpSession session=  req.getSession();


        Statement st;
        ResultSet rs;
        if(req.getAttribute("session").equals("admin@gmail.com") ){
            try {
                st= conn.createStatement();
                rs= st.executeQuery("Select * from  evaluation7");

                while(rs.next()){
                    int id = Integer.parseInt(rs.getString(1));
                    String name= rs.getString(2);
                    String email= rs.getString(4);
                    String city= rs.getString(5);
                    String phoneno= rs.getString(6);

                    out.println("<h1>User Details:</h1>");
                    out.println("<p>ID: " + id + "</p>");
                    out.println("<p>Name: " + name + "</p>");
                    out.println("<p>Email: " + email + "</p>");
                    out.println("<p>City: " + city + "</p>");
                    out.println("<p>Phone Number: " + phoneno + "</p>");

                    out.println("<h2> <a href=EditServ> Edit </a> </h2>");
                    out.println("<h2> <a href=DeleteServ> Delete </a> </h2>");
                    out.println("<h2> <a href=AddServ> Add </a> </h2>");


                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            try {
                st= conn.createStatement();
                rs= st.executeQuery("Select * from evaluation7 where email='"+req.getAttribute("sessionname")+"'");

                while(rs.next()){
                    int id = Integer.parseInt(rs.getString(1));
                    String name= rs.getString(2);
                    String email= rs.getString(4);
                    String city= rs.getString(5);
                    String phoneno= rs.getString(6);

                    out.println("<h1>User Details:</h1>");
                    out.println("<p>ID: " + id + "</p>");
                    out.println("<p>Name: " + name + "</p>");
                    out.println("<p>Email: " + email + "</p>");
                    out.println("<p>City: " + city + "</p>");
                    out.println("<p>Phone Number: " + phoneno + "</p>");

                    out.println("<h2> <a href=EditServ> Edit </a> </h2>");
                    out.println("<h2> <a href=DeleteServ> Delete </a> </h2>");
                    out.println("<h2> <a href=AddServ> Add </a> </h2>");


                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
