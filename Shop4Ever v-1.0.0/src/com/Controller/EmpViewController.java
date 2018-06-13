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


@WebServlet("/EmpViewController")
public class EmpViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpViewController() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean status = false;
		String id =(String)request.getParameter("id");
		System.out.println(id);
		status = StoreService.empEligibility(id);
		if(status) {
			String city = StoreService.getCity(id);
			String[] arr = city.split(" ");
			request.setAttribute("city", arr[0]);
			request.setAttribute("id", id);
			RequestDispatcher rd = request.getRequestDispatcher("transfer.jsp");
			rd.include(request, response);
			
		}
		else {
			 PrintWriter out = response.getWriter();
			 out.print("You Need to complete at least one year of service");  
			 RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			 rd.include(request, response);
		}
		
	}

}
