import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/DeleteServ")
public class DeleteServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");
        Connection conn= Connectivity.connection();
        HttpServlet session= (HttpServlet) req.getSession();
        String username = (String) req.getAttribute("sessionname");
        PreparedStatement ps;

        try {
            ps=conn.prepareStatement("Delete from evaluation7 where email="+username);

            RequestDispatcher rd= req.getRequestDispatcher("DashboardServ");
            out.println("<h2>  Entry deleted</h2>");
            rd.include(req,resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        out.println("<a href=DashboardServ.html> Back </a>");

    }
}
