<!DOCTYPE html>
<html lang="en">
<head>
  <title>Employee Registration</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

    function checkform()
    {
    var dateString = document.getElementById('date').value;
    var myDate = new Date(dateString);
    var today = new Date();
    
         if (document.getElementById('fname').value == "")
          { 
          //something is wrong
          alert('REQUIRED FIELD ERROR: Please enter First Name ');
          return false;
          }
          if (document.getElementById('lname').value == "")
          { 
          //something is wrong
          alert('REQUIRED FIELD ERROR: Please enter Last Name ');
          return false;
          }
          if (document.getElementById('sel1').value == "NONE")
          { 
          //something is wrong
          alert('REQUIRED FIELD ERROR: Please Select a Role');
          return false;
          }
          if (document.getElementById("perm").checked==false &&
          		document.getElementById("cont").checked==false)
          { 
          //something is wrong
          alert('Please Choose A Contract Type.');
          return false;
          }
         if (document.getElementById('date').value == "")
          { 
          //something is wrong
          alert('REQUIRED FIELD ERROR: Please enter date in field!');
          return false;
          }
          else if (myDate<today)
          { 
          //something else is wrong
            alert('You cannot enter a date in the Past!');
            return false;
          }
          if (document.getElementById('sel2').value == "NONE")
          { 
          //something is wrong
          alert('REQUIRED FIELD ERROR: Please Select a City');
          return false;
          }
          if (document.getElementById('stat').value.toUpperCase() != "ACTIVE" &&
          		document.getElementById('stat').value.toUpperCase() != "LOCKED" &&
          		document.getElementById('stat').value.toUpperCase() != "DISABLED" )
          { 
          //something is wrong
          alert('The Status Field can have only following values: Active, Locked, Disabled ');
          return false;
          }
          // if script gets this far through all of your fields
          // without problems, it's ok and you can submit the form
          return true;
    }

    function checkPar()
    {
    	if(document.getElementById("sel1").value=="Delivery Executive")
    	{	$("#radiodiv").fadeIn(500);}
    	else
    	{$("#radiodiv").fadeOut(500); document.getElementById("perm").checked=true;}

    	if(document.getElementById("sel1").value=="Sales and Marketing Head")
    		{document.getElementById("sal").innerHTML = "30000.0";}

    	if(document.getElementById("sel1").value=="Inventory Head")
    		{document.getElementById("sal").innerHTML = "35000.0";}

    	if(document.getElementById("sel1").value=="Delivery Executive" && 
    		document.getElementById("perm").checked==true)
    		{document.getElementById("sal").innerHTML = "20000.0";}

    	if(document.getElementById("sel1").value=="Delivery Executive" && 
    		document.getElementById("cont").checked==true)
    		{document.getElementById("sal").innerHTML = "0.0";}

    	if(document.getElementById("sel1").value=="Storekeeper")
    		{document.getElementById("sal").innerHTML = "25000.0";}
    	if(document.getElementById("sel1").value=="Sales Executive")
		{document.getElementById("sal").innerHTML = "25000.0";}
    }

</script>

</head>
<body>


<div class="container">
  <div class="row">
    <div class="form_main">
      <h1 class="heading">Employee Registration</h1>
      <div class="form">
      <form onsubmit="return checkform()" method="POST" action="EmpController" id="contactFrm" name="contactFrm" >
        <label for="fname">First Name</label> 
          <input id="fname" class="form-control" type="text" name="firstName" maxlength="30">
          <label for="mname">Middle Name</label> 
          <input id="mname" class="form-control" type="text" name="middleName" maxlength="30">
          <label for="lname">Last Name</label> 
          <input id="lname" class="form-control" type="text" name="lastName" maxlength="30">
           
          <label for="sel1">Role:</label>          
          <select class="form-control" id="sel1" name="role" onchange="checkPar()">
            <option>NONE</option>
            <option>Sales and Marketing Head</option>
            <option>Inventory Head</option>
            <option>Delivery Executive</option>
            <option>Sales Executive</option>
            <option>Store keeper</option>
          </select>

          <br>
     <div id="radiodiv" style="display:none;" class="form-group" onchange="checkPar()">
       <p><label>Type</label></p>
       <label><input name="type" value="permanent" type="radio" id="perm"><span>  Permanent</span></label>
       <label><input name="type" value="contract" type="radio" id="cont"><span>  Contract</span></label>
     </div>

          <div class="form-group">
            <label class="control-label" for="fixsal">Salary</label>
            <p id="sal"></p>
          </div>



            <div class="form-group">
              <label class="control-label" for="">Joining Date:</label>
                <div class='input-group date' id='datetimepicker1'>
                    <input id="date" type='date' class="form-control" name="date">
                </div>
            </div>

          <label for="sel2">City</label>          
          <select class="form-control" id="sel2" name = "city">
            <option>NONE</option>
            <option>New Delhi</option>
            <option>Mumbai</option>
            <option>Chennai</option>
            <option>Kolkata</option>
            <option>Bangalore</option>
          </select>

          <label for="stat">Status</label>
          <input id="stat" class="form-control" type="text" value="Active" name="status" class="txt">


          <br>
          <button type="submit" class="btn btn-primary">Submit</button>
      </form>
            </div>
            </div>
  </div>
</div>

</body>
</html>
