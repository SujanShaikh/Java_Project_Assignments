package servlets;

import InputData.LoginInput;
import InputData.CustomerInput;
import helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
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

@WebServlet("/loginServ")
public class loginServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        HttpSession hs = req.getSession();

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String userType = req.getParameter("userType");

        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("FROM CustomerInput WHERE email = :email and password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);

        List<CustomerInput> list = query.getResultList();
        tx.commit();

        if (list.size() > 0) {

            LoginInput loginInput = new LoginInput();
            loginInput.setEmail(email);
            loginInput.setPassword(password);

            // Set userType based on the selection made by the user
            if ("admin".equalsIgnoreCase(userType)) {
                loginInput.setUserType("Admin");
            } else if ("crm".equalsIgnoreCase(userType)) {
                loginInput.setUserType("CRM");
            } else if ("user".equalsIgnoreCase(userType)) {
                loginInput.setUserType("User");
            }

            Session session2 = FactoryProvider.getFactory().openSession();
            Transaction tx2 = session2.beginTransaction();
            session2.save(loginInput);
            tx2.commit();

            if (userType.equalsIgnoreCase("Admin")) {
                hs.setAttribute("email", email);
                RequestDispatcher rd = req.getRequestDispatcher("Admin.jsp");
                rd.forward(req, resp);
            } else if (userType.equalsIgnoreCase("User")) {
                hs.setAttribute("email", email);
                RequestDispatcher rd = req.getRequestDispatcher("UserDetailsServ");
                rd.forward(req, resp);
            } else if (userType.equalsIgnoreCase("CRM") && email.equals(email)) {
                hs.setAttribute("email", email);
                RequestDispatcher rd = req.getRequestDispatcher("Crm.jsp");
                rd.forward(req, resp);
            }
        } else {
            out.println("<h6 style='color: red;'>Invalid Details</h6>");
            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.include(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}
