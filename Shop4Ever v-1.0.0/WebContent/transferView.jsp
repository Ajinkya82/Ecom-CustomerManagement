<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
<%@ page import="com.bean.Transfer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<title>Transfer Details</title>
<meta charset="utf-8">
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

  	#thetab {border-collapse: collapse;width: 100%;table-layout: fixed; border:3px solid white;}
  	#thetab td, #thetab th {border: 1px solid white;padding: 8px;overfslow: auto;}
	#thetab tr:nth-child(even){background-color: #6b646d;}
	#thetab tr:hover {background-color: #333333;}
	#thetab th {padding-top: 12px;padding-bottom: 12px;text-align: center;background-color: #142033;color: white;}

  </style>


  <script type="text/javascript">
    function checkForm()
    {
         if (document.getElementById('empid').value == "")
          { 
          //something is wrong
          alert('REQUIRED FIELD ERROR: Please Enter ID');
          return false;
          }
          if (document.getElementById('status').value == "NONE")
          { 
          //something is wrong
          alert('REQUIRED FIELD ERROR: Please Select a status');
          return false;
          }
          else if (document.getElementById('comment').value == "" &&
          			 document.getElementById('status').value == "Reject")
          { 
          //something is wrong
          alert('REQUIRED FIELD ERROR: Please specify Reason');
          return false;
          }
          // if script gets this far through all of your fields
          // without problems, it's ok and you can submit the form
          return true;
    }

    function revealRes()
    {
    	if(document.getElementById("status").value=="Reject")
    	{	$("#res").fadeIn(500);}
    	else
    	{$("#res").fadeOut(500);}
    }
</script>


</head>
<body>
<%
List<Transfer> transferDetails = (List<Transfer>)request.getAttribute("transferDetails");
%>

<% if(transferDetails.size()==0){ %>
		No request Found
		
	<%} else {%>
	<div class="col-xs-push-1 col-xs-10">
	<table border="1" id="thetab">
			<tr>
			<th>Employee Id</th>
			<th>Current City</th>
			<th>Preferred City</th>
			<th>Reason</th>
			</tr>
	<% for(Transfer transfer : transferDetails) {%>
			<tr>
			<td><%=transfer.getId() %></td>
			<td><%=transfer.getCurrentCity() %></td>
			<td><%=transfer.getPreferredCity() %></td>
			<td><%=transfer.getReason() %></td>
			</tr>		
	<%} %>
	</table>
	<br>
	<form onsubmit="return checkForm()" method="POST" action="StatusController">

	<label for="stat">Enter ID</label>
          <input id="empid" class="form-control" type="text" name="empid"><br>

	<label for="status">Status</label>          
          <select class="form-control" id="status" name = "status" onchange="revealRes()">
            <option>NONE</option>
            <option>Approved</option>
            <option>Reject</option>
          </select><br>

    <div id="res" class="form-group" style="display:none;">
	<label for="comment">Please Specify Reason:</label>
  		    	<textarea class="form-control" rows="5" id="comment" name="reason"></textarea>
	</div>

	<br>
	<div class="butt" style="text-align: center;">
	<button type="submit" class="btn btn-primary">Submit</button>
	</div>

	</form>
	</div>
	<%} %>
	
	<br>
	<br>
 
</body>
</html>