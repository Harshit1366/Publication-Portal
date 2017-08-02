package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
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
		Connection connection=null;
		String user=null;
		 PrintWriter out = response.getWriter();
		try {
			
			 connection=ConnectionFactory.getConnection();
			String name = request.getParameter("name");
			String desg = request.getParameter("desg");
			String email = request.getParameter("InputEmail");
			String contact = request.getParameter("cont");
			long cont=Long.parseLong(contact);
			String dob = request.getParameter("dob");
			String username = request.getParameter("username");
			String password = request.getParameter("pass");
			//String confirm = request.getParameter("cp");
			
		
			try { 
				PreparedStatement ps2 = connection.prepareStatement("select username from login");
				ResultSet rs2 = ps2.executeQuery();
				while(rs2.next()){
             	   user=rs2.getString("username");
             	
                }
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			if(user.equals(username)){
				  out.println("<script type=\"text/javascript\">");
		          out.println("alert('The username already exists. Please choose a different one!');");
		          //out.println("location='login/register.jsp?N=<%=%>&Dg='desg'&E='email'&C='contact'&D='dob'&U='username'&P='password'&CP='confirm'';");
		          out.println("</script>");
		          //response.sendRedirect("login/register.jsp?N=name&Dg=desg&E=email&C=contact&D=dob&U=username&P=password&CP=confirm");
		          out.close();
		          //return;
		          
         	}
			/*else if(!password.equals(confirm)){
				 out.println("<script type=\"text/javascript\">");
		          out.println("alert('Passwords do not match.');");
		          out.println("location='login/register.jsp';");
		          out.println("</script>");
		          out.close();
		          return;
				
			}*/
			else{
				
			
//				String nam="[a-zA-z ]+";
//				
//				Pattern p=Pattern.compile(ex);
//				Matcher m=p.matcher(contact);
//				Pattern p1=Pattern.compile(em);
//				Matcher m1=p1.matcher(email);
//				Pattern p2=Pattern.compile(nam);
//				Matcher m2=p2.matcher(desg);
//				Pattern p4=Pattern.compile(nam);
//				Matcher m3=p4.matcher(name);
//				Pattern p3=Pattern.compile(pas);
//				Matcher m4=p3.matcher(password);
//				
//				if(!m.matches()){
//					 out.println("<script type=\"text/javascript\">");
//			          out.println("alert('Please enter a valid contact number.');");
//			          out.println("location='login/register.jsp';");
//			          out.println("</script>");
//			          out.close();
//			          return;
//				}
//				else if(!m1.matches()){
//					out.println("<script type=\"text/javascript\">");
//			          out.println("alert('Please enter a email address.');");
//			          out.println("location='login/register.jsp';");
//			          out.println("</script>");
//			          out.close();
//			          return;
//				}
//				else if(!m2.matches()){
//					out.println("<script type=\"text/javascript\">");
//			          out.println("alert('Please enter a valid designation.');");
//			          out.println("location='login/register.jsp';");
//			          out.println("</script>");
//			          out.close();
//			          return;
//				}
//				else if(!m3.matches()){
//					out.println("<script type=\"text/javascript\">");
//			          out.println("alert('Please enter a valid name.');");
//			          out.println("location='login/register.jsp';");
//			          out.println("</script>");
//			          out.close();
//			          return;
//				}
//				else if(!m4.matches()){
//						out.println("<script type=\"text/javascript\">");
//				          out.println("alert('Please enter a valid password. Make sure you include a "
//				          		+ "small alphabet, a capital alphabet, a numeral and a special character.');");
//				          out.println("location='login/register.jsp';");
//				          out.println("</script>");
//				          out.close();
//				          return;
//					}
//				
//				else{
//					
					 PreparedStatement ps1 = connection.prepareStatement("insert into login(Username,Password,Role) values (?,?,?)");
				        ps1.setString(1, username);
						ps1.setString(2, password);
						ps1.setString(3, "user");
				    System.out.println(ps1.executeUpdate());
				
				PreparedStatement ps3 = connection.prepareStatement("insert into register(Name,Designation,Email_Id,Contact_No,"
						+ "DOB,Username) values (?,?,?,?,?,?)");
				ps3.setString(1, name);
				ps3.setString(2, desg); 
		        ps3.setString(3, email); 
				ps3.setLong(4, cont);
				ps3.setString(5, dob); 
				ps3.setString(6, username);
		      System.out.println(ps3.executeUpdate());

				response.sendRedirect("login.jsp");
				return;
				}
			//	}
	/*	if(name.equals("")){
			 out.println("<script type=\"text/javascript\">");
          out.println("alert('Please fill your name !');");
          //out.println("location='first.jsp';");
          out.println("</script>");
          out.close();
          return;
		}
		else if(desg.equals("")){
			 out.println("<script type=\"text/javascript\">");
         out.println("alert('Please fill your gender !');");
         //out.println("location='first.jsp';");
         out.println("</script>");
         out.close();
         return;
		}
		else if(email.equals("")){
			 out.println("<script type=\"text/javascript\">");
         out.println("alert('Please fill your Email-Address !');");
         //out.println("location='first.jsp';");
         out.println("</script>");
         out.close();
         return;
		}
		else if(contact.equals("")){
			 out.println("<script type=\"text/javascript\">");
         out.println("alert('Please type your contact number !');");
         //out.println("location='first.jsp';");
         out.println("</script>");
         out.close();
         return;
		}                       */
			
			
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(NullPointerException ne){
		ne.getStackTrace();
	}finally{
		out.close();
	}
	}

	}


