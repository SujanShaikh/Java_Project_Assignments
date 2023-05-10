package servlets;

import InputData.CrmInput;
import InputData.CustomerInput;
import helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CrmInputServlet")
public class CrmInputServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cname = request.getParameter("cname");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        CrmInput crmInput = new CrmInput();
        crmInput.setCname(cname);
        crmInput.setAddress(address);
        crmInput.setEmail(email);
        crmInput.setPassword(password);

        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = hibernateSession.beginTransaction();
            int crmId = (int) hibernateSession.save(crmInput); // Save the CrmInput entity and get the generated crmId
            tx.commit();
            response.sendRedirect("crmInput.jsp?msg=success"); // Redirect to JSP page with success message
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            response.sendRedirect("crmInput.jsp?msg=error"); // Redirect to JSP page with error message
            e.printStackTrace();
        } finally {
            hibernateSession.close();
        }
    }
}

