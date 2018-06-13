package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Transfer;
import com.service.StoreService;


@WebServlet("/Transfer")
public class TransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TransferController() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String currentCity = request.getParameter("currentCity");
		//System.out.println(currentCity);
		String preferredCity = request.getParameter("preferredCity");
		String reason =  request.getParameter("reason");
		Transfer transfer = new Transfer(id, currentCity, preferredCity, reason);
		boolean status = false;
		status = StoreService.transEmp(transfer);
		if(status) {
			 PrintWriter out = response.getWriter();
			 out.print("Request sent successfully");  
			 RequestDispatcher rd = request.getRequestDispatcher("transfer.jsp");
			 rd.include(request, response);
		}
		else
			response.sendRedirect("failure.jsp");
	}

}
