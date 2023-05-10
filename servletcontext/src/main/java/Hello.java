import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
		response.setContentType("text/html");
//		out.println("Hello from Servlet");
		int count = 0;
		String name = request.getParameter("uname");
		String pwd = request.getParameter("password");

		ServletContext servletContext = getServletContext();

		try {
			Class.forName(servletContext.getInitParameter("driver"));
			Connection conn = DriverManager.getConnection(servletContext.getInitParameter("url"), servletContext.getInitParameter("username"), servletContext.getInitParameter("password"));
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user");

			while (rs.next()) {
				String username = rs.getString(2);
				String userPwd = rs.getString(3);

				if (name.equals(username) && pwd.equals(userPwd)) {
					out.print("<h1> Welcome</h1> " + username + " :) ");
					count++;
					response.sendRedirect("UserTable");
					break;
				}
			}
			if (count == 0) {
				out.print("<h1 style='color:red'> Try Again  :( </h1>");
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.html");
				requestDispatcher.include(request,response);
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


}
