package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class forgot_password
 */
@WebServlet("/forgot_password")
public class forgot_password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgot_password() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 PrintWriter out = response.getWriter();
		 String user=request.getParameter("username");
	        if (request.getSession(false).getAttribute("session_id") != null) {
	            out.println("<script type=\"text/javascript\">");
	            out.println("alert('Old Session exists. Log Out from current session and try again.');");
	            out.println("location='login/Forgot_Password.jsp';");
	            out.println("</script>");
	            out.close();
	            return;
	        }

	        if (request.getParameter("username") == null) {
	            out.println("<script type=\"text/javascript\">");
	            out.println("alert('Enter the username');");
	            out.println("location='login/Forgot_Password.jsp';");
	            out.println("</script>");
	            out.close();
	            return;
	        }
	        
	        Connection connection = null;
	        PreparedStatement stmt = null;
	        String session_id=null;
	        ResultSet rs=null;
	        try {
	            connection = ConnectionFactory.getConnection();
	            stmt = connection.prepareStatement("select email_id from register where username=?");
	            stmt.setString(1, user);
	            rs=stmt.executeQuery();
	            
	            if(rs.next()){
	            	
	            	 try {
	     	            connection = ConnectionFactory.getConnection();
	     	           HttpSession sess = request.getSession(false);
	   				   session_id = UUID.randomUUID().toString().replaceAll("-", "");
	   				   sess.setMaxInactiveInterval(60);
	   				   sess.setAttribute("s_id", session_id);
	     	            stmt = connection.prepareStatement("insert into forgot(username,session_id) values(?,?)");
	     	            stmt.setString(1, user);
	     	            stmt.setString(2, session_id);
	     	            stmt.executeUpdate();
	            	 }catch (Exception e) {
	     				e.printStackTrace();
	     			} 
	            	
	            	out.println("<script type=\"text/javascript\">");
	 	            out.println("alert('Password Reset Link sent to your registered email.');");
	 	            out.println("location='login.jsp';");
	 	            out.println("</script>");
	 	            String email=rs.getString(1);

	 	          String url = "http://localhost:7348/publication_portal/user/reset_password.jsp?token=" + session_id;
	 	          String message = "Forgot Password? \n Here is a link to reset your password: " + url + " \nIf password is not requested by you, please contact administrator.";
	 	          String subject = "Requested to change password!";
	 	          try {
	 	             
	 	              EmailService.sendMessage(email, message, "ADMIN OFFICE", subject);
	 	              
	 	              out.println("<script type=\"text/javascript\">");
	 	              out.println("alert('Password Reset Link sent to your registered email.');");
	 	              out.println("location='login.jsp';");
	 	              out.println("</script>");
	 	             return;
	 	             // out.close();
	 	          } catch (Exception e) {
	 	              e.printStackTrace();
	 	          } finally {
	 	              ConnectionFactory.close(connection);
	 	          }    
	 	            
	 	            
	            }
	            else{
	            	out.println("<script type=\"text/javascript\">");
	 	            out.println("alert('No such account found!');");
	 	            out.println("location='login/Forgot_Password.jsp';");
	 	            out.println("</script>");
	            }

	            //out.close();
	        }catch (Exception e) {
				e.printStackTrace();
			} finally {
				out.close(); 
	          }    

	}

}
