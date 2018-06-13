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
<form name="submitForm" method="POST" action="EmpViewController">
    <input type="hidden" name="id" value="<%=request.getAttribute("id")%>">
    <input type="submit" value="Request Transfer" >
</form>
<br>
 <a href="ShowStatusController"><button class="btn">View Transfer Status</button></a>
 <br>
 <br>
 <a href="Homepage.jsp"><button class="btn">Log Out</button></a>
 <br>
</body>
</html>