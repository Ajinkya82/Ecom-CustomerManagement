<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
  	body{ background-color: #485268; color:white;}
  	h2 {color: white;font-weight:bold; text-align:center;}
  	p {color: white;text-align: center;font-size: 20px;}
  	.btn{background-color:#142033;color:white;border:1px solid white;}
    .btn:hover {background-color:white;color:#485268;}

  	#thetab {border-collapse: collapse;width: 100%;table-layout: fixed;}
  	#thetab td, #customers th {border: 1px solid white;padding: 8px;overfslow: auto; font-size}
	#thetab tr:nth-child(even){background-color: #6b646d;}
	#thetab tr:hover {background-color: #333333;}
	#thetab th {padding-top: 12px;padding-bottom: 12px;text-align: center;background-color: #142033;color: white;}

  </style>

</head>
<body>
 
 <!--  <form name="submitForm" method="POST" action="CustomerViewController">
    <input type="hidden" >
    <A HREF="javascript:document.submitForm.submit()">View Customer Details</A>
</form>-->

<form name="submitForm" method="POST" action="CustomerViewController">
    <input type="submit" value="View Customer Details">
</form>
<br>


<form name="submitForm" method="POST" action="EmployeeDetailsController">
    <input type="hidden" name="role" value="Sales and Marketing Head" >
   <input type="submit" value="View Employee Details">
</form>
<br>

<form name="submitForm" method="POST" action="EmpIdToUpdate.jsp">
    <input type="hidden" name="headrole" value="Sales and Marketing Head" >
    <input type="submit" value="Update Employee Details">
</form>
<br>

 <a href="customer.jsp"> <button class="btn">Register a new customer</button></a>
 <br>
<br>
 <a href="UpdateCustomer.jsp"><button class="btn"> Update a customer</button></a>
 <br>
<br>
 <a href="DeactivateCustomer.jsp"> <button class="btn">Deactivate a customer</button></a>
 <br>
<br>
 <form name="submitForm" method="GET" action="TransferViewController">
    <input type="hidden" name="role" value="Sales and Marketing Head" >
    <input type="submit" value="View Transfer Requests">
</form>
 <br>

 <a href="DEpayment.jsp"> <button class="btn"> Generate Payment</button></a>
 <br>
 <br>
 <a href="Homepage.jsp"> <button class="btn">Log Out</button></a>
 <br>
</body>
</html>