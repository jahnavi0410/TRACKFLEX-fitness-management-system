import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/HMDS")
public class HMDS extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

       

        // Retrieve other parameters
        String current_weight = request.getParameter("textCurWeight");
        String current_date = request.getParameter("textDate");
        String current_height = request.getParameter("textCurHeight");
        String loggedInUserID = UHPS.getLoggedInUserID();
        
        

        int i = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FITNESS", "root", "root123");
            PreparedStatement ps2 = con.prepareStatement(
                        "INSERT INTO HEALTHMETRICS(userID,measurement_date,height,weight) VALUES (?, ?, ?, ?)");

                ps2.setString(1, loggedInUserID);
                ps2.setString(2, current_date);
                ps2.setString(3, current_height);
                ps2.setString(4, current_weight);
                
                i = ps2.executeUpdate();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i > 0) {
           // out.println("Health Metrics Data Submitted Successfully!"+loggedInUserID);
        	RequestDispatcher rd2 = request.getRequestDispatcher("DF.jsp");
            rd2.forward(request, response);
        } else {
        	out.println("UserID does not exist!" + loggedInUserID);
           
            out.println("Health Mterics Data not submitted");
        }
    }
}
