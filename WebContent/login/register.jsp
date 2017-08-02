<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register youself...</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
	var pas = function() {
		var ok = true;
		var pas = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
		if (document.getElementById("p").value.match(pas)) {
			document.getElementById("p").style.borderColor = "green";
			document.getElementById('m4').style.color = 'green';
			document.getElementById('m4').innerHTML = '&#10004';
			ok=false;
		} else {
			document.getElementById('m4').style.color = 'red';
			document.getElementById('m4').innerHTML = '&#10008';
			document.getElementById("p").style.borderColor = "#E34234";

		}
		return ok;
	}

	var names = function() {
		var regex = /^[a-zA-Z ]{2,20}$/;
	
		if (regex.test(document.getElementById('n').value)) {
			document.getElementById('n').style.borderColor = "green";
			document.getElementById('m5').style.color = 'green';
			document.getElementById('m5').innerHTML = '&#10004';
			
		} else {
			document.getElementById('m5').style.color = 'red';
			document.getElementById('m5').innerHTML = '&#10008';
			document.getElementById('n').style.borderColor = "#E34234";
		}
		
	}

	var des = function() {
		var regex = /^[a-zA-Z ]{2,20}$/;
		var ok = true;
		if (regex.test(document.getElementById('dg').value)) {
			document.getElementById('dg').style.borderColor = "green";
			document.getElementById('m6').style.color = 'green';
			document.getElementById('m6').innerHTML = '&#10004';
			ok = false;
		} else {
			document.getElementById('m6').style.color = 'red';
			document.getElementById('m6').innerHTML = '&#10008';
			document.getElementById('dg').style.borderColor = "#E34234";
			return ok;
		}
	}

/*	var username = function() {

		// Connect to the DB
		$con = mysqli_connect('localhost', 'root', 'root', 'publication');
		$sql = "SELECT username FROM login";
		$result = mysqli_query($con, $sql);

		if ($result != document.getElementById('u').value) {
			document.getElementById('m7').style.color = 'green';
			document.getElementById('m7').innerHTML = '&#10004';
			document.getElementById("u").style.borderColor = "green";
		} else {
			document.getElementById('m7').style.color = 'red';
			document.getElementById('m7').innerHTML = '&#10008';
			document.getElementById("u").style.borderColor = "#E34234";
		}
	}
*/
	var check = function() {
		var ok = true;
		if (document.getElementById('p').value == document.getElementById('cp').value) {
			document.getElementById('m1').style.color = 'green';
			document.getElementById('m1').innerHTML = '&#10004';
			document.getElementById("cp").style.borderColor = "green";
			ok = false;
		} else {
			document.getElementById('m1').style.color = 'red';
			document.getElementById('m1').innerHTML = '&#10008';
			document.getElementById("cp").style.borderColor = "#E34234";

		}
		return ok;
	}

	var phone = function() {
		var no = /^\d{10}$/;
		if (document.getElementById('c').value.match(no)) {
			document.getElementById('c').style.borderColor = "green";
			document.getElementById('m2').style.color = 'green';
			document.getElementById('m2').innerHTML = '&#10004';
		} else {
			document.getElementById('m2').style.color = 'red';
			document.getElementById('m2').innerHTML = '&#10008';
			document.getElementById("c").style.borderColor = "#E34234";

		}
	}

	var email = function() {
		var em = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
		if (document.getElementById('e').value.match(em)) {
			document.getElementById('m3').style.color = 'green';
			document.getElementById('e').style.borderColor = "green";
			document.getElementById('m3').innerHTML = '&#10004';
		} else {
			document.getElementById('m3').style.color = 'red';
			document.getElementById('m3').innerHTML = '&#10008';
			document.getElementById("e").style.borderColor = "#E34234";

		}
	}
	
	var inputs = document.querySelectorAll('#form input');

	var validateForm = function() {

		if (!pas()) {
			return false;
		}

		if (!names()) {
			return false;
		}

		if (!des()) {
			return false;
		}

		if (!check()) {
			return false;
		}

		if (!phone()) {
			return false;
		}

		if (!email()) {
			return false;
		}

		return true;
	}
	
	
	for ( var i = 0, len = inputs.length; i < len; i++ )
	{
	  var checkValid = function() {
	    document.getElementById('submit').disabled = !validateForm();
	    
	    //Is the same as:
	    /*if ( !validateForm() )
	    {
	      document.getElementById('submitButton').disabled = true;
	    }
	    else
	    {
	      document.getElementById('submitButton').disabled = false;
	    }*/
	  }
	  
	  inputs[i].addEventListener('change', checkValid);
	  inputs[i].addEventListener('keyup', checkValid);
	}
