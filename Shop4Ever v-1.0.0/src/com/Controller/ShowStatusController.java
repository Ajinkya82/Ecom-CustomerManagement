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


@WebServlet("/ShowStatusController")
public class ShowStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ShowStatusController() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");//System.out.println(id.length()+""+id);
		String s = StoreService.showStatus(id);
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("ViewStatus.jsp");
		
		if(s.equals("Not decided yet")) {
			
			out.print(s);
			rd.include(request, response);
			
		}
		else {
			String sr[] = s.split(" ");
			if(sr[0].equals("Approved"))
				out.print("Your request is been approved");
			else {
				out.print("Your request is been rejected."
						+ " Following is the reason : ");
				out.print(sr[1]);
			}
			rd.include(request, response);
		}
	}

}
