<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


</head>
<body>


<div class="container">
  <div class="row">
    <div class="form_main">
      <h1 class="heading">Transfer Request Management</h1>
      <div class="form">
      <form action="Transfer" method="post" id="contactFrm" name="contactFrm">
       
       <div class="form-group">
            <label for="CurrCity">Current City:</label> 
            <input id="CurrCity" class="form-control" type="text" name="id" value="<%=request.getAttribute("id") %>" >
          </div>
       
          <div class="form-group">
            <label for="CurrCity">Current City:</label> 
            <input id="CurrCity" class="form-control" type="text" name="currentCity" value="<%=request.getAttribute("city") %>" >
          </div>
           
        <div class="form-group">
          <label for="sel1">Preferred City:</label>          
          <select class="form-control" id="sel1" name="preferredCity">
            <option>NONE</option>
            <option>New Delhi</option>
            <option>Mumbai</option>
            <option>Chennai </option>
            <option>Kolkata </option>
            <option>Bangalore</option>
          </select>
        </div>


		      <div class="form-group">
  		    	<label for="comment">Reason For Transfer:</label>
  		    	<textarea class="form-control" rows="5" id="comment" name="reason"></textarea>
		      </div>

          <br>
          <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
            </div>
  </div>
</div>
<a href="ShowStatusController"></a>
<form name="submitForm" method="POST" action="ShowStatusController">
    <input type="hidden" name="id" value="<%=request.getAttribute("id")%>" >
    <input type="submit" value="View Status">
</form>
</body>
</html>