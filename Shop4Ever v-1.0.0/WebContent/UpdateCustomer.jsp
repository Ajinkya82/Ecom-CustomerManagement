<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Customer Management</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    function checkForm()
    {
    var dateString = document.getElementById('date').value;
    var myDate = new Date(dateString);
    var today = new Date();
         if (document.getElementById('fname').value == "")
          { 
          //something is wrong
          alert('REQUIRED FIELD ERROR: Please enter First Name in field!');
          return false;
          }
          if (document.getElementById('lname').value == "")
          { 
          //something is wrong
          alert('REQUIRED FIELD ERROR: Please enter Last Name in field!');
          return false;
          }
         if (document.getElementById('date').value == "")
          { 
          //something is wrong
          alert('REQUIRED FIELD ERROR: Please enter date in field!');
          return false;
          }
          else if (myDate>today)
          { 
          //something else is wrong
          //document.getElementById('date').after('<p>CANT</p>');
            alert('You cannot enter a date of Birth in the future!');
            return false;
          }
          if (document.getElementById('comment1').value == "")
          { 
          //something is wrong
          alert('REQUIRED FIELD ERROR: Please enter Permanent Adress');
          return false;
          }
          if (document.getElementById('comment2').value == "")
          { 
          //something is wrong
          alert('REQUIRED FIELD ERROR: Please enter Current Address');
          return false;
          }
          if (document.getElementById('email').value == "")
          { 
          //something is wrong
          alert('REQUIRED FIELD ERROR: Please enter Email');
          return false;
          }
          else
          {
            var x = document.getElementById("email").value;
            var atpos = x.indexOf("@");
            var dotpos = x.lastIndexOf(".");
            if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
            alert('Invalid Email Address');
            return false;
            }
          }
          if (document.getElementById('mobile').value == "")
          { 
          //something is wrong
          alert('REQUIRED FIELD ERROR: Please enter Mobile Number');
          return false;
          }
          if (document.getElementById('landline').value == "")
          { 
          //something is wrong
          alert('REQUIRED FIELD ERROR: Please enter Landline Number');
          return false;
          }
          // if script gets this far through all of your fields
          // without problems, it's ok and you can submit the form
          return true;
    }
</script>

</head>
<body>


<div class="container">
  <div class="row">
    <div class="form_main">
      <h1 class="heading">Customer Management</h1>
      <div class="form">
      <form action="UpdateCustomerController" method="POST" id="contactFrm" name="contactFrm" onsubmit="return checkForm()">
          <label for="id">Enter customer ID you wish to update</label> 
          <input id="id" class="form-control" type="text" name="id" maxlength="10">
      	  <label for="fname">First Name</label> 
          <input id="fname" class="form-control" type="text" name="firstName" maxlength="30">
          <label for="mname">Middle Name</label> 
          <input id="mname" class="form-control" type="text"  name="middleName" maxlength="30">
          <label for="lname">Last Name</label> 
          <input id="lname" class="form-control" type="text" name="lastName" maxlength="30">


          <div class="form-group">
              <label class="control-label" for="">Date Of Birth:</label>
                <div class='date' id='datetimepicker1'>
                    <input type='date' id="date" class="form-control" name="date" />
                </div>
            </div>

          <br>
          <div class="form-group">
            <p><label>Gender</label></p>
            <label><input class="form-check-input" name="gender" value="Male" type="radio"><span>  Male</span></label>
            <label><input class="form-check-input" name="gender" value="Female" type="radio"><span>  Female</span></label>
          </div>

          <div class="form-group">
  			<label for="comment">Permanent Address:</label>
  			<textarea class="form-control" rows="5" id="comment1" name="permanentAddress"></textarea>
		  </div>

		  <div class="form-group">
  			<label for="comment">Present Address:</label>
  			<textarea class="form-control" rows="5" id="comment2" name="presentAddress"></textarea>
		  </div>

          <div class="form-group">
  			<label for="Email">Email:</label>
  			<input type="email" class="form-control" id="email" name="email">
		</div>

		<div class="form-group">
			<h3>Contact Info</h3>
  			<label for="phone">Mobile:</label>
  			<input type="text" name="number" class="form-control" id="mobile"  pattern="\d{10}" title="Please Enter 10 digit Mobile Number">
		</div>


          <br>
          <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
            </div>
  </div>
</div>

</body>
</html>
