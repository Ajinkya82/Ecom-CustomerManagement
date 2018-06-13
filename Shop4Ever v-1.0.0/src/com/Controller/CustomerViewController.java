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

import com.bean.Customer;
import com.service.StoreService;


@WebServlet("/CustomerViewController")
public class CustomerViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Customer> customerDetails = new ArrayList<>();
	
    public CustomerViewController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		customerDetails =StoreService.viewCustomer();
		
		if(customerDetails==null)
		{
			response.sendRedirect("failure.jsp");
		}
		else
		{
			request.setAttribute("customerDetails", customerDetails);	
			
			RequestDispatcher rd = request.getRequestDispatcher("customerDetails.jsp");
			
			rd.forward(request, response);
			
		}
	}

}
