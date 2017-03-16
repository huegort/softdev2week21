package employee.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.Employee;
import employee.EmployeeDAO;

/**
 * Servlet implementation class ProcessCreateEmployeeServlet
 */
@WebServlet("/ProcessCreateEmployeeServlet")
public class ProcessCreateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessCreateEmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try{
			Employee employee = new Employee();
			employee.setId(Long.parseLong(request.getParameter("id")));
			employee.setName(request.getParameter("name"));
			String dobString = request.getParameter("dob");
			Date dob = sdf.parse(dobString);
			employee.setDob(dob);
			
			
			EmployeeDAO employeeDAO = new EmployeeDAO();
			employeeDAO.create(employee);
			// no go to display all
			String view = "DisplayAllEmployeesServlet";
			request.getRequestDispatcher(view).forward(request, response);
		}catch(NumberFormatException nfe){
			response.getWriter().println("someone entered text instead of a number");
		}catch(ParseException pe){
			response.getWriter().println("someone entered text instead of a date");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
