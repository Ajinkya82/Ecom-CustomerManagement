package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Employee;
import com.service.StoreService;


@WebServlet("/UpdateEmpController")
public class UpdateEmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateEmpController() {
        super();
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 boolean status = false;
		
		 SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		 String id = request.getParameter("id");
		 String firstName = request.getParameter("firstName");
		 String middleName = request.getParameter("middleName");
		 String lastName = request.getParameter("lastName");
		 String role = request.getParameter("role");
		 String type=null;
		 if(!role.equals("Delivery Executive"))
			 type = "permanent";
		 else
		 {
		 type = request.getParameter("type");
		 //System.out.println(type);
		 if(!type.equals("permanent"))
			 type="contract";
		 }
		 
		 float fs = 0.0F;
		 if(type.equals("permanent"))
		 switch(role) {
		 case "Delivery Executive" : fs = 20000.0f;
		 break;
		 case "Sales and Marketing Head" : fs = 30000.0f;
		 break;
		 case "Inventory Head" : fs = 35000.0f;
		 break;
		 case "Store Keeper" : fs = 25000.0f;
		 break;
		 case "Sales Executive" : fs = 20000.0f;
		 break;
		 }
		 else
			 fs = 0.0f;
		 
		 
		 float salary = fs;//Float.parseFloat(request.getParameter("salary"));
		 Date date=null;
		 try {
			 date = f.parse(request.getParameter("date"));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		 
		 String city = request.getParameter("city");
		 String s = request.getParameter("status");
		 Employee employee = new Employee(firstName, middleName, lastName, role, type, salary, date, city, s, id);
		status = StoreService.UpdateEmployee(employee);
		PrintWriter out = response.getWriter();
		if(status) {
			
			out.print("Employee updated successfully");
			RequestDispatcher rd = request.getRequestDispatcher("UpdateEmployee.jsp");
			rd.include(request, response);
			
		}
		else {
			
			response.sendRedirect("failure.jsp");
			
		}

		
	}

}
