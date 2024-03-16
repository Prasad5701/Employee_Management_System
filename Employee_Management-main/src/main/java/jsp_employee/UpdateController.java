package jsp_employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/update")
public class UpdateController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		if(id!=0)
		{
			EmployeeCRUD employeeCRUD = new EmployeeCRUD();
			try {
				List list = employeeCRUD.getEmployeeDetails(id);
				
				HttpSession httpSession = req.getSession();
				String value = (String) httpSession.getAttribute("session");
				if (value != null) {
					req.setAttribute("list", list);
					RequestDispatcher dispatcher = req.getRequestDispatcher("employee_update.jsp");
					dispatcher.forward(req, res);
				} else {
					req.setAttribute("message", "Sir, Please Login !");
					RequestDispatcher dispatcher = req.getRequestDispatcher("employee_login.jsp");
					dispatcher.forward(req, res);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		
		try {
			int result = employeeCrud.updateEmployeeDetails(employeeInfo);
			if(result != 0)
			{
				Cookie[] cookies = req.getCookies();
				String value = null;
				for(Cookie cookie : cookies)
				{
					if(cookie.getName().equals("cookie"))
					{
						value = cookie.getValue();
					}
				}
				req.setAttribute("tracking", value);
				
				List list = employeeCrud.getEmployeeDetails();
				req.setAttribute("list", list);
				RequestDispatcher dispatcher = req.getRequestDispatcher("employee_info.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
