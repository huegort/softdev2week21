package employee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.Employee;
import employee.EmployeeDAO;

/**
 * Servlet implementation class EditEmployeeFormServlet
 */
@WebServlet("/EditEmployeeFormServlet")
public class EditEmployeeFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditEmployeeFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			long id = Long.parseLong(request.getParameter("id"));
			EmployeeDAO employeeDAO = new EmployeeDAO();
			Employee employee = employeeDAO.findById(id);

			request.setAttribute("employee", employee);
			String view ="EditEmployeeFormView.jsp";
			request.getRequestDispatcher(view).forward(request, response);

		}catch (NumberFormatException nfe){
			response.getWriter().println("ids need to be a number");
		}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
