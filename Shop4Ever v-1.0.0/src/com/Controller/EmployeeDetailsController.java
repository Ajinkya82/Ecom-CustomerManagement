package com.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Employee;
import com.service.StoreService;


@WebServlet("/EmployeeDetailsController")
public class EmployeeDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public EmployeeDetailsController() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> employeeDetails = new ArrayList<>();
		String r = null;
		String role = (String) request.getParameter("role");
		if(role.equals("Sales and Marketing Head")) {
			
			r = "Sales Executive"+"  "+"Delivery Executive";
			
		}
		else if(role.equals("Inventory Head")) {
			
			r = "Store Keeper";
			
		}
		
		employeeDetails = StoreService.getEmpDetails(r);
		if(employeeDetails==null) {
			response.sendRedirect("failure.jsp");
		}
		else {
			request.setAttribute("employeeDetails", employeeDetails);
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeDetails.jsp");
			rd.forward(request, response);
		}
		
	}

}
