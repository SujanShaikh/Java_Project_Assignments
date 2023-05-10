package servlets;


import InputData.CustomerInput;
import helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/AdminServ")
public class AdminServ extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        // Get the session
        HttpSession session = request.getSession(false);
        String email = (String) session.getAttribute("email"); // Retrieve email from HttpSession



        if(session==null){
            RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
            rd.forward(request,response);
        }


        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Query<CustomerInput> query = hibernateSession.createQuery("from CustomerInput ");
        List<CustomerInput> customerList = query.list();

        hibernateSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>User Details</title>");

        // Add Bootstrap CSS link
        out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");

        out.println("</head>");
        out.println("<body>");

        if (customerList != null && !customerList.isEmpty()) {
            CustomerInput customer = customerList.get(0); // Assuming only one customer with given email exists

            out.println("<div class='container mt-5'>");
            out.println("<h1>User Details</h1>");
            out.println("<table class='table table-bordered table-striped'>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Full Name</th>");
            out.println("<th>Address</th>");
            out.println("<th>Email</th>");
            out.println("<th>Gender</th>");
            out.println("<th>Date of Birth </th>");

            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>" + customer.getCustomerId() + "</td>");
            out.println("<td>" + customer.getFullName() + "</td>");
            out.println("<td>" + customer.getAddress() + "</td>");
            out.println("<td>" + customer.getEmail() + "</td>");
            out.println("<td>" + customer.getGender() + "</td>");
            out.println("<td>" + customer.getDob() + "</td>");
            out.println("</tr>");
            out.println("</table>");

            out.println("<a href='LogoutServ' class='btn btn-danger'>Logout</a>"); // Logout button
            out.println("<a href='RaiseComplaint.jsp' class='btn btn-primary ml-2'>Raise Complaint</a>"); // Raise Complaint button
            out.println("</div>");


        } else {
            // Handle case when no customer is found for given email
            out.println("<div class='container mt-5'>");
            out.println("<h6 style='color: red;'>No customer found for given email</h6>");
            out.println("</div>");
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Call doGet to handle both GET and POST requests
        doGet(request, response);
    }
}
