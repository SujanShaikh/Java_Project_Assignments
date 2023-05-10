package servlets;

import InputData.CustomerInput;
import InputData.LoginInput;
import helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registerServ")
public class registerServ extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");

        CustomerInput ci=new CustomerInput();
        ci.setEmail(email);
        ci.setPassword(password);
        ci.setFullName(fullName);
        ci.setPhone(phone);
        ci.setAddress(address);
        ci.setGender(gender);
        ci.setDob(dob);

        LoginInput li = new LoginInput(); // Create new LoginInput entity
        li.setCustomerInput(ci); // Set the CustomerInput entity in LoginInput entity
        ci.setLoginInput(li); // Set the LoginInput entity in CustomerInput entity

        Session session= FactoryProvider.getFactory().openSession();
        Transaction tx= session.beginTransaction();
        session.save(ci);
        tx.commit();
        session.close();

        out.println("<h6 style='color: green;'>Registered Successfully</h6>");
        RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
        rd.include(request,resp);
        out.println("<meta http-equiv='refresh' content='2;url=registration.jsp'>");

    }
}
