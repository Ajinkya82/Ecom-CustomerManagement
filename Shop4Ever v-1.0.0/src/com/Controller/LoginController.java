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


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginController() {
        super();
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String role = request.getParameter("role");
		boolean status = false;
		status = StoreService.Check(id, pw, role);
		if(status) {
			if(role.equals("Sales and Marketing Head"))
			{
				request.setAttribute("role", "Sales and Marketing Head");
				RequestDispatcher rd = request.getRequestDispatcher("SNMView.jsp");
			rd.forward(request, response);}
			
			else if(role.equals("Inventory Head"))
			{RequestDispatcher rd = request.getRequestDispatcher("IHView.jsp");
			rd.forward(request, response);}
			
			else if(role.equals("Delivery Executive"))
			{
				request.setAttribute("role", "Delivery Executive");
				request.setAttribute("id", id);
				RequestDispatcher rd = request.getRequestDispatcher("DEView.jsp");
			rd.forward(request, response);}
			
			else if(role.equals("Store Keeper"))
			{
				request.setAttribute("role", "Store Keeper");
				request.setAttribute("id", id);
			RequestDispatcher rd = request.getRequestDispatcher("SKView.jsp");
			rd.forward(request, response);}
			
			else if(role.equals("Customer"))
			{RequestDispatcher rd = request.getRequestDispatcher("CView.jsp");
			rd.forward(request, response);}
			
			else if(role.equals("Managing Director"))
			{RequestDispatcher rd = request.getRequestDispatcher("MDView.jsp");
			rd.forward(request, response);}
			
			else if(role.equals("Sales Executive"))
			{
				request.setAttribute("role", "Sales Executive");
				request.setAttribute("id", id);
			RequestDispatcher rd = request.getRequestDispatcher("SEView.jsp");
			rd.forward(request, response);}
			
		}
		else {
			PrintWriter out = response.getWriter();
			out.print("Please enter a valid id, password and role");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
	}

}
