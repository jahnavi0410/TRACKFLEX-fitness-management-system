


 import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Trial")
public class Trial extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

       

        // Retrieve other parameters
        
        String loggedInUserID = UHPS.getLoggedInUserID();
  
        

        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FITNESS", "root", "root123");
            PreparedStatement ps2 = con.prepareStatement(
            		"SELECT " +
                            "n.userID, " +
                            "n.Date, " +
                            "COALESCE(n.TotalWaterIntake, 0) AS TotalWaterIntake, " +
                            "COALESCE(n.TotalCaloriesConsumed, 0) AS TotalCaloriesConsumed, " +
                            "COALESCE(n.FoodTypesConsumed, '') AS FoodTypesConsumed, " +
                            "COALESCE(w.WorkoutTypes, '') AS WorkoutTypes, " +
                            "COALESCE(w.TotalWorkoutDuration, 0) AS TotalWorkoutDuration, " +
                            "COALESCE(w.TotalCaloriesBurnt, 0) AS TotalCaloriesBurnt " +
                        "FROM " +
                            "(" +
                                "SELECT " +
                                    "userID, " +
                                    "DATE(Date) AS Date, " +
                                    "COALESCE(SUM(WaterIntake), 0) AS TotalWaterIntake, " +
                                    "COALESCE(SUM(CaloriesConsumed), 0) AS TotalCaloriesConsumed, " +
                                    "GROUP_CONCAT(DISTINCT FoodType) AS FoodTypesConsumed " +
                                "FROM " +
                                    "Nutrition " +
                                "WHERE " +
                                    "userID = ? " +
                                "GROUP BY " +
                                    "userID, DATE(Date)" +
                            ") n " +
                        "LEFT JOIN " +
                            "(" +
                                "SELECT " +
                                    "userID, " +
                                    "DATE(Date) AS Date, " +
                                    "GROUP_CONCAT(DISTINCT Type) AS WorkoutTypes, " +
                                    "COALESCE(SUM(Duration), 0) AS TotalWorkoutDuration, " +
                                    "COALESCE(SUM(CaloriesBurnt), 0) AS TotalCaloriesBurnt " +
                                "FROM " +
                                    "Workout " +
                                "WHERE " +
                                    "userID = ? " +
                                "GROUP BY " +
                                    "userID, DATE(Date)" +
                            ") w ON n.userID = w.userID AND n.Date = w.Date");

                ps2.setString(1, loggedInUserID);
                ps2.setString(2, loggedInUserID);
                ResultSet rs = ps2.executeQuery();
                request.setAttribute("resultData", rs);
                request.getRequestDispatcher("/VRD.jsp").forward(request, response);

                // Process the result set and populate routineEntries list
               
              
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
}
