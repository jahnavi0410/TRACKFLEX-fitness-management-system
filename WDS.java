import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/WDS")
public class WDS extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

       

        // Retrieve other parameters
        String WorkOut_Type = request.getParameter("textWorkOutType");
        String Duration = request.getParameter("textDuration");
        String Calories_Burnt = request.getParameter("textCalories");
        String loggedInUserID = UHPS.getLoggedInUserID();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        

        int i = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FITNESS", "root", "root123");
           
            PreparedStatement ps2 = con.prepareStatement(
                        "INSERT INTO WorkOut(userID,Type,Duration,CaloriesBurnt,Date) VALUES (?, ?, ?,?, ?)");

                ps2.setString(1, loggedInUserID);
                ps2.setString(2, WorkOut_Type);
                ps2.setString(3, Duration);
                ps2.setString(4, Calories_Burnt);
                ps2.setTimestamp(5, timestamp);
                i = ps2.executeUpdate();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i > 0) {
        	RequestDispatcher rd2 = request.getRequestDispatcher("DF.jsp");
            rd2.forward(request, response);
        } else {
        	out.println("UserID does not exist!" + loggedInUserID);
           
            out.println("Work Out Data not submitted");
        }
    }
}
