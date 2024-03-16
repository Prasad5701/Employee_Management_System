package jsp_employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp_employee.EmployeeCRUD;

@WebServlet("/employee_login")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		EmployeeCRUD employeeCrud = new EmployeeCRUD();
		
		try 
		{
			String dbPassword = employeeCrud.login(email);
//			PrintWriter out = res.getWriter();
			if (dbPassword != null) 
			{
				if(password.equals(dbPassword))
				{
//					out.print("Login Successfull");
					
					// Cookie creation
					Cookie cookie = new Cookie("cookie", email);
					res.addCookie(cookie);
					
					// Session creation
					HttpSession httpSession = req.getSession();
					httpSession.setAttribute("session", email);
					
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("success.jsp");
					requestDispatcher.forward(req, res);
				}
				else
				{
//					out.print("Invalid Password");
					req.setAttribute("password", "Invalid Password!, Please Enter Correct Password");
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("employee_login.jsp");
					requestDispatcher.forward(req, res);
				}
			}
			else
			{
//				out.print("User not register with "+email);
				req.setAttribute("email", "User is not register with this "+email+"\nPlease Register");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("employee_signup.jsp");
				requestDispatcher.forward(req, res);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
}
