package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
	        if (request.getSession(false).getAttribute("s_id") != null) {
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
	        ResultSet rs=null;
	        try {
	            connection = ConnectionFactory.getConnection();
	            stmt = connection.prepareStatement("select email_id from login where username=?");
	            stmt.setString(1, user);
	            rs=stmt.executeQuery();
	            
	            if(rs.next()){
	            	out.println("<script type=\"text/javascript\">");
	 	            out.println("alert('Password Reset Link sent to your registered email.');");
	 	            out.println("location='login/login.jsp';");
	 	            out.println("</script>");
	            }
	            else{
	            	out.println("<script type=\"text/javascript\">");
	 	            out.println("alert('Invalid Username!');");
	 	            out.println("location='login/Forgot_Password.jsp';");
	 	            out.println("</script>");
	            }

	            out.close();
	        }catch (Exception e) {
				e.printStackTrace();
			}

	}

}
