package com.notify;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.ConnectionFactory;

/**
 * Servlet implementation class Delnote
 */
@WebServlet("/Delnote")
public class Delnote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delnote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		      
	        String id1=request.getParameter("id");
			int id=Integer.valueOf(id1);
			String type=request.getParameter("type");
			
			Connection connection=null;
			
			try{
				
				connection=ConnectionFactory.getConnection();
				PreparedStatement  ps1 = null;
				ps1=connection.prepareStatement("update notify set viewed = ? where id = ?");
				ps1.setInt(1, 1);
				ps1.setInt(2, id);
				int rs=ps1.executeUpdate();
				
				if(rs>=1){
					if(type.equals("journal")){
						response.sendRedirect("Journal/Journal.jsp");
					}
					else if(type.equals("books")){
						response.sendRedirect("Books/Books.jsp");
					}
					else if(type.equals("book_chapter")){
						response.sendRedirect("Book Chapter/Book_Chapter.jsp");
					}
					else if(type.equals("conf_proceedings")){
						response.sendRedirect("Conf. Proceedings/Conf_Proceedings.jsp");
					}
					else if(type.equals("conf_presentations")){
						response.sendRedirect("Conf. Presentations/Conf_Presentations.jsp");
					}
					else if(type.equals("patents")){
						response.sendRedirect("Patents/Patents.jsp");
					}
					else if(type.equals("tech_report")){
						response.sendRedirect("Tech reports/Tech_Report.jsp");
					}
					else if(type.equals("user")){
						response.sendRedirect("user/user_dashboard.jsp");
					}
					return;
				}else{
					PrintWriter out=response.getWriter();
					out.println("<script type=\"text/javascript\">");
					out.println("alert('INVALID REQUEST !');");
					out.println("location='Journal/Journal.jsp';");
					out.println("</script>");
					
				}
                
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
