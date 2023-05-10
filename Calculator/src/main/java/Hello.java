import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int x, y;
		String str = "";
		x = Integer.parseInt(request.getParameter("num1"));
		y = Integer.parseInt(request.getParameter("num2"));

		str = request.getParameter("operation");
		if (str.equals("add"))
			out.println("<h1> Result of Addition is :" + (x + y) + "</h1>");
		else if (str.equals("sub"))
			out.println("<h1> Result of Substraction is :" + (x - y) + "</h1>");
		else if (str.equals("mul"))
			out.println("<h1> Result of Multiplication is :" + (x * y) + "</h1>");
		else if (str.equals("div"))
			out.println("<h1> Result of Division  is :" + (x / y) + "</h1>");
		else if (str.equals("mod"))
			out.println("<h1> Result of Modulus is :" + (x % y) + "</h1>");
		else {
			out.println("select option");
		}
		out.println("<a href=index.html > Back </a>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
