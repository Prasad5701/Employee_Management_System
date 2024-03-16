package jsp_employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import jsp_employee.EmployeeCRUD;
import jsp_employee.EmployeeInfo;

@WebServlet("/employee_signup")
public class SaveController extends GenericServlet{
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long phone = Long.parseLong(req.getParameter("phone"));
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		EmployeeInfo employeeInfo = new EmployeeInfo();
		employeeInfo.setId(id);
		employeeInfo.setName(name);
		employeeInfo.setPhone(phone);
		employeeInfo.setAddress(address);
		employeeInfo.setEmail(email);
		employeeInfo.setPassword(password);
		
		EmployeeCRUD employeeCrud = new EmployeeCRUD();
		try 
		{
			int result = employeeCrud.signUp(employeeInfo);
//			PrintWriter out = res.getWriter();
			if (result != 0) 
			{
//				out.print("Register Successful");
				req.setAttribute("message", "SignUp Successful!, Please Login");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("employee_login.jsp");
				requestDispatcher.forward(req, res);
			}
			else
			{
//				out.print("Register Failed");
				req.setAttribute("message", "SignUp Failed!, Please SignUp Again");
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
