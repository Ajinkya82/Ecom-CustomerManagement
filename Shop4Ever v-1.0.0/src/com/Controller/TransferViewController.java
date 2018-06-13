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

import com.bean.Transfer;
import com.service.StoreService;

/**
 * Servlet implementation class TransferViewController
 */
@WebServlet("/TransferViewController")
public class TransferViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TransferViewController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role = request.getParameter("role"), r1 = null, r2 = null;
		List<Transfer> transferDetails = new ArrayList<>();
		String[] r = role.split("  ");
		if(r.length==2)
			r2 = r[1];
		 r1=r[0];
		
		transferDetails =StoreService.viewTransfer(r1, r2);
		
		if(transferDetails==null)
		{
			response.sendRedirect("failure.jsp");
		}
			else
			{
				request.setAttribute("transferDetails", transferDetails);	
				
				RequestDispatcher rd = request.getRequestDispatcher("transferView.jsp");
				
				rd.forward(request, response);
				
			}
		}
		
	}
