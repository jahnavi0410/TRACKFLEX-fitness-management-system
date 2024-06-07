import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/UHPS")
public class UHPS extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    public static String loggedInUserID;
    public UHPS()
    {    
    	
    }
    public static String getLoggedInUserID() {
        return loggedInUserID;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	 response.setContentType("text/html");
    	
    	 
       try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FITNESS", "root", "root123");
            String n = request.getParameter("textName");
            String p = request.getParameter("textPassword");
            PreparedStatement ps = con.prepareStatement("SELECT userID FROM Registeration WHERE username=? AND password=?");
            ps.setString(1, n);
            ps.setString(2, p);
            ResultSet rs1 = ps.executeQuery();
           // ResultSet rs2 = ps.executeQuery();
            
            if (rs1.next()) {
            	
              // Set the username as a request attribute
            	 loggedInUserID = rs1.getString("userID");
            	
                 RequestDispatcher rd1 = request.getRequestDispatcher("UD.jsp");
                 rd1.forward(request, response);
                 
            } else {
            	 RequestDispatcher rd2 = request.getRequestDispatcher("LF.jsp");
                 rd2.forward(request, response);
                
            }
           
          
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}

