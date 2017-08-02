package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class change_password
 */
@WebServlet("/change_password")
public class change_password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public change_password() {
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
		 Connection connection = null;
	        PreparedStatement stmt = null,stmt1=null;
	        String pass=null;
	        PrintWriter out=response.getWriter();
	        String opass = request.getParameter("op");
	        String npass = request.getParameter("np");
	        String cnpass = request.getParameter("cnp");
		String role=request.getParameter("role");
		String user = null;
        HttpSession sess=request.getSession(false);  
        if(sess!=null){  
        user=(String)sess.getAttribute("name");  
        }
		
		
		if(role.equals("user")){

		            if (opass.equals("") || npass.equals("") || cnpass.equals("")) {
		                throw new NullPointerException();
		            }
		            if (!npass.equals(cnpass)) {
		                out.println("<script type=\"text/javascript\">");
		                out.println("alert('New Passwords do not match. Please confirm your new password');");
		                out.println("location='user/Change_Password.jsp';");
		                out.println("</script>");
		                return;
		            }


		       
		        try {
		            connection = ConnectionFactory.getConnection();
		            stmt1 = connection.prepareStatement("select password from login where username=?");
		            stmt1.setString(1, user);
		            ResultSet rs=stmt1.executeQuery();
		            if(rs.next()){
		            	pass=rs.getString(1);
		            }
		            if(!pass.equals(opass)){
		            	out.println("<script type=\"text/javascript\">");
		                out.println("alert('Invalid old password.');");
		                out.println("location='user/Change_Password.jsp';");
		                out.println("</script>");
		            }
		            else{
		            	stmt = connection.prepareStatement("update login set password=? where username=?");
			            stmt.setString(1, npass);
			            stmt.setString(2, user);
			            if (stmt.executeUpdate() > 0) {
			                out.println("<script type=\"text/javascript\">");
			                out.println("alert('Password Changed.');");
			                out.println("location='user/user_dashboard.jsp';");
			                out.println("</script>");
			            } else {
			                System.out.println("throwing...");
			                throw new SQLException();
			            }
		            }
		            
		        } catch (SQLException e) {
		            out.println("<script type=\"text/javascript\">");
		            out.println("alert('Password cannot be changed.');");
		            out.println("location='user/user_dashboard.jsp';");
		            out.println("</script>");
		            System.out.println(e);
		        } finally {
		            if (null != connection) {
		                ConnectionFactory.close(connection);
		            }
		            if (null != out) {
		                out.close();
		                out = null;
		            }
		        }
			
		}
		
		else if(role.equals("admin")){

		        
		            if (opass.equals("") || npass.equals("") || cnpass.equals("")) {
		                throw new NullPointerException();
		            }
		            if (!npass.equals(cnpass)) {
		                out.println("<script type=\"text/javascript\">");
		                out.println("alert('New Passwords do not match. Please confirm your new password');");
		                out.println("location='admin/Change_Password.jsp';");
		                out.println("</script>");
		                return;
		            }


		        try {
		            connection = ConnectionFactory.getConnection();
		            stmt1 = connection.prepareStatement("select password from login where username=?");
		            stmt1.setString(1, user);
		            ResultSet rs=stmt1.executeQuery();
		            if(rs.next()){
		            	pass=rs.getString(1);
		            }
		            if(!pass.equals(opass)){
		            	out.println("<script type=\"text/javascript\">");
		                out.println("alert('Invalid old password.');");
		                out.println("location='admin/Change_Password.jsp';");
		                out.println("</script>");
		            }
		            else{
		            	stmt = connection.prepareStatement("update login set password=? where username=?");
			            stmt.setString(1, npass);
			            stmt.setString(2, user);
			            if (stmt.executeUpdate() > 0) {
			                out.println("<script type=\"text/javascript\">");
			                out.println("alert('Password Changed.');");
			                out.println("location='admin/admin_dashboard.jsp';");
			                out.println("</script>");
			            } else {
			                System.out.println("throwing...");
			                throw new SQLException();
			            }
		            }
		            
		        } catch (SQLException e) {
		            out.println("<script type=\"text/javascript\">");
		            out.println("alert('Password cannot be changed.');");
		            out.println("location='admin/admin_dashboard.jsp';");
		            out.println("</script>");
		            System.out.println(e);
		        } finally {
		            if (null != connection) {
		                ConnectionFactory.close(connection);
		            }
		            if (null != out) {
		                out.close();
		                out = null;
		            }
		        }
		}
		
		
	        
	}
}



	


