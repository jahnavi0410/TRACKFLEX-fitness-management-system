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



@WebServlet("/NDS")
public class NDS extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

       

        // Retrieve other parameters
        String Food_Type = request.getParameter("textFoodType");
        String Calories_Consumed = request.getParameter("textCalConsumed");
        String Water_Intake = request.getParameter("textWaterConsumed");
        String loggedInUserID = UHPS.getLoggedInUserID();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        

        int i = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FITNESS", "root", "root123");
            PreparedStatement ps2 = con.prepareStatement(
                        "INSERT INTO nutrition(userID,FoodType,CaloriesConsumed,WaterInTake,Date) VALUES (?,?,?,?,?)");

                ps2.setString(1, loggedInUserID);
                ps2.setString(2, Food_Type);
                ps2.setString(3, Calories_Consumed);
                ps2.setString(4, Water_Intake);
                ps2.setTimestamp(5, timestamp);
                i = ps2.executeUpdate();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i > 0) {
            //out.println("Nutrition Data Submitted Successfully!"+loggedInUserID);
        	RequestDispatcher rd2 = request.getRequestDispatcher("DF.jsp");
            rd2.forward(request, response);
        } else {
        	out.println("UserID does not exist!" + loggedInUserID);
           
            out.println("Nutrition Data not submitted");
        }
    }
}
