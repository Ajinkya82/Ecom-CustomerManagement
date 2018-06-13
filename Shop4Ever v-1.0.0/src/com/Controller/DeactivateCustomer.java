package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.StoreService;

@WebServlet("/DeactivateCustomer")
public class DeactivateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public DeactivateCustomer() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean status = false;
		String id = request.getParameter("id");
		status = StoreService.deleteCustomer(id);
		System.out.print(status);
		PrintWriter out = response.getWriter(); 
		if(status) {
			 
			request.setAttribute("id", "id");
			out.print("user with ID="+id+" is deleted successfully"); 
			RequestDispatcher rd = request.getRequestDispatcher("DeactivateCustomer.jsp");
			
			rd.include(request, response);
			
			
		}
		else {
			out.print("Please enter a valid ID");
			RequestDispatcher rd = request.getRequestDispatcher("DeactivateCustomer.jsp");
			rd.include(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