</script>
</head>
<style>
.boxalign2 {
	width: 400px;
}

input.rounded2 {
	border: 1px solid #ccc;
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	border-radius: 10px;
	-moz-box-shadow: 2px 2px 3px #666;
	-webkit-box-shadow: 2px 2px 3px #666;
	box-shadow: 2px 2px 3px #666;
	font-size: 16px;
	padding: 2px 5px;
	outline: 0;
	-webkit-appearance: none;
	display: inline-block;
	width: 210px;
	text-align: right;
}


body{
background-image : url("../images/ncu.jpg");
background-repeat: no-repeat;
background-size : 1600px 1300px;
}

label {
	text-align: right;
	padding-right: 20px;
	display: inline-block;
	min-width: 150px;
}

span {
	font-size: 20px;
}

span.glyphicon.glyphicon-user {
	font-size: 30px;
}

form {
	margin-left: 33%;
}

.bton {
	margin-left: 40%;

}

input {
	text-align: center;
}

.bton {
	text-align: center;
}

p.change_link {
	margin-left : 28%;
}
</style>
<body>
	<br>
	
	<div class="container">
		<h1 class="text-center">
			&nbsp&nbsp<span class="glyphicon glyphicon-user"></span> Sign Up
		</h1>
		<br>
		<br>
		<form style="width: 300px" method="POST" action="../register">

			<div id="boxalign2" class="boxalign2">

				<label>Name :</label><input class="rounded2" type="text"
					placeholder="Your name" name="nam" autocomplete='off' id='n'
					onkeyup='names();' required /> <span id='m5'></span> 
				<br> <label>Designation :</label><input class="rounded2"
					placeholder="Your designation" name="desg" type="text"
					autocomplete='off' id='dg' onkeyup='des();' required /> <span
					id='m6'></span> 
				<br> <label>Email Address :</label><input class="rounded2"
					id='e' name="em" type="email"
					placeholder="eg. mysupermail@mail.com" autocomplete='off'
					onkeyup='email();' required /> <span id='m3'></span>
				<br> <label>Contact No. :</label><input class="rounded2"
					required type="tel" id='c' placeholder="eg. 9876543210" name="cont"
					autocomplete='off' onkeyup='phone();' /> <span id='m2'></span>
				<br> <label>D.O.B. :</label><input class="rounded2" name="date"
					type="date" id='d' required /> 
				<br> <label>Username :</label><input class="rounded2" id='u'
					name="user" type="text" placeholder="eg. mysuperusername690"
					autocomplete='off' required /> 
				<br> <label>Password :</label><input class="rounded2" id='p'
					placeholder="eg. X8df!90EO" name="pass" type="password"
					autocomplete='off' onkeyup='pas();' required /> <span id='m4'></span>
				<br> <label>Confirm Password :</label><input class="rounded2"
					id='cp' name="cps" type="password" placeholder="eg. X8df!90EO"
					autocomplete='off' onkeyup='check();' required /> <span id='m1'></span>
				<br>
			</div>
<br>
			<div class="bton">
				<br>
				<button id="submit" type="submit" class="btn btn-primary"  value="submit">Sign
					up</button>
			
				<br><br>
			</div>
	
<br>
			<p class="change_link">  
			Already a member ?
			<a href="../login.jsp" class="to_register"> Go and log in </a>
			</p>
		</form>
	</div>

</body>
</html>