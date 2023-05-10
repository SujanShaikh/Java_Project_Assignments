import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/Profile")
public class Profile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        if(session == null){
            response.sendRedirect("Login");
        }

        try{
            Connection con= ConnectDB.connection();

            String fetch_students = "select * from student";
            String count_student = "select count(*) from student";
            String active_student = "select count(*) from student where status = 'Active'";

            PreparedStatement pst = con.prepareStatement(fetch_students);
            ResultSet rs = pst.executeQuery();

            PreparedStatement pst2 = con.prepareStatement(count_student);
            ResultSet rs2 = pst2.executeQuery(count_student);
            rs2.next();

            PreparedStatement pst3 = con.prepareStatement(active_student);
            ResultSet rs3 = pst3.executeQuery(active_student);
            rs3.next();

            out.println("\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <title>Login</title>\n" +
                    "    <style>\n" +
                    "        td,th{\n" +
                    "        padding :14px 30px\n" +
                    "        }\n" +
                    "        body{\n" +
                    "        font-family :arial;\n" +
                    "        }\n" +
                    "        table{\n" +
                    "        border : 1px solid black;\n" +
                    "        padding : 20px;\n" +
                    "        }\n" +
                    "        a{\n" +
                    "        text-decoration:none;\n" +
                    "        border : 1px solid black;\n" +
                    "        padding: 10px 10px\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<center>\n" +
                    "    <h2>Hii Admin</h2><br>\n" +
                    "    <div style=\"float : left; color : orange; border : 1px solid black; padding : 5px 5px\">Total Student<h3>rs.getInt(1)</h3></div>\n" +
                    "    <div style=\"float : left; margin-left:10px; color:blue; border:1px solid black; padding : 5px 5px\">Total Active Student<h3><a href=\"SearchResult?Fetch=Active\" style=\"border:none;\">"+rs3.getInt(1)+ "</a> </h3></div>\n" +
                    "    <div style=\"float : left; margin-left:10px; color:green; border:1px solid black; padding : 5px 5px\">Total Active Student<h3><a href=\"SearchResult?Fetch=Deactive\" style=\"border:none;>"+(rs2.getInt(1)-rs3.getInt(1))+"</a> </h3></div>\n" +
                    "    <div style=\"clear : both;\"></div><div style=\"float :right;\"><a href=\"OperationForm?Id=Add\">Add Student</a>\n" +
                    "    <a href=\"Logout\" style=\"margin-left : 10px\">Log Out</a></div>\n" +
                    "    <br><br><br>\n" +
                    "\n" +
                    "    <div style=\"float:left;\">\n" +
                    "        <form action=\"SearchResult\" method=\"post\">\n" +
                    "            <input type=\"text\" name=\"Fetch\" placeholder=\"Search Student\" required>\n" +
                    "            <input type=\"submit\" value=\"Search\" style=\"margin-left:10px;\"><br>\n" +
                    "        </form></div>\n" +
                    "    <div style=\"float:right;\">\n" +
                    "        <form action=\"GeneratePDF\">\n" +
                    "            <select name=\"status\">\n" +
                    "                <option>Active</option>\n" +
                    "                <option>Deactive</option>\n" +
                    "            </select>\n" +
                    "            <input type=\"submit\" value=\"Generate Report\" style=\"margin-left:10px;\">\n" +
                    "        </form>\n" +
                    "\n" +
                    "    </div>\n" +
                    "    <div style=\"clear:both;\"><h2>Student Details</h2></div>\n" +
                    "</center>\n" +
                    "</body>");

            out.println("<table margin-top:-80px>\n" +
                    "    <tr>\n" +
                    "        <th>Id</th>\n" +
                    "        <th>Student</th>\n" +
                    "        <th>Enrollment</th>\n" +
                    "        <th>Date of Birth</th>\n" +
                    "        <th>Gender</th>\n" +
                    "        <th>Phone</th>\n" +
                    "        <th>Status</th>\n" +
                    "        <th>Update</th>\n" +
                    "        <th>Delete</th>\n" +
                    "    </tr>\n");

            while (rs.next()){
                out.println(" <tr>\n" +
                        "        <td>"+ rs.getInt(1)+"</td>\n" +
                        "        <td>"+rs.getString(2)+"</td>\n" +
                        "        <td>"+rs.getString(3)+"</td>\n" +
                        "        <td>"+rs.getString(4)+"</td>\n" +
                        "        <td>"+rs.getString(5)+"</td>\n" +
                        "        <td>"+rs.getString(6)+"</td>\n" +
                        "        <td>"+rs.getString(7)+"</td>\n" +
                        "        <td><a href='OperationForm?Id="+rs.getInt(1)+"'>Update</td>\n" +
                        "        <td><a href='OperationWithDatabase?OperationType=Delete&Id="+rs.getInt(1)+"'>Delete</td>\n" +
                        "        \n" +
                        "    </tr><br><br>");
            }

            out.println("</table></div></html>");
            con.close();


        }catch (Exception e){

        }
    }
}