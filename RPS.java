

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


@WebServlet("/RPS")

public class RPS extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("textName");

        // Assuming you have an integer parameter named "age" in the request
        String age = request.getParameter("textAge");

        // Check if the parameter is not null to avoid NullPointerException
        if (age != null) {
            try {
                // Parse the string parameter to an integer
                int ageP = Integer.parseInt(age);

                // Now, you can use the 'age' variable in your code
                // ...
            } catch (NumberFormatException e) {
                // Handle the case where the parameter is not a valid integer
                // This could be due to non-numeric input
                e.printStackTrace(); // or log the exception
            }
        } else {
            // Handle the case where the parameter is not present in the request
        }

        String sex = request.getParameter("textSex");
        String locality = request.getParameter("textCity");
        String phoneno = request.getParameter("textPhno."); // corrected parameter name
        String password = request.getParameter("textPassword"); // corrected parameter name
        int i = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FITNESS", "root", "root123");
            PreparedStatement ps = con.prepareStatement(
                    "insert into Registeration(username, age, sex, locality, phoneno, password) values (?, ?, ?, ?, ?, ?)");
            ps.setString(1, username);
            ps.setString(2, age);
            ps.setString(3, sex);
            ps.setString(4, locality);
            ps.setString(5, phoneno);
            ps.setString(6, password);

            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i > 0) {
            //out.println("Data Submitted Successfully!");
            //out.println("Go back to <a href='UHP.jsp'>USER LOGIN PAGE</a>");
        	RequestDispatcher rd2 = request.getRequestDispatcher("UHP.jsp");
            rd2.forward(request, response);
        } else {
            out.println("Data not submitted");
        }
    }
}
