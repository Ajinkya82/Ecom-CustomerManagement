<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success!</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <style type="text/css">
  	body{ background-color: #485268; }
  	h2 {color: white;font-weight:bold; text-align:center;}
  	p {color: white;text-align: center;font-size: 20px;}
  	.icon {font-size:150px;position:relative;left:50%; transform: translate(-50%,0%);}
  </style>
</head>
<body>
	<br><br><br><br>
<p class="glyphicon glyphicon-ok-sign icon" style="color:#32ff47;"></p>
<h2>Congratulations!</h2>
<p>Your Id is: <%String Id =(String)request.getAttribute("Id");%> <%=Id %></p>
<p>And your password is: <%String Pw = (String)request.getAttribute("Pw");%><%=Pw %></p>
<p>Registration is performed successfully </p> 
 <p><%System.out.println(""); %> </p>
</body>
</html>