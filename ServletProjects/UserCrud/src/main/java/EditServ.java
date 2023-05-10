import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/EditServ")
public class EditServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Connection conn=Connectivity.connection();
        resp.setContentType("text/html");
        PreparedStatement ps;
        ResultSet rs;


        String email=req.getParameter("email1");
        String id="";
        String name=" ",uemail=" ",pass=" ",dob=" ",Address=" ",phoneno=" ",imagename=" ";
        try {
            ps = conn.prepareStatement("select * from userdb where uemail=?");
            ps.setString(1,email);
            rs = ps.executeQuery();

            while(rs.next()){
                id = rs.getString(1);
                name = rs.getString(2);
                uemail = rs.getString(3);
                pass = rs.getString(4);
                dob=rs.getString(5);
                Address = rs.getString(6);
                phoneno = rs.getString(7);
                imagename=rs.getString(8);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        out.println("<h2>Student ID:"+id+"</h2>" +
            "<form action='UpdateServ'>" +
            "NAME: <input type='text' name='nameup' value='"+name+"'>" +
            "EMAIL:<input type='text' name='emailup' value='"+uemail+"'>" +
                "DOB:<input type='date' name='dateup' value='"+dob+"'>" +
                "ADDRESS:<input type='text' name='addressup' value='"+Address+"'>" +
            "PHONE:<input type='text' name='phoneup' value='"+phoneno+"'>" +
            "<input type='submit' value='UPDATE'>" +
            "</form>");

        out.println("<a href=AdminHomeServ>Back </a>");
}
}
