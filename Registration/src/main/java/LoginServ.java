import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn=Connectivity.connection();
        System.out.println("1");
        PrintWriter out = resp.getWriter();
        System.out.println("2");

        resp.setContentType("text/html");
        System.out.println("3");
        HttpSession hs= req.getSession();
        System.out.println("4");


        int count=0;
        String useremail = req.getParameter("uname");
        System.out.println("5");

        String userpwd = req.getParameter("password");
        System.out.println("6");

        System.out.println(useremail+" ahahaha "+userpwd);
        System.out.println("1");

        try {
            System.out.println("7");

            Statement stmt=conn.createStatement();
            System.out.println("8");

            ResultSet rs=stmt.executeQuery("select email,password,firstname from registration where email='"+useremail+"'and password ='"+userpwd+"'");
//            ResultSet rs=stmt.executeQuery("select email,password from registration");
            System.out.println("9");

            if(rs.next()) {
                System.out.println("10");
                System.out.println("11");

                RequestDispatcher rd = req.getRequestDispatcher("WelcomeServ");
                rd.forward(req, resp);
//                resp.sendRedirect("WelcomeServ");
                System.out.println("12");
            }

            else{
                RequestDispatcher rd= req.getRequestDispatcher("login.html");
                out.println("<h3 style='color :red '> Invalid Credentials !</h3>");
                rd.include(req,resp);
            }
//            if(flag==true){
//                RequestDispatcher rd= req.getRequestDispatcher("login.html");
//                out.println("<h3 style='color :red '> Invalid Credentials !</h3>");
//                rd.include(req,resp);
//            }
//            else{
//
//            }
            /*if(rs.next()==true){
                resp.sendRedirect("WelcomeServ");
            }else{
                RequestDispatcher rd= req.getRequestDispatcher("login.html");
                out.println("<h3 style='color :red '> Invalid Credentials !</h3>");
                rd.include(req,resp);
            }*/
           /* while(rs.next()){
                String emaildb=rs.getString(1);
                String passworddb=rs.getString(2);

                if(useremail.equals(emaildb) && userpwd.equals(passworddb)){{
//                  name=rs.getString(3);
                    resp.sendRedirect("WelcomeServ");
                    count++;
                  break;
                }
                }
                if (count==1){
                    hs.setAttribute("sessionname",useremail);
                    resp.sendRedirect("WelcomeServ");
                }
                else {

                    RequestDispatcher rd= req.getRequestDispatcher("login.html");
                    out.println("<h3 style='color :red '> Invalid Credentials !</h3>");
                    rd.include(req,resp);
                }

            }*/
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn=Connectivity.connection();
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        HttpSession hs= req.getSession();

        int count=0;
        String useremail = req.getParameter("email");
        String userpwd = req.getParameter("password");

        try {
            Statement stmt=conn.createStatement();
            System.out.println("tryyy");
            ResultSet rs=stmt.executeQuery("select email,password,firstname from registration where email='"+useremail+"'and password ='"+userpwd+"'");
//            ResultSet rs=stmt.executeQuery("select email,password from registration");
            String name="";

           if(rs.next()){
                String user = rs.getString(1);
                String pass = rs.getString(2);

                    resp.sendRedirect("WelcomeServ");

            }else{
               RequestDispatcher rd= req.getRequestDispatcher("login.html");
                out.println("<h3 style='color :red '> Invalid Credentials !</h3>");
                rd.include(req,resp);
           }
//            if(flag==true){
//                RequestDispatcher rd= req.getRequestDispatcher("login.html");
//                out.println("<h3 style='color :red '> Invalid Credentials !</h3>");
//                rd.include(req,resp);
//            }
//            else{
//
//            }
            /*if(rs.next()==true){
                resp.sendRedirect("WelcomeServ");
            }else{
                RequestDispatcher rd= req.getRequestDispatcher("login.html");
                out.println("<h3 style='color :red '> Invalid Credentials !</h3>");
                rd.include(req,resp);
            }*/
           /* while(rs.next()){
                String emaildb=rs.getString(1);
                String passworddb=rs.getString(2);

                if(useremail.equals(emaildb) && userpwd.equals(passworddb)){{
//                  name=rs.getString(3);
                    resp.sendRedirect("WelcomeServ");
                    count++;
                  break;
                }
                }
                if (count==1){
                    hs.setAttribute("sessionname",useremail);
                    resp.sendRedirect("WelcomeServ");
                }
                else {

                    RequestDispatcher rd= req.getRequestDispatcher("login.html");
                    out.println("<h3 style='color :red '> Invalid Credentials !</h3>");
                    rd.include(req,resp);
                }

            }*/
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
