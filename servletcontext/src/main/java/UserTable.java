import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/UserTable")
public class UserTable extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Hello from Servlet");
response.setContentType("text/html");
        String name= request.getParameter("uname");

        ServletContext servletContext=getServletContext();

        try {
            Class.forName(servletContext.getInitParameter("driver"));
            Connection conn= DriverManager.getConnection(servletContext.getInitParameter("url"),servletContext.getInitParameter("username"),servletContext.getInitParameter("password"));
            Statement stmt= conn.createStatement();
            ResultSet rs= stmt.executeQuery("select * from Students");

            out.println("<table border=dotted>");
            out.println("<tr><th>Name</th><th>ID</th><th>City</th></tr>");

            while(rs.next()){
                out.println("<tr><td>"+ rs.getString(1)+"</td>"+
                        "<td>"+ rs.getInt(2)+"</td>"+
                        "<td>"+ rs.getString(3)+ "</td></tr>");
            }

            out.println("</table>");

            out.println(" <h3> <a href='logout'> Next </a></h3>");
            out.println(" <h3> <a href='FaceBook'> Coditas </a></h3>");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

}


