<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javax.servlet.http.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

  <style type="text/css">
  	body{ background-color: #485268; }
  	h2 {color: white;font-weight:bold; text-align:center;}
  	p {color: white;text-align: center;font-size: 15px;}
  	.icon {font-size:90px;position:relative;left:50%; transform: translate(-50%,0%);}
    .btn{background-color:#142033;color:white;border:1px solid white;}
    .btn:hover {background-color:white;color:#485268;}
    select, .input-group{margin-top:-10px;}
    .cent {position:fixed; top:50%; left:50%; transform: translate(-50%,-50%);border: 1px solid white;border-radius: 25px;padding:25px;background-color: #7b7e84}
  </style>


</head>
<body>

<div class="col-xs-push-4 col-xs-4 cent">
<p class="glyphicon glyphicon-lock icon" style="color:#ffffff;"></p>
<h2>Login </h2>
<form  method="post" action="LoginController">

<p>User name:</p>
<div class="input-group">
  <span class="input-group-addon"><i style="color:#485268;" class="glyphicon glyphicon-user"></i></span>
  <input id="usr" class="form-control" type="text" name="id">
</div><br>

<p>Password:</p>
<div class="input-group">
  <span class="input-group-addon"><i id="icon" style="color:#485268;" onclick="reveal()" class="glyphicon glyphicon-eye-open"></i></span>
  <input id="pwd" class="form-control" type="password" name="pw">
</div><br>

<p>Role:</p>
<select class="form-control" id="sel1" name="role">
    <option>NONE</option>
    <option>Managing Director</option>
    <option>Inventory Head</option>
    <option>Sales and Marketing Head</option>
    <option>Sales Executive</option>
    <option>Delivery Executive</option>
    <option>Store Keeper</option>
    
</select><br>

<div class="butt" style="text-align: center;">
<button type="submit" class="btn">Login</button>
</div>

</form>
</div>
</body>
</html>