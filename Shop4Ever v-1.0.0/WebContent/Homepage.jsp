<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
  <title>Welcome to Shop4Ever</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


</head>

<style>

.maindiv{height:100vh;background-image:url(hdr.jpg);background-size: cover;}
.conti {color:white;text-align:center;position:relative;top: 50%;left: 50%;transform: translate(-50%, -50%);}
.tit {font-size:100px;font-weight:bold;}
.subtit{font-size: 25px;}
.butt {background-color:#142033;color:white;border:1px solid white;padding:10px 10px;width:100px;color:white;}
.butt:hover {background-color:white;color:#485268;}
.butt:hover .bt {text-decoration:none;color:#142033;}
.bt {text-decoration:none;color:white;}

.empdiv{position:fixed;right:5%;top:0;}
.emp{background-color: #7b7e84;}

</style>

<body>

<header>
        <div class="maindiv col-xs-12">
            <div class="conti">
                <p class="tit">Shop4Ever</p>
                <p class="subtit">It's Nice To Meet You</p>
                <a class="bt" href="login.jsp"><button class="butt">Login</button></a>
                <a class="bt" href="customer.jsp"><button class="butt">Register</button></a>
            </div>

            <div class="empdiv">
              <a class="bt" href="employee.jsp"><button class="butt emp">Register As Employee</button></a>
            </div>
        </div>
    </header>

</body>
</html>