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

@WebServlet("/StatusController")
public class StatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusController() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean s = false;
		String id = request.getParameter("empid");
		String status = request.getParameter("status");
		String reason = null;
		if(!status.equals("Approved")) {
			reason = request.getParameter("reason");
		}
		else
			reason = "nil";
		s = StoreService.TransferStatus(id, status, reason);
		if(s) {
			
			PrintWriter out = response.getWriter();
			out.print("Status updated successfully");
			RequestDispatcher rd = request.getRequestDispatcher("StatusSuccess.jsp");
			rd.include(request, response);
			
		}
		else {
			response.sendRedirect("failure.jsp");
		}
		
	}

}
