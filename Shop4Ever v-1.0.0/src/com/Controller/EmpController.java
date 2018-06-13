package com.Controller;

import java.io.IOException;
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

@WebServlet("/EmpController")
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EmpController() {
        super();
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
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
		 String status = request.getParameter("status");
		 //System.out.println(firstName+" "+middleName+" "+lastName+" "+role+" "+type+" "+salary+" "+date+" "+city+" "+status);
		
		 
		 boolean s = false;
		 
		 String empIdpw=StoreService.getId();
		 String[] idpw = empIdpw.split(" ");
		 String Id=idpw[0], Pw=idpw[1];
		 
		 Employee employee = new Employee(firstName, middleName, lastName, role, type, salary, date, city, status, Id);
		 
		 s = StoreService.employeeDetails(employee, Id, Pw);
		 
		 if(s) {
			 request.setAttribute("Id", Id);
			 request.setAttribute("Pw", Pw);
			 RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			 rd.forward(request, response);
		 }
		 else
			 response.sendRedirect("failure.jsp");
	}

}
