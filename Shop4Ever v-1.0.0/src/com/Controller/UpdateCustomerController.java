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

import com.bean.Customer;
import com.service.StoreService;

/**
 * Servlet implementation class UpdateCustomerController
 */
@WebServlet("/UpdateCustomerController")
public class UpdateCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateCustomerController() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean status = false;
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String middleName =  request.getParameter("middleName");
		String lastName =  request.getParameter("lastName");
		Date date=null;
		try {
			 date = f.parse(request.getParameter("date"));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		} 
		String gender =  request.getParameter("gender");
		String permanentAddress =  request.getParameter("permanentAddress");
		String presentAddress =  request.getParameter("lastName");
		String email =  request.getParameter("presentAddress");
		Long number =  Long.parseLong(request.getParameter("number"));
		Customer customer = new Customer(firstName, middleName, lastName, date, gender, permanentAddress, presentAddress, email, number, id);
		status = StoreService.UpdateCustomer(customer);
		PrintWriter out = response.getWriter();
		if(status) {
			
			out.print("Customer updated successfully");
			RequestDispatcher rd = request.getRequestDispatcher("UpdateCustomer.jsp");
			rd.forward(request, response);
			
		}
		else {
			
			response.sendRedirect("failure.jsp");
			
		}
	}

}
