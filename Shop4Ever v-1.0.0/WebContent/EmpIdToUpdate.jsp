<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="EmpUpdateValidityController">
    <input type="hidden" name="headrole" value="<%=request.getParameter("headrole")%>" >
    <br>
    Enter employee ID you wish to update<br>
    <input type="text" name="id">
    <br>
    <br>
    <input type="submit" value="Update Employee Details">
</form>
</body>
</html>