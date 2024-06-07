import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculateServlet")
public class CalculateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter()
        try  {
            // Retrieve form parameters
            double weight = Double.parseDouble(request.getParameter("weight"));
            double height = Double.parseDouble(request.getParameter("height"));
            int age = Integer.parseInt(request.getParameter("age"));
            String gender = request.getParameter("gender");

            // Calculate BMI
            double bmi = calculateBMI(weight, height);

            // Calculate BMR
            double bmr = calculateBMR(weight, height, age, gender);

            // Forward the results to the JSP page
            request.setAttribute("bmiResult", bmi);
            request.setAttribute("bmrResult", bmr);
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Handle invalid input (non-numeric values)
            out.println("Invalid input. Please enter numeric values for weight, height, and age.");
        }
    }

    private double calculateBMI(double weight, double height) {
        // BMI Calculation: BMI = weight (kg) / (height (m))^2
        double heightInMeters = height / 100.0; // Convert height to meters
        return weight / (heightInMeters * heightInMeters);
    }

    private double calculateBMR(double weight, double height, int age, String gender) {
        // BMR Calculation (Harris-Benedict Equation):
        // For men: BMR = 88.362 + (13.397 * weight in kg) + (4.799 * height in cm) - (5.677 * age in years)
        // For women: BMR = 447.593 + (9.247 * weight in kg) + (3.098 * height in cm) - (4.330 * age in years)
        if ("male".equalsIgnoreCase(gender)) {
            return 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else {
            return 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }
    }
}
