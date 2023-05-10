import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;

@MultipartConfig
@WebServlet("/RegistrationServ")
public class RegistrationServ extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");
        Connection conn=Connectivity.connection();

        PreparedStatement ps1,ps2;
        ResultSet rs1,rs2;

        // get user parameters
        String name= req.getParameter("name");
        String email= req.getParameter("email");
        String password= req.getParameter("password");
        String dob= req.getParameter("dob");
        String address= req.getParameter("address");
        String phoneno= req.getParameter("phone");
        String imageName=req.getParameter("image");


        Part file = req.getPart("image");
        String filename = file.getSubmittedFileName();
        String uploadPath = "C:/Users/Coditas/IdeaProjects/ServletProjects/UserCrud/src/main/webapp/images/"+filename;

        FileOutputStream fos = new FileOutputStream(uploadPath);
        InputStream is = file.getInputStream();

        byte[] data = new byte[is.available()];
        is.read(data);
        fos.write(data);
        fos.close();


        try{
            String insertUser="insert into userdb (uname, uemail, password, dob, address, phoneno, imagename) values (?,?,?,?,?,?,?)";
            ps1=conn.prepareStatement(insertUser);

            ps1.setString(1,name);
            ps1.setString(2,email);
            ps1.setString(3,password);
            ps1.setString(4, dob);
            ps1.setString(5,address);
            ps1.setString(6,phoneno);
            ps1.setString(7,filename);



            ps1.execute();
            String insertUserCheck="insert into userCheck ( uemail, upassword) values (?,?)";
            ps2=conn.prepareStatement(insertUserCheck);

            ps2.setString(1,email);
            ps2.setString(2,password);

            ps2.execute();


            out.println("<h2> "+name +" you have registered successfully </h2>");
            System.out.println("Message: " + "<h2 style='color:green'>" + name + " you have registered successfully </h2>");
            RequestDispatcher rd= req.getRequestDispatcher("login.html");
            rd.forward(req,resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
