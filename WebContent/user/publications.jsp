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
<title>Publications</title>
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
              String name = null,comment=null;
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
 <br><br><br>
                        <h3 class="text-center">Journal Publications</h3>
                    
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
                            <th>Download Plagorism Report</th>
                            <th>Edit Details</th>
                            <th>Comments</th>
                            
                         
                            </thead>
                            <tbody>
                              <%
                             
                            	int x=0;
                            		  for(Journal j : adminObjs.getUserById(name)){
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
                                      // out.print(j.getPcn()+" "+j.getRevision()+" "+j.getStatus());
                                       try{
                                    	   if(j.getStatus()!=null){
                                    		   if(j.getPcn() == null ){
                                    			   if(j.getRevision() < 2 && j.getStatus().equals("rejected")){%>
                                            	   <a href='../Journal/Edit.jsp?id=<%=j.getId()%>'>Edit</a>  
                                            	   <%out.print("\n(Publication rejected)"); 
                                               }
                                        		   else{
                                            		   out.print("Can't be edited");
                                            	   }
                                    		   }
                                    		   else{
                                    			   out.print("Approved publication");
                                    		   }
                                    		   
                                        	  // if(j.getPcn() != null && j.getRevision() <=2 && j.getStatus().equals("accepeted")){
                                            	//   out.print("Approved publication");
                                               //}
                                        	  
                                    	   }
                                    	  
                                       else{
                                    	   out.print("Can't be edited");
                                       }
                                           
                                       
                                      
                                       }catch(NullPointerException e){
                                    	   e.printStackTrace();
                                       }
                                       
                                       // else if(j.getStatus().equals("rejected") && j.getPcn() == null && j.getRevision() < 2 ){
                                   	//   out.print("Publication rejected");
                                      //}else if(j.getStatus().equals("accepeted") && j.getPcn() == null && j.getRevision() < 2 ){
                                   	 //  out.print("Approved publication");
                                      //}
                                       //else if(j.getStatus().equals("rejected")){
                                         //     out.print("\n(Publication rejected)");
                                           //}else if(j.getStatus().equals("accepted")){
                                         	 // out.print("Approved publication");
                                           //}
                                           //if(j.getRevision() >= 2){
                                        	 //  out.print("Can't be edited");
                                           //}
                                       

                                    	  %>

                                      </td> 
                                      

                                
                               
                                  <td><%if(j.getStatus().equals("rejected")){
                                    	  %>
<%//out.print(j.getComment()); %>
  <a href='#' data-toggle="modal" data-target="#myModal">Comment</a> 
  
   <%/*     
        String id1=(String)sess.getAttribute("id");  
        		 if(id1!=null){
        			 int id=Integer.valueOf(id1);
        			 out.print(id);
        		  
        		  
        		  Connection connection=null;

        		  try{
        		  	connection = ConnectionFactory.getConnection();
        		  	PreparedStatement ps=connection.prepareStatement("select comment from journal where id=?");
        		  	ps.setInt(1, id);
        		  	ResultSet rs=ps.executeQuery();
        		  	
        		  	
        		  	if(rs.next()){
        		  		comment=rs.getString(1);
        		  		out.print(comment);
        		  	}
        		  }catch(Exception e){
        		  	
        		  }
        */
        		  
        		  %> 
        		  
        		   

<%//} %>
  
    <%} 
                                      else{
                                    	  out.print("No comments");
                                      }
                                      %>
                                      
                                     </td>
    
                                      
                                                                            <%} %>
                              
                                 </tr> 

                            </tbody>

                        </table>
                        
                        <%//String com=request.getParameter(comment); %>
<!--   <div class="modal fade" id="myModal" role="dialog">             
   <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Reason for rejection of publication by Admin</h4>
        </div>
        <div class="modal-body">
          <p><%//out.print(com); %></p>

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>

 -->

 
 <br><br>
                        <h3 class="text-center">Book Publications</h3>
                    
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
                            <th>Edit Details</th>
                            <th>Comments</th>
                            
                         
                            </thead>
                            <tbody>
                              <%
                             
                            	x=0;
                            		  for(Books b : adminObjs.getBookById(name)){
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
                                    
                                       try{
                                    	   if(b.getStatus()!=null){
                                    		   if(b.getPcn() == null ){
                                    			   if(b.getRevision() < 2 && b.getStatus().equals("rejected")){%>
                                            	   <a href='../Journal/Edit.jsp?id=<%=b.getId()%>'>Edit</a>  
                                            	   <%out.print("\n(Publication rejected)"); 
                                               }
                                        		   else{
                                            		   out.print("Can't be edited");
                                            	   }
                                    		   }
                                    		   else{
                                    			   out.print("Approved publication");
                                    		   }
                                    		   
                                        	
                                    	   }
                                    	  
                                       else{
                                    	   out.print("Can't be edited");
                                       }
                                           
                                       
                                      
                                       }catch(NullPointerException e){
                                    	   e.printStackTrace();
                                       }
                                    
                                    	  %>

                                      </td> 
                                      

                                
                               
                                  <td><%
                                  
                                 if(b.getStatus() != null){
                                	 
                                     if(b.getStatus().equals("rejected")){
                                       	  %>

     <a href='#' data-toggle="modal" data-target="#myModal">Comment</a> 

     
       <%} else{
     	  out.print("No comments");
       }
                                 }
                                 else{
                                	  out.print("No comments");
                                  }
                                 
                                      
                                      %>
                                      
                                     </td>
    
                                     </tr>
                                     
                                      <%}%>
                                                                                                     
                                
                                 
                                 
                                  

                            </tbody>

                        </table>
              
</body>
</html>