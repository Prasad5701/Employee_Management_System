package jsp_employee;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/info")
public class InfoController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EmployeeCRUD crud = new EmployeeCRUD();
		
		if(req.getParameter("id") == null)
		{
			try {
				List emp = crud.getEmployeeDetails();
				
				req.setAttribute("list", emp);
				RequestDispatcher dispatcher = req.getRequestDispatcher("employee_info.jsp");
				dispatcher.forward(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else {
			
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				List emp = crud.getEmployeeDetails(id);
				req.setAttribute("list", emp);
				RequestDispatcher dispatcher = req.getRequestDispatcher("employee_info.jsp");
				dispatcher.forward(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(req.getParameter("delete") == null)
		{
			try {

				int id = Integer.parseInt(req.getParameter("delete"));
				crud.deleteEmployeeDetails(id);
				List emp = crud.getEmployeeDetails();
				
				req.setAttribute("list", emp);
				RequestDispatcher dispatcher = req.getRequestDispatcher("employee_info.jsp");
				dispatcher.forward(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else {
			
			int id = Integer.parseInt(req.getParameter("delete"));
			try {
				crud.deleteEmployeeDetails(id);
				List emp = crud.getEmployeeDetails(id);
				req.setAttribute("list", emp);
				RequestDispatcher dispatcher = req.getRequestDispatcher("employee_info.jsp");
				dispatcher.forward(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}	
}
