package servlets;

import InputData.CustomerInput;
import InputData.LoginInput;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/DisplayAllUserServ")
public class DisplayAllUserServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        System.out.println("1");
        if (session == null) {
            System.out.println("2");

            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.forward(req, resp);
        }

        String userType = req.getParameter("userType");
        String email = req.getParameter("email");
        System.out.println("3");

        session.setAttribute("email", userType);
        session.setAttribute("userType", userType);
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Query<LoginInput> loginQuery = hibernateSession.createQuery("from LoginInput where email=:email and userType = :userType");
        loginQuery.setParameter("email", email);
        loginQuery.setParameter("userType", userType);
        List<LoginInput> loginInputList = loginQuery.list();

        if (loginInputList != null && !loginInputList.isEmpty()) {

            System.out.println("4");

            // Assuming only one login record exists for the given email and user type
            LoginInput loginInput = loginInputList.get(0);
            // Query to fetch customer details for the emails obtained from the LoginInput table
            List<String> emailList = new ArrayList<>();
            for (LoginInput login : loginInputList) {
                emailList.add(login.getEmail());
            }
            // Query to fetch customer details for the emails obtained from the LoginInput table
            Query<CustomerInput> customerQuery = hibernateSession.createQuery("from CustomerInput where email IN (:emails)");
            customerQuery.setParameterList("emails", Arrays.asList(loginInput.getEmail()));
            List<CustomerInput> customerList = customerQuery.list();

            hibernateSession.close();

            resp.setContentType("text/html;charset=UTF-8");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User Details</title>");

            // Add Bootstrap CSS link
            out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");

            out.println("</head>");
            out.println("<body>");

            if (customerList != null && !customerList.isEmpty()) {

                System.out.println("5");

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

                for (CustomerInput customer : customerList) {
                    out.println("<tr>");
                    out.println("<td>" + customer.getCustomerId() + "</td>");
                    out.println("<td>" + customer.getFullName() + "</td>");
                    out.println("<td>" + customer.getAddress() + "</td>");
                    out.println("<td>" + customer.getEmail() + "</td>");
                    out.println("<td>" + customer.getGender() + "</td>");
                    out.println("<td>" + customer.getDob() + "</td>");
                    out.println("</tr>");
                }

                out.println("</table>");

                out.println("<a href='LogoutServ' class='btn btn-danger'>Logout</a>"); // Logout button
                out.println("<a href='AddUser.jsp' class='btn btn-primary ml-2'>Add User</a>"); // Raise Complaint button
                out.println("</div>");

            }


            hibernateSession.close();


        }
    }
}
