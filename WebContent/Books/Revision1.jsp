<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.admin.adminObjs"%>
    <%@page import="com.journal.Journal"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
       
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
<title>Insert title here</title>
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
      <a class="navbar-brand" href="../admin/admin_dashboard.jsp">Admin</a>  
    </div>  
    <div>  
      <div class="collapse navbar-collapse" id="myNavbar">  
        <ul class="nav navbar-nav">  
          <li><a href="Journal.jsp">JOURNAL</a></li>  
          <li><a href="#">BOOKS</a></li>  
          <li><a href="#">BOOK CHAPTER</a></li>  
          <li><a href="#">CONF. PROCEEDINGS</a></li>  
          <li><a href="#">CONF. PRESENTATIONS</a></li>  
          <li><a href="#">PATENTS</a></li>  
          <li><a href="#">TECH REPORT</a></li>  
        </ul>  
			<ul class="nav navbar-nav navbar-right">  
      <li><a href="../admin_logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>  
    </ul>  
          
      </div>  
       <div class="collapse navbar-collapse" id="myNavbar">  
        <ul class="nav navbar-nav">  
        <li><a href="Journal.jsp">JOURNAL</a></li>  
          <li><a href="New.jsp">NEW</a></li>  
          <li><a href="Revision1.jsp">REVISION 1</a></li>  
          <li><a href="Revision2.jsp">REVISION 2</a></li>   
        </ul>  
          
      </div>  
    </div>  
  </div>  
