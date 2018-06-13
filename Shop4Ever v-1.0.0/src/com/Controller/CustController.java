package com.Controller;

import java.io.IOException;
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
 * Servlet implementation class CustController
 */
@WebServlet("/CustController")
public class CustController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CustController() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		 String firstName = request.getParameter("firstName");
		 String middleName = request.getParameter("middleName");
		 String lastName = request.getParameter("lastName");
		 
		 Date date=null;
		 try {
			 date = f.parse(request.getParameter("date"));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		 
		 String permanentAddress = request.getParameter("permanentAddress");
		 String presentAddress = request.getParameter("presentAddress");
		 
		 String gender = request.getParameter("gender");
		 if(!gender.equals("male"))
			 gender="female";
		 

		 String email = request.getParameter("email");
		 long number = Long.parseLong(request.getParameter("number"));
		 
		 
		 
		 boolean s = false;
		 
		 String cusIdpw=StoreService.getId();
		 //System.out.println(cusIdpw);
		 String[] idpw = cusIdpw.split(" ");
		 String Id=idpw[0], Pw=idpw[1];
		 
		 Customer customer = new Customer(firstName, middleName, lastName, date, gender, permanentAddress, presentAddress, email, number, Id);
		 
		 s = StoreService.customerDetails(customer, Id, Pw);
		 
		 if(s) {
			 request.setAttribute("Id", Id);
			 request.setAttribute("Pw", Pw);
			 RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			 rd.forward(request, response);
		 }
		 else
			 response.sendRedirect("failure.jsp");
	}

}
