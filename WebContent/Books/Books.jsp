<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.admin.adminObjs"%>
    <%@page import="com.journal.Journal"%> 
    <%@page import="com.books.Books"%> 
     <%@page import="com.user.ConnectionFactory"%>  
    <%@page import="java.sql.*"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
  <style>
  submit{
  color : blue;
  
  }
  </style>
<title>Admin Dashboard</title>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">


<%int x=0;%>
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
          <li><a href="Books.jsp">BOOKS</a></li>  
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
        <li><a href="Books.jsp">BOOKS</a></li>  
          <li><a href="New.jsp">NEW</a></li>  
          <li><a href="Revision1.jsp">REVISION 1</a></li>  
          <li><a href="Revision2.jsp">REVISION 2</a></li>   
        </ul>  
          
      </div>  
    </div>  
  </div>  
</nav>     

                     <br><br><br><br><br><br><br>   
                     <form method="post" action="#">
                        <p align="left">&nbsp&nbspSearch : 
                        <input type="text" name="search">
                        <input type="SUBMIT" value="SEARCH"></p></form>
                        
                        <br>
                        <table class="table" border='1'>
                        
                            <thead>
                            <th>Sl No.</th>
                            <th>PCN No.</th>
                            <th>Name of Authors in the sequence as mentioned in Book</th>
                            <th>Department</th>
                            <th>Book Title</th>
                            <th>Publisher</th>
                            <th>Scope</th>
                             <th>Year</th>
                            <th>Month of Publication</th>
                            <th>Month of assigning pcn</th>
                            <th>Page No.</th>
                            <th>ISBN No.</th>
                            <th>Hyperlink</th>
                            <th>Mention if indexed in WOS/Scopus/Google Scholar/Thomson Reuter/Elsevier</th>
                            <th>Link for Indexing</th>
                            <th>Download Journal</th>
                            <th>Download Plagiarism Report</th>
                            <th>Generate PCN</th>
                            <th>Reject Application</th>
                            
                            </thead>
                            <tbody>
                              <%
                              
                            String search=request.getParameter("search");
                            	
                              if(search==null){
                            	  for(Books b : adminObjs.getAllBooks()){
                            		  x++;
                            		  %>
                            		  
  
                                  <tr>
                                      <td>
                                          <%=x%>
                                                    
                                      </td>
                                      
                                      <td>
                                          <%if(b.getPcn()==null){
                                        	  out.print("Not Assigned");
                                          } else{
                                        	  out.print(b.getPcn());
                                          }%>
                                          
                                      </td>
                                      
                                      <td>
                                          <%=b.getName()%>
                                      </td>
                                      <td>
                                          <%=b.getDept()%>
                                      </td>
                                      <td>
                                          <%=b.getTitle()%>
                                      </td>
                                      <td>
                                          <%=b.getPublisher()%>
                                      </td> 
                                      <td>
                                          <%=b.getScope()%>
                                      </td>   
                                      <td>
                                          <%=b.getYear()%>
                                      </td>
                                      <td>
                                          <%=b.getMonth_pub()%>
                                      </td>
                                      <td>
                                          <%if(b.getMonth_pcn()==null){
                                        	  out.print("Not Assigned");
                                          } else{
                                        	  out.print(b.getMonth_pcn());
                                          }%>
                                      </td>
                                      <td>
                                         <%=b.getPages()%>
                                      </td>
                                      <td>
                                          <%=b.getIsbn_no()%>
                                      </td>
                                       <td>
                                          <a href='<%=b.getHyperlink()%>'>Click here</a> 
                                      </td>
                                      <td>
                                          <%=b.getP_index()%>
                                      </td> 
                                      <td>
                                          <%=b.getLink_index()%>
                                      </td>   
                                    <td>
                                          <a href='../DownloadServlet?id=<%=b.getId()%>&type=books'>Download</a>  
                                      </td>
                                      
                                      <td> 
                                          <a href='../Downloads?id=<%=b.getId()%>&type=books'>Download</a>  
                                      </td>
                                    
                                      
                                       <td>
                                       <%
                                       if(b.getStatus()!=null){
                                    	   if(b.getStatus().equals("rejected")){
                                           	   out.print("Rejected Application");
                                              }
                                               else if(b.getStatus().equals("accepted")){
                                             	  out.print("Already generated");
                                               } 
                                       }
                                       
                                       else{%>
                                    	   <a href='../pcn?year=<%=b.getYear()%>&dept=<%=b.getDept()%>&id=<%=b.getId() %>&type=books' onClick="return confirm('Are you sure you want to generate pcn for this publication?');" >Generate PCN</a>
                                      <%} 
                                       %>
                                     
                                      </td> 
                                      
                                      <td>  
                                      <%
                                      if(b.getStatus()!=null){
                                    	  if(b.getStatus().equals("rejected")){
                                         	   out.print("Rejected Application");
                                            }
                                   	  else if(b.getStatus().equals("accepted")){
                                       	  out.print("Already approved");
                                         }
                                      }
                                    	 
                                    	  else{
                                      %>
                                          <a href='reject.jsp?id=<%=b.getId()%>&type=books' onClick="return confirm('Are you sure you want to reject this application ?');">Reject</a> 
                                          <% }
                                      
                                      
                                       %> 
                                      </td>
                                      
                                     
                                        
                                  </tr> 
                                  <%}}
                              
                              else{
                            	 
                            	  for(Books b : adminObjs.getBooksSearch(search)){
                            		  x++;%>
                                   <tr>
                                      <td>
                                          <%=x%>
                                                    
                                      </td>
                                      
                                      <td>
                                          <%if(b.getPcn()==null){
                                        	  out.print("Not Assigned");
                                          } else{
                                        	  out.print(b.getPcn());
                                          }%>
                                          
                                      </td>
                                      
                                      <td>
                                          <%=b.getName()%>
                                      </td>
                                      <td>
                                          <%=b.getDept()%>
                                      </td>
                                      <td>
                                          <%=b.getTitle()%>
                                      </td>
                                      <td>
                                          <%=b.getPublisher()%>
                                      </td> 
                                      <td>
                                          <%=b.getScope()%>
                                      </td>   
                                      <td>
                                          <%=b.getYear()%>
                                      </td>
                                      <td>
                                          <%=b.getMonth_pub()%>
                                      </td>
                                      <td>
                                          <%if(b.getMonth_pcn()==null){
                                        	  out.print("Not Assigned");
                                          } else{
                                        	  out.print(b.getMonth_pcn());
                                          }%>
                                      </td>
                                      <td>
                                         <%=b.getPages()%>
                                      </td>
                                      <td>
                                          <%=b.getIsbn_no()%>
                                      </td>
                                       <td>
                                          <a href='<%=b.getHyperlink()%>'>Click here</a> 
                                      </td>
                                      <td>
                                          <%=b.getP_index()%>
                                      </td> 
                                      <td>
                                          <%=b.getLink_index()%>
                                      </td>   
                                    <td>
                                          <a href='../DownloadServlet?id=<%=b.getId()%>&type=books'>Download</a>  
                                      </td>
                                      
                                      <td> 
                                          <a href='../Downloads?id=<%=b.getId()%>&type=books'>Download</a>  
                                      </td>
                                    
                                      
                                       <td>
                                       <%
                                       if(b.getStatus()!=null){
                                    	   if(b.getStatus().equals("rejected")){
                                           	   out.print("Rejected Application");
                                              }
                                               else if(b.getStatus().equals("accepted")){
                                             	  out.print("Already generated");
                                               } 
                                       }
                                       
                                       else{%>
                                    	   <a href='../pcn?year=<%=b.getYear()%>&dept=<%=b.getDept()%>&id=<%=b.getId() %>&type=books' onClick="return confirm('Are you sure you want to generate pcn for this publication?');" >Generate PCN</a>
                                      <%} 
                                       %>
                                     
                                      </td> 
                                      
                                      <td>  
                                      <%
                                      if(b.getStatus()!=null){
                                    	  if(b.getStatus().equals("rejected")){
                                         	   out.print("Rejected Application");
                                            }
                                   	  else if(b.getStatus().equals("accepted")){
                                       	  out.print("Already approved");
                                         }
                                      }
                                    	 
                                    	  else{
                                      %>
                                          <a href='reject.jsp?id=<%=b.getId()%>&type=books' onClick="return confirm('Are you sure you want to reject this application ?');">Reject</a> 
                                          <% }
                                      
                                      
                                       %> 
                                      </td>
                                      
                                     
                                        
                                  </tr> 
                             <%}}
                              %>
                              
                              

                            </tbody>

                        </table>

</body>
</html>