</nav>     
                     <br><br><br><br><br><br><br>   <form method="post" action="#">
                        <p align="left">&nbsp&nbspSearch : 
                        <input type="text" name="search">
                        <input type="SUBMIT" value="SEARCH"></p></form>
                        
                        <br>
                        <table class="table" border='1'>
                        
                            <thead>
                            <th>Sl No.</th>
                            <th>PCN No.</th>
                            <th>Name of Authors</th>
                            <th>Department</th>
                            <th>Title</th>
                            <th>Journal</th>
                            <th>Scope</th>
                             <th>Year</th>
                            <th>Month of Publication</th>
                            <th>Month of assigning pcn</th>
                            <th>Volume</th>
                            <th>Issue</th>
                             <th>Pages</th>
                            <th>Impact Factor</th>
                            <th>Specify which Impact Factor</th>
                            <th>Link for Impact Factor</th>
                            <th>Paid/Unpaid</th>
                             <th>Payment done or not</th>
                            <th>Publication reported in Web of Science</th>
                            <th>Publication reported in Scopus</th>
                            <th>Publication reported in Google Scholar</th>
                            <th>Publication reported in Indian Citation Index</th>
                            <th>Download Journal</th>
                            <th>Download Plag Report</th>
                            <th>Generate PCN</th>
                            <th>Reject Application</th>
                         
                            </thead>
                            <tbody>
                              <%
                            String search=request.getParameter("search");
                            	int x=0;
                              if(search==null){
                            	  for(Journal j : adminObjs.getRev1Employees()){
                            		  x++;%>
                                  <tr>
                                      <td>
                                          <%=x%>
                                      </td>
                                      
                                      <td>
                                          <%if(j.getPcn()==null){
                                        	  out.print("Not Assigned");
                                          } else{
                                        	  out.print(j.getPcn());
                                          }%>
                                          
                                      </td>
                                      
                                      <td>
                                          <%=j.getName()%>
                                      </td>
                                      <td>
                                          <%=j.getDept()%>
                                      </td>
                                      <td>
                                          <%=j.getTitle()%>
                                      </td>
                                      <td>
                                          <%=j.getJourn()%>
                                      </td> 
                                      <td>
                                          <%=j.getScope()%>
                                      </td>   
                                      <td>
                                          <%=j.getYear()%>
                                      </td>
                                      <td>
                                          <%=j.getMonth_pub()%>
                                      </td>
                                      <td>
                                          <%if(j.getMonth_pcn()==null){
                                        	  out.print("Not Assigned");
                                          } else{
                                        	  out.print(j.getMonth_pcn());
                                          }%>
                                      </td>
                                      <td>
                                          <%=j.getVol()%>
                                      </td> 
                                      <td>
                                          <%=j.getIssue()%>
                                      </td>   
                                      <td>
                                          <%=j.getPages()%>
                                      </td>
                                      <td>
                                          <%=j.getIfs()%>
                                      </td>
                                      <td>
                                          <%=j.getSwif()%>
                                      </td>
                                      <td>
                                          <%=j.getLfif()%>
                                      </td> 
                                      <td>
                                          <%=j.getPay()%>
                                      </td>   
                                      <td>
                                          <%=j.getPdon()%>
                                      </td>
                                      <td>
                                          <%=j.getPw()%>
                                      </td>
                                      <td>
                                          <%=j.getPs()%>
                                      </td>
                                      <td>
                                          <%=j.getPg()%>
                                      </td> 
                                      <td>
                                          <%=j.getPi()%>
                                      </td>   
                                    <td>
                                          <a href='../DownloadServlet?id=<%=j.getId()%>'>Download</a>  
                                      </td>
                                      
                                      <td> 
                                          <a href='../Downloads?id=<%=j.getId()%>'>Download</a>  
                                      </td>
                                    
                                      
                                      <td>
                                       <%
                                       if(j.getStatus()!=null){
                                    	   if(j.getStatus().equals("rejected")){
                                           	   out.print("Rejected Application");
                                              }
                                               else if(j.getStatus().equals("accepted")){
                                             	  out.print("Already generated");
                                               } 
                                       }
                                       
                                       else{%>
                                    	   <a href='../pcn?year=<%=j.getYear()%>&dept=<%=j.getDept()%>&id=<%=j.getId()%>' onClick="return confirm('Are you sure you want to generate pcn for this publication?');" >Generate PCN</a>
                                      <%} 
                                       %>
                                     
                                      </td> 
                                      
                                      <td>  
                                      <%
                                      if(j.getStatus()!=null){
                                    	  if(j.getStatus().equals("rejected")){
                                         	   out.print("Rejected Application");
                                            }
                                   	  else if(j.getStatus().equals("accepted")){
                                       	  out.print("Already approved");
                                         }
                                      }
                                    	 
                                    	  else{
                                      %>
                                          <a href='reject.jsp?id=<%=j.getId()%>' onClick="return confirm('Are you sure you want to reject this application ?');">Reject</a> 
                                          <% }
                                      
                                      
                                       %> 
                                      </td>
                                
                                  </tr> 
                                  <%}
                              }
                              else{
                            	  //String search=request.getParameter("search");
                            	  for(Journal j : adminObjs.getRev1Search(search)){
                            		  x++;%>
                                  <tr>
                                   <td>
                                          <%=x%>
                                      </td>
                                      
                                       <td>
                                             <%if(j.getPcn()==null){
                                        	  %>Not Assigned<%                                           }
                                          else{
                                        	  out.print(j.getPcn());
                                        	  }%>
                                      </td>
                                      <td>
                                          <%=j.getName()%>
                                      </td>
                                      <td>
                                          <%=j.getDept()%>
                                      </td>
                                      <td>
                                          <%=j.getTitle()%>
                                      </td>
                                      <td>
                                          <%=j.getJourn()%>
                                      </td> 
                                      <td>
                                          <%=j.getScope()%>
                                      </td>   
                                      <td>
                                          <%=j.getYear()%>
                                      </td>
                                      <td>
                                          <%=j.getMonth_pub()%>
                                      </td>
                                      <td>
                                          <%if(j.getMonth_pcn()==null){
                                        	  out.print("Not Assigned");
                                          } else{
                                        	  out.print(j.getMonth_pcn());
                                          }%>
                                      </td>
                                      <td>
                                          <%=j.getVol()%>
                                      </td> 
                                      <td>
                                          <%=j.getIssue()%>
                                      </td>   
                                      <td>
                                          <%=j.getPages()%>
                                      </td>
                                      <td>
                                          <%=j.getIfs()%>
                                      </td>
                                      <td>
                                          <%=j.getSwif()%>
                                      </td>
                                      <td>
                                          <%=j.getLfif()%>
                                      </td> 
                                      <td>
                                          <%=j.getPay()%>
                                      </td>   
                                      <td>
                                          <%=j.getPdon()%>
                                      </td>
                                      <td>
                                          <%=j.getPw()%>
                                      </td>
                                      <td>
                                          <%=j.getPs()%>
                                      </td>
                                      <td>
                                          <%=j.getPg()%>
                                      </td> 
                                      <td>
                                          <%=j.getPi()%>
                                      </td>   
                                    <td>
                                          <a href='../DownloadServlet?id=<%=j.getId()%>'>download</a>  
                                      </td>
                                      
                                        <td> 
                                          <a href='../DownloadServlet?id=<%=j.getId()%>'>Download</a>  
                                      </td>
                                     <td>
                                       <%
                                       if(j.getStatus()!=null){
                                    	   if(j.getStatus().equals("rejected")){
                                           	   out.print("Rejected Application");
                                              }
                                               else if(j.getStatus().equals("accepted")){
                                             	  out.print("Already generated");
                                               } 
                                       }
                                       
                                       else{%>
                                    	   <a href='../pcn?year=<%=j.getYear()%>&dept=<%=j.getDept()%>&id=<%=j.getId()%>' onClick="return confirm('Are you sure you want to generate pcn for this publication?');" >Generate PCN</a>
                                      <%} 
                                       %>
                                     
                                      </td> 
                                      
                                      <td>  
                                      <%
                                      if(j.getStatus()!=null){
                                    	  if(j.getStatus().equals("rejected")){
                                         	   out.print("Rejected Application");
                                            }
                                   	  else if(j.getStatus().equals("accepted")){
                                       	  out.print("Already approved");
                                         }
                                      }
                                    	 
                                    	  else{
                                      %>
                                          <a href='reject.jsp?id=<%=j.getId()%>' onClick="return confirm('Are you sure you want to reject this application ?');">Reject</a> 
                                          <% }
                                      
                                      
                                       %> 
                                      </td>
                                
                                  </tr> 
                             <% } }
                              %>
                              
                              

                            </tbody>

                        </table>


</body>
</html>