<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
<%@ page import="com.bean.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


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

<%
List<Employee> employeeDetails = (List<Employee>)request.getAttribute("employeeDetails");
%>

<% if(employeeDetails.size()==0){ %>
		No records Found
		
	<%} else {%>
	<table border="1">
			<tr>
			<th>First Name</th>
			<th>Middle Name</th>
			<th>Last Name</th>
			<th>Role</th>
			<th>Type</th>
			<th>Salary</th>
			<th>Date</th>
			<th>City</th>
			<th>Status</th>
			<th>Id</th>
			</tr>
	<% for(Employee employee : employeeDetails) {%>
			<tr>
			<td><%=employee.getFirstName() %></td>
			<td><%=employee.getMiddleName() %></td>
			<td><%=employee.getLastName() %></td>
			<td><%=employee.getRole() %></td>
			<td><%=employee.getType() %></td>
			<td><%=employee.getSalary() %></td>
			<td><%=employee.getDate() %></td>
			<td><%=employee.getCity()%></td>
			<td><%=employee.getStatus() %></td>
			<td><%=employee.getId() %></td>
			</tr>		
	<%} %>
	</table>
	<%} %>
	
	<br>
	<br>

</body>
</html>