package jsp_employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class deleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		EmployeeCRUD crud = new EmployeeCRUD();
		int id = Integer.parseInt(req.getParameter("id"));
		if(req.getParameter("delete") == null)
		{
			try {

//				int id = Integer.parseInt(req.getParameter("delete"));
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
			
//			int id = Integer.parseInt(req.getParameter("delete"));
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
