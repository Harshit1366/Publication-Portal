<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
    <%@page import="com.user.ConnectionFactory"%>
    <%@page import="com.admin.pcn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
<title>User Dashboard</title>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
<nav class="navbar navbar-inverse navbar-fixed-top">  
  <div class="container-fluid">  
    <div class="navbar-header">  
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">  
          <span class="icon-bar"></span>  
          <span class="icon-bar"></span>  
          <span class="icon-bar"></span>                          
      </button>  
      <a class="navbar-brand" href="user_dashboard.jsp"><%
              String name = null;
              HttpSession sess=request.getSession(false);  
              if(sess!=null){  
              name=(String)sess.getAttribute("name");  
              out.print(name);
              }
               %></a>  
    </div>  
    <div>  
      <div class="collapse navbar-collapse" id="myNavbar">  
        <ul class="nav navbar-nav">  
          <li><a href="user_profile.jsp">PROFILE</a></li>  
          <li><a href="publications.jsp">PUBLICATIONS</a></li>  
          <li><a href="select.jsp">UPLOAD PUBLICATION DETAILS</a></li>  
        </ul>  
			<ul class="nav navbar-nav navbar-right">  
      <li><a href="../logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>  
    </ul>  
          
      </div>  
    </div>  
  </div>  
</nav>     
<br><br><br>&nbsp&nbsp&nbsp&nbsp
<%
Connection connection=null;

try{
	connection = ConnectionFactory.getConnection();
	PreparedStatement ps=connection.prepareStatement("select pcn,title_paper from journal where username=? and pcn is not null");
	ps.setString(1, name);
	ResultSet rs=ps.executeQuery();
	
	
	if(rs.next()){
		String pcn=rs.getString(1);
		String title=rs.getString(2);
		//out.println(pcn + " " + title);
	
			out.println("<script type=\"text/javascript\">");
			out.println("alert('PCN GENERATED');");
			out.println("</script>");
			//out.close();
	}
}catch(Exception e){
	
}

//out.println("<script type=\"text/javascript\">");
//out.println("alert('NOTHING GENERATED');");
//out.println("</script>");
//out.close();

%>

<%out.print("Hello, "+name+". Welcome to your Profile");   %>
</body>
</html>