<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.commons.net.ntp.TimeInfo"%>
<%@page import="org.apache.commons.net.ntp.NTPUDPClient"%>
<%@page import="java.util.Date"%>
<%@page import="java.net.InetAddress"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in page...</title>  
  <meta charset="utf-8">  
  <meta name="viewport" content="width=device-width, initial-scale=1">  
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
</head>
<style>
body{
background-image : url("images/ncu.jpg");
background-repeat: no-repeat;
}
form{
margin-left : 37.5%;
margin-right : 37.5%;
width : 25%;
}
input{
text-align:center;
}
.bton{
text-align:center;
}
</style>
<body bgcolor="#E6E6FA">
<%
String TIME_SERVER = "time-a.nist.gov";
NTPUDPClient timeClient = new NTPUDPClient();
InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
TimeInfo timeInfo = timeClient.getTime(inetAddress);
long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
//out.println(returnTime);
//	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
Date time = new Date(returnTime);
String ipAddress = request.getHeader("X-FORWARDED-FOR");
//out.println(ipAddress);
if (ipAddress == null) {
    ipAddress = request.getRemoteAddr();
}

%>
<br><br><br>
<div class="container"> 
<h1 class = "text-center"><span class="glyphicon glyphicon-log-in"></span> LOGIN</h1>
<form style="width:300px" method="POST" action="login">  
<br><br>
 <div class="form-group">  
    <label for="user">Username </label>  
    <input type="text" class="form-control" name="user" placeholder="Enter your username" required>  
  </div>  
  <br>
  <div class="form-group">  
    <label for="Password">Password </label>  
    <input type="password" class="form-control" name="pas" placeholder="Enter your password" required>  
  </div>  
<input type='hidden' value='<%=ipAddress%>' name='ip' >
  <div class="bton"> <br> 
  <button type="submit" class="btn btn-primary btn-lg">Sign in</button>  
</div>
<br><center>
<a href="login/Forgot_Password.jsp" class="forgot">Forgotten your username or password?</a>
<br><br>
<p class="change_link">
					Not signed up yet ?
					<a href="login/register.jsp" class="to_register">Create an Account</a>
				</p></center>
</form>  
 </div>
</body>
</html>