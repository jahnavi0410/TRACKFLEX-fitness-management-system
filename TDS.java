import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/TDS")
public class TDS extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve parameters
        String target_weight = request.getParameter("textWeight");
        String target_date = request.getParameter("textDate");
        String target_hours = request.getParameter("textHours");
        String loggedInUserID = UHPS.getLoggedInUserID();
        String action = request.getParameter("submitType");
      //  String submitType = request.getParameter("submitType");

        int i = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FITNESS", "root", "root123");

          
                if ("insert".equals(action)) {
                    // Insert data
                    PreparedStatement ps1 = con.prepareStatement(
                            "INSERT INTO target(userID, target_weight, target_date, target_hours) VALUES (?, ?, ?, ?)");
                    ps1.setString(1, loggedInUserID);
                    ps1.setString(2, target_weight);
                    ps1.setString(3, target_date);
                    ps1.setString(4, target_hours);
                    i = ps1.executeUpdate();
                } else// if ("update".equals(action)) 
                	{
                    // Update data
                    PreparedStatement ps2 = con.prepareStatement(
                            "UPDATE target SET target_weight = ?, target_date = ?, target_hours = ? WHERE userID = ?");
                    ps2.setString(1, target_weight);
                    ps2.setString(2, target_date);
                    ps2.setString(3, target_hours);
                    ps2.setString(4, loggedInUserID);
                    i = ps2.executeUpdate();
                }
            

                if (i > 0) {
                	RequestDispatcher rd2 = request.getRequestDispatcher("DF.jsp");
                    rd2.forward(request, response);
                } else {
                    out.println("UserID does not exist!" + loggedInUserID);
                    out.println("Data not " + ("insert".equals(action) ? "inserted" : "updated"));
                }

                
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("Error: " + e.getMessage()); 
        }
    }
}
