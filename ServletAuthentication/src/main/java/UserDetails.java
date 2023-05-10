import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;

@WebServlet("/UserDetails")
public class UserDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");
        Enumeration pName=req.getParameterNames();
        while(pName.hasMoreElements()){
            String name= (String) pName.nextElement();
            out.print("<h2> "+name+" : <h2>");

            String [] pValue=req.getParameterValues(name);
            if(pValue.length==1){
                String p=pValue[0];
                if(p.length()==0)
                    out.println("NO value");
                else
                    out.print(p);
            }
            else {
                for(int i=0;i< pValue.length;i++){
                    out.print(pValue[i]);
                }
            }
        }
    }
}
