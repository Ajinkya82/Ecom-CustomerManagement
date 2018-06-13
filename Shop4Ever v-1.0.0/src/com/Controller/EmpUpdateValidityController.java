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

/**
 * Servlet implementation class EmpUpdateValidityController
 */
@WebServlet("/EmpUpdateValidityController")
public class EmpUpdateValidityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpUpdateValidityController() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 boolean valid = false;
		 String id = request.getParameter("id");
		 String headrole = request.getParameter("headrole");
		 //System.out.println(id+" "+headrole);
		 valid = StoreService.EmpValidity(id, headrole);
		 if(valid) {
			 
			 request.setAttribute("id", id);
			 RequestDispatcher rd = request.getRequestDispatcher("UpdateEmployee.jsp");
			 rd.forward(request, response);
			 
		 }
		 else {
			 
			 PrintWriter out = response.getWriter();
			 out.print("You are not authorized to update employee of other department");
			 RequestDispatcher rd = request.getRequestDispatcher("EmpIdToUpdate.jsp");
			 rd.include(request, response);
		 }
	}

}
