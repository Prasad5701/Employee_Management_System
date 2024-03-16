package jsp_employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout")
public class LogoutController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String email = (String)session.getAttribute("session");
		if(email != null)
		{
			session.invalidate();
			req.setAttribute("message", "Logout Successful");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("employee_login.jsp");
			requestDispatcher.forward(req, res);
		}
		
	}
	
}
