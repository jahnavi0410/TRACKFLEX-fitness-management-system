import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteACC")
public class DeleteACC extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String loggedInUserID = UHPS.getLoggedInUserID();

        out.println("Attempting to delete account for userID: " + loggedInUserID); // Debugging

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FITNESS", "root", "root123");

            // Prepare the CallableStatement to call the stored procedure
            CallableStatement cs = con.prepareCall("{call DeleteAccount(?)}");

            // Set the user ID as a parameter in the CallableStatement
            cs.setString(1, loggedInUserID);

            // Execute the CallableStatement to invoke the stored procedure
            int updateCount = cs.executeUpdate();

            // Close the CallableStatement and Connection
            cs.close();
            con.close();

            // Provide feedback to the user based on the outcome of the stored procedure invocation
            if (updateCount > 0) {
                out.println("Your Account has been deleted Permanently");
            } else {
                out.println("Failed to delete the account");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("Failed to delete the account: " + e.getMessage());
        }
    }
}
