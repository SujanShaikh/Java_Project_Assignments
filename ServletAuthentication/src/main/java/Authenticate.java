import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//@WebServlet(urlPatterns = "/Authenticate", initParams ={@WebInitParam(name ="Driver",value = "com.mysql.jdbc.Driver"),@WebInitParam(name="name",value = "\"jdbc:mysql://localhost:3306/servletdb\"")})
@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");

        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        int count=0;
        String name=req.getParameter("uname");
        String password=req.getParameter("password");

       // ServletConfig config = getServletConfig();
//        String driver =config.getInitParameter("Driver");
//        out.println("Driver: "+driver);
//        String url = config.getInitParameter("name");
//        out.println("url: "+url);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb","root","Sujan@123");

            stmt= conn.createStatement();
            rs= stmt.executeQuery("select * from user");

            while(rs.next()){
                String username=rs.getString(2);
                String userPwd=rs.getString(3);

                if(name.equals(username)&& password.equals(userPwd)){
                    out.print("<h1> Welcome</h1> " + username+" :) ");
                    count++;
                    resp.sendRedirect("UserDetails.html");
                    break;
                }
            }
            if (count==0){
                out.print("<h1> Try Again  :( </h1>");
            }
            out.println("<a href='index.html'>Back</a>");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
