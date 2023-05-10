import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <title>Login</title>\n" +
                "    <style>\n" +
                "        body{\n" +
                "        font-family : arial;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<center>\n" +
                "    <h1>Login</h1>\n" +
                "    <form action=\"Check_User\" method = \"post\">\n" +
                "        <input type=\"text\" name=\"uname\" placeholder=\"Username\" required>\n" +
                "        <input type=\"password\" name=\"pass\" placeholder=\"Password\" required>\n" +
                "        <input type=\"submit\" value=\"go\">\n" +
                "    </form>\n" +
                "</center>\n" +




                "</body>\n" +
                "</html>");
        request.getRequestDispatcher("Logout").include(request, response);


    }

}