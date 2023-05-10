package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AdminOptionServ")
public class AdminOptionServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userType = request.getParameter("userType"); // Get the selected user type from the request parameter

        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        if ("crm".equalsIgnoreCase(userType)) {
            response.sendRedirect("DisplayAllCrmServ");
        } else if ("user".equalsIgnoreCase(userType)) {
            // Redirect to DisplayAllUserServ for Customer type
            response.sendRedirect("DisplayAllUserServ");
        } else {
            out.println("<h6>  choose  correct option <h6>");
            RequestDispatcher rd= request.getRequestDispatcher("userDetailsServ");
            rd.include(request,response);
        }
    }
}
