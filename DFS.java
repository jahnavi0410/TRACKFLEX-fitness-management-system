import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DFS")
public class DFS extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
   	 
        if ("addUpdateWorkout".equals(action)) {
            // Redirect to the JSP page for entering student details
        	
            RequestDispatcher rd = request.getRequestDispatcher("/WD.jsp");
            rd.forward(request, response);
           }
        else if ("addUpdateNutrition".equals(action)) 
        {
            // Redirect to the JSP page for viewing student details
            RequestDispatcher rd = request.getRequestDispatcher("/ND.jsp");
            rd.forward(request, response);
        }
        else if ("addUpdateHealthMetrics".equals(action)) 
        {
            // Redirect to the JSP page for viewing student details
            RequestDispatcher rd = request.getRequestDispatcher("HMD.jsp");
            rd.forward(request, response);
        }
        else if ("addUpdateTarget".equals(action)) 
        {
            // Redirect to the JSP page for viewing student details
            RequestDispatcher rd = request.getRequestDispatcher("/TD.jsp");
            rd.forward(request, response);
        }
        else  if ("viewRoutine".equals(action)) 
        {
            // Redirect to the JSP page for viewing student details
            RequestDispatcher rd = request.getRequestDispatcher("/Trial");
            rd.forward(request, response);
        }
        
        
       
    }
	

